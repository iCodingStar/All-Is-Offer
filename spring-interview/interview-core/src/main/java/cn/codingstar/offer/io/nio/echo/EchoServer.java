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
        /**
         1. 打开ServerSocketChannel，监听客户端连接
         2. 绑定监听端口，设置连接为非阻塞模式
         3. 创建Reactor线程，创建多路复用器并启动线程
         4. 将ServerSocketChannel注册到Reactor线程中的Selector上，监听ACCEPT事件
         5. Selector轮询准备就绪的key
         6. Selector监听到新的客户端接入，处理新的接入请求，完成TCP三次握手，简历物理链路
         7. 设置客户端链路为非阻塞模式
         8. 将新接入的客户端连接注册到Reactor线程的Selector上，监听读操作，读取客户端发送的网络消息
         9. 异步读取客户端消息到缓冲区
         10. 对Buffer编解码，处理半包消息，将解码成功的消息封装成Task
         11. 将应答消息编码为Buffer，调用SocketChannel的write将消息异步发送给客户端
         */
    }
}
