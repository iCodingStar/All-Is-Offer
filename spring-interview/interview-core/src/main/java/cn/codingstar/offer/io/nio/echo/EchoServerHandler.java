package cn.codingstar.offer.io.nio.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoServerHandler.java
 * @time: 18-3-14 下午2:51
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: NIO服务端
 */
public class EchoServerHandler implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean started;


    /**
     * 构造函数
     *
     * @param port
     */
    public EchoServerHandler(int port) {
        try {
            // 创建选择器
            selector = Selector.open();
            // 打开监听通道
            serverSocketChannel = ServerSocketChannel.open();

            // true : 阻塞 ； false : 非阻塞
            serverSocketChannel.configureBlocking(false);
            // 绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            // 监听客户端连接请求
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 标记服务器已经开启
            started = true;
            System.out.println("Server started at port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.started = false;
    }


    @Override
    public void run() {
        // 循环便利Selector
        while (started) {
            try {
                // 无论是否有读写事件发生，selector每1秒被唤醒一次
                selector.select(1000);
                // 阻塞，只有当至少有一个注册的事件发生的时候才会继续
                //selector.select();

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    it.remove();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理新连接的事件
     *
     * @param key
     */
    public void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            // 处理新接入的请求信息
            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                // 通过ServerSocketChannel的accept()创建SocketChannel实例
                // 完成该操作，意味着TCP三次握手，TCP物理链路正式建立
                SocketChannel socketChannel = serverSocketChannel.accept();
                // 获取客户端的信息
                InetSocketAddress address = (InetSocketAddress) socketChannel.getRemoteAddress();
                System.out.println("与客户端[" + address.getHostName() + ":" + address.getPort() + "]建立连接...");
                // 设置为非阻塞
                socketChannel.configureBlocking(false);
                // 注册为读
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            // 读取消息
            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                // 创建ByteBuffer,开辟一个1M的缓存区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                // 读取请求码流，返回读取到的字节数
                int readBytes = socketChannel.read(buffer);
                // 读取到字节，对字节进行编解码
                if (readBytes > 0) {
                    // 将缓冲区档案的limits设置为position = 0,用于后续对缓冲区的读取操作
                    buffer.flip();
                    // 根据缓冲区可读字节创建
                    byte[] bytes = new byte[buffer.remaining()];
                    // 将缓冲区可读字节数据复制到bytes数组
                    buffer.get(bytes);
                    // 处理数据
                    String message = new String(bytes);
                    // 获取客户端信息
                    InetSocketAddress address = (InetSocketAddress) socketChannel.getRemoteAddress();
                    System.out.println("客户端[" + address.getHostName() + ":" + address.getPort() + "] > " + message);
                    // 相应客户端
                    response(socketChannel, message);
                } else if (readBytes == 0) {
                    // 没有读到数据，忽略
                } else {
                    // 链路已经关闭，释放资源
                    key.cancel();
                    socketChannel.close();
                }
            }
        }
    }

    /**
     * 异步响应客户端
     *
     * @param socketChannel
     * @param response
     */
    public void response(SocketChannel socketChannel, String response) throws IOException {
        // 将消息编码为字节数组
        byte[] bytes = response.getBytes();
        // 根据数组容量创建ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        // 将字节数组复制到缓冲区
        buffer.put(bytes);
        // flip操作
        buffer.flip();
        // 发送缓冲区的字节数组
        socketChannel.write(buffer);
        /**
         * 此处不包含写半包的代码
         */
    }
}
