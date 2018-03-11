package cn.codingstar.offer.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SimpleServer.java
 * @time: 18-3-11 上午11:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class SimpleServer {

    private static final int port = 8888;
    private static final int bufSize = 64;

    public static void main(String[] args) throws IOException {

        /**
         * 创建一个ServerSocketChannel
         */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        /**
         * 设置使用非阻塞IO
         */
        serverSocketChannel.configureBlocking(false);

        /**
         * 绑定端口号
         */
        serverSocketChannel.socket().bind(new InetSocketAddress(port));

        /**
         * 创建一个Selector
         */
        Selector selector = Selector.open();
        /**
         * 注册serverSocketChannel到selector
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 如果没有准备好的Socket,select方法会被阻塞一段时间并返回0
            // 如果有准备好的Socket,select方法会返回准备好的socket的个数
            int n = selector.select();
            if (n == 0) {
                continue;
            }

            Iterator<SelectionKey> its = selector.selectedKeys().iterator();
            while (its.hasNext()) {
                SelectionKey key = its.next();
                /**
                 * 如果是可接受事件
                 */
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                    socketChannel.configureBlocking(false);
                    /**
                     * 将选择器注册到连接客户端的信道
                     * 并指定信道key值得属性为可读
                     * 同时为该信道指定关联附件
                     */
                    socketChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
                }
                if (key.isReadable()) {

                }
                if (key.isWritable()) {

                }
                if (key.isConnectable()) {

                }
                if (key.isValid()) {

                }
            }
        }

    }
}
