package cn.codingstar.offer.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoServer.java
 * @time: 18-3-11 下午2:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://www.jianshu.com/p/1123c9164e3e
 * @desc:
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        // configure the server
        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup(20);
        try {

            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 100)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            // add user handler
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast(new EchoServerHandler());
                        }
                    });
            // start the server
            System.out.println("EchoServer starting at port : " + port);
            ChannelFuture future = bootstrap.bind(port).sync();
            // Wait until the server socket is closed
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer(8888);
        server.start();
    }
}
