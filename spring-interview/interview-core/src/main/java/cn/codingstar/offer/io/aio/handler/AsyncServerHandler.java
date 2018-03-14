package cn.codingstar.offer.io.aio.handler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AsyncServerHandler.java
 * @time: 18-3-14 下午4:52
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class AsyncServerHandler implements Runnable {

    public CountDownLatch latch;
    public AsynchronousServerSocketChannel serverSocketChannel;

    public AsyncServerHandler(int port) {
        try {
            // 创建服务器通道
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            // 绑定通道
            serverSocketChannel.bind(new InetSocketAddress(port));
            //
            System.out.println("异步服务器已经启动-> localhost:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        /**
         * CountDownLatch初始化
         * 在完成一组正在执行的操作之前，允许当前的线程一直阻塞
         * 此处让线程一直在此阻塞，防止服务器完成之后退出
         * 也可以用while(true) + sleep
         * 服务器需要一直运行
         */
        latch = new CountDownLatch(1);
        // 用于接收客户端的连接
        //serverSocketChannel.accept(this,new AcceptHandler());

        try {
            // 在此阻塞
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
