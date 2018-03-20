package cn.codingstar.offer.thread.http;

import cn.codingstar.offer.thread.pool.DefaultThreadPool;
import cn.codingstar.offer.thread.pool.ThreadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketOptions;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SimpleHttpServer.java
 * @time: 18-3-20 上午11:04
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 基于线程池技术的Http web服务器
 */
public class SimpleHttpServer {

    static ThreadPool<HttpRequestHandler> pool = new DefaultThreadPool<>(1);

    static String basePath;

    static ServerSocket serverSocket;

    static int port = 8080;

    public static void setPort(int port) {
        SimpleHttpServer.port = port;
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    // 启动Http server
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            // 接收一个客户端请求，生成一个HttpRequestHandler,交给线程池处理
            pool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable {

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                // 获得socket输入流
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                // 由相对路径计算出绝对路径
                String filePath = basePath + header.split(" ")[1];
                // 获得socket输出流
                out = new PrintWriter(socket.getOutputStream());

                // 如果请求的资源为jpg或ico,读取资源并输出
                if (filePath.endsWith(".jpg") || filePath.endsWith(".ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream bo = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        bo.write(i);
                    }
                    byte[] array = bo.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Star");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println();

                    // 这里为什么要这样写呢
                    socket.getOutputStream().write(array, 0, array.length);

                } else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Star");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println();
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                try {
                    close(br, in, reader, out, socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void close(Closeable... closeables) throws IOException {
            for (Closeable closeable : closeables) {
                closeable.close();
            }
        }
    }
}
