package cn.codingstar.offer.io.bio;

import org.omg.PortableServer.POA;

import java.io.*;
import java.net.Socket;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BioClient.java
 * @time: 18-3-14 上午11:13
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 同步阻塞IO客户端
 */
public class BioClient {

    private static String HOST = "localhost";
    private static int SERVER_PORT = 9999;

    public Socket start() {
        return start(HOST, SERVER_PORT);
    }

    public Socket start(String host) {
        return start(host, SERVER_PORT);
    }

    public Socket start(String host, int port) {
        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    public void sendMessage(Socket socket, String message) {
        System.out.println("send message ->");
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(message);
            System.out.println("收到消息：" + reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void main(String[] args) {
        BioClient client = new BioClient();
        Socket socket = client.start("localhost", 9999);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String message = reader.readLine();
                client.sendMessage(socket, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
