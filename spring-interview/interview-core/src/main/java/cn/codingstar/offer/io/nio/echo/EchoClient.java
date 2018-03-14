package cn.codingstar.offer.io.nio.echo;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoClient.java
 * @time: 18-3-14 下午2:51
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class EchoClient {

    private static String DEFAULT_HOST = "127.0.0.1";
    private static int DEFAULT_PORT = 2048;
    private static EchoClientHandler handler;

    public static void start() {
        start(DEFAULT_HOST, DEFAULT_PORT);
    }

    public static void start(String host) {
        start(host, DEFAULT_PORT);
    }

    public static synchronized void start(String host, int port) {
        if (handler != null) {
            handler.stop();
        }
        try {
            handler = new EchoClientHandler(host, port);
            new Thread(handler, "Client").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 向服务器发送消息
     *
     * @param message
     * @return
     */
    public static boolean sendMessage(String message) throws IOException {
        if (message.equals("quit")) {
            return false;
        }
        handler.senMessage(message);
        return true;
    }


    public static void main(String[] args) throws IOException {
        // 启动客户端
        EchoClient.start();
        // 发送信息
        while (EchoClient.sendMessage(new Scanner(System.in).nextLine())) ;
    }
}
