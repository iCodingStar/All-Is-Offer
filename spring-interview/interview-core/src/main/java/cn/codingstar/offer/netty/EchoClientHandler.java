package cn.codingstar.offer.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoClientHandler.java
 * @time: 18-3-11 下午3:16
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
@ChannelHandler.Sharable
public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(EchoClient.class.getName());

    private final ByteBuf firstMessage;

    public EchoClientHandler(int firstMessageSize) {
        if (firstMessageSize < 0) {
            throw new IllegalArgumentException("firstMessageSize: " + firstMessageSize);
        }
        firstMessage = Unpooled.buffer(firstMessageSize);
        for (int i = 0; i < firstMessageSize; i++) {
            firstMessage.writeByte(i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Thread.sleep(2);
        System.out.println("EchoServer : " + msg);
        //TimeUnit.SECONDS.sleep(2);
//        while (true) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            StringBuilder data = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                data.append(line);
//            }
//            ByteBuf buf = Unpooled.buffer(data.length());
//            buf.writeBytes(data.toString().getBytes());
//            ctx.write(msg);
//        }
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.log(Level.WARNING, "Unexpected exception from downstream");
        ctx.close();
    }
}
