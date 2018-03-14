package cn.codingstar.offer.io.nio.echo;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoServer.java
 * @time: 18-3-14 下午2:51
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class EchoServer {

    private static int DEFAULT_PORT = 2048;
    private static EchoServerHandler serverHandler;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandler != null) {
            serverHandler.stop();
        }
        serverHandler = new EchoServerHandler(port);
        new Thread(serverHandler, "Worker").start();
    }

    public static void main(String[] args) {
        start();
    }
}
