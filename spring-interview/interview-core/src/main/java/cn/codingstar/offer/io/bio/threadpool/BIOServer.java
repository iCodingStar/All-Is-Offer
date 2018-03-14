package cn.codingstar.offer.io.bio.threadpool;

import cn.codingstar.offer.io.bio.ServerHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BIOServer.java
 * @time: 18-3-14 上午10:30
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: BIO 服务端代码
 */
public class BIOServer {
    // 服务端端口
    private static int SERVER_PORT = 9999;
    // 单例的ServerSocket
    private static ServerSocket server;

    private static ExecutorService executorService = Executors.newFixedThreadPool(50);

    //调用默认的启动BIO服务器的方法
    public static void start() {
        start(SERVER_PORT);
    }

    /**
     * 根据传入的端口号启动BIO服务器
     * 这个方法不会被大量并发访问，不太需要考虑效率，直接进行方法同步就行了
     *
     * @param port
     */
    public static synchronized void start(int port) {
        if (server != null) {
            return;
        }
        try {
            // 通过构造函数创建ServerSocket
            // 如果端口号合法且空闲，就可以监听成功
            server = new ServerSocket(port);
            System.out.println("BIO服务器已经启动，端口号：" + port);
            // 通过无限循环监听客户端的连接
            // 如果没有客户端接入，无限阻塞在accept()方法调用上
            while (true) {
                // 类似c语言，返回成功连接的Socket的文件描述符
                Socket socket = server.accept();
                // 当有新连接进来的时候，会执行下面的代码
                // 创建一个新的线程处理新的连接
                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("服务器收到新连接：" + socketAddress.getHostName() + ":" + socketAddress.getPort());
                //new Thread(new ServerHandler(socket)).start();
                executorService.execute(new ServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                    System.out.println("服务器已经关闭");
                    // 有助于垃圾回收
                    server = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        start();
    }
}
