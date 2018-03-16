package cn.codingstar.offer.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoServerHandler.java
 * @time: 18-3-11 下午2:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    private static final Logger logger = Logger.getLogger(EchoServerHandler.class.getName());

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 如果是“quit”,断开连接
        if (msg.toString().toLowerCase().equals("quit")) {
            ctx.write(Unpooled.copiedBuffer("Good Bye _^^_".getBytes()));
            ctx.close();
        }
        Thread.sleep(1);
        // 将读取到的信息返回
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.log(Level.WARNING, "Unexpected exception from downstream", cause);
        ctx.close();
    }
}
