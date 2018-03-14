package cn.codingstar.offer.io.nio.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EchoClientHandler.java
 * @time: 18-3-14 下午3:55
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class EchoClientHandler implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean started;

    public EchoClientHandler(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        // 创建选择器
        selector = Selector.open();
        // 打开监听通道
        socketChannel = SocketChannel.open();
        // 将通道设置为非阻塞模式
        socketChannel.configureBlocking(false);

        started = true;
        System.out.println("客户端已经启动...");
    }

    public void stop() {
        started = false;
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端连接服务器异常...");
        }

        //循环遍历selector
        while (started) {
            // 无论是否有读写事件发生，selector每1秒被唤醒一次
            try {
                selector.select(1000);

                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                // 循环遍历处理每一个已经准备好的事件
                Iterator<SelectionKey> it = selectionKeys.iterator();

                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    // 处理事件
                    doHandle(key);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        if (selector != null) {
            try {
                // selector 关闭后会自动释放资源
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     */
    public void doConnect() throws IOException {
        if (socketChannel.connect(new InetSocketAddress(host, port))) {
            System.out.println("客户端与服务器[" + this.host + ":" + this.port + "]建立连接...");
        } else {
            // 如果连接失败，则向Selector注册连接事件
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }

    public void doHandle(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (socketChannel.finishConnect()) {
                    // ignore
                } else {
                    System.exit(1);
                }
            }
            if (key.isReadable()) {
                // 创建ByteBuffer，开辟一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                // 读取请求码流，返回读取的字节
                int readBytes = socketChannel.read(buffer);
                // 读到字节，对字节进行编解码
                if (readBytes > 0) {
                    // 将缓冲区的limit设置为position=0,用于后续对缓冲区的读取操作
                    buffer.flip();
                    // 根据缓冲区可读字节创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    // 将缓冲区可读字节数组复制到新的数组中
                    buffer.get(bytes);
                    String result = new String(bytes, "UTF-8");
                    // 获取服务器信息
                    InetSocketAddress address = (InetSocketAddress) socketChannel.getRemoteAddress();
                    System.out.println("服务器[" + address.getHostName() + ":" + address.getPort() + "] > " + result);

                } else if (readBytes == 0) {
                    // ignore : 缓冲区没有数据
                } else {
                    key.cancel();
                    socketChannel.close();
                }
            }
        }
    }

    /**
     * 向服务器发送消息
     *
     * @param message
     */
    public void senMessage(String message) throws IOException {
        //向Selector注册写入事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel, message);
    }

    /**
     * 异步执行写任务
     *
     * @param socketChannel
     * @param request
     */
    private void doWrite(SocketChannel socketChannel, String request) throws IOException {
        //将消息编码为字节数组
        byte[] bytes = request.getBytes();
        // 根据数组容量创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        // 将字节数组拷贝至缓冲区
        buffer.put(bytes);
        // flip操作
        buffer.flip();
        // 发送缓冲区字节数组
        socketChannel.write(buffer);
    }
}
