package cn.codingstar.offer.io.aio;

import cn.codingstar.offer.io.aio.handler.AsyncServerHandler;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AIOServer.java
 * @time: 18-3-14 下午4:49
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://blog.anxpp.com/index.php/archives/895/
 * @desc: 异步服务器
 */
public class AIOServer {

    private static int DEFAULT_PORT = 9999;
    private static AsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            return;
        serverHandle = new AsyncServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        AIOServer.start();
    }

}
