package cn.codingstar.offer.io.bio;

import cn.codingstar.offer.io.util.Calculator;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ServerHandler.java
 * @time: 18-3-14 上午10:43
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 客户端消息处理线程
 */
public class ServerHandler implements Runnable {

    private Socket socket;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread() + " starting response the request ....");
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            String expression;
            String result;
            while (true) {
                // 通过BuffedReader读取一行
                // 如果已经到输入流的尾部，返回null,退出循环
                // 如果得到非空值，就尝试计算结果并返回
                if ((expression = reader.readLine()) == null) break;
                // 必须使用toString()
                if (expression.toString().equals("quit")) {
                    System.out.println("客户端请求关闭连接");
                    reader.close();
                    writer.close();
                    socket.close();
                }
                InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println(socketAddress.getHostName() + ":" + socketAddress.getPort() + "消息 -> " + expression);
                result = Calculator.cal(expression);
                writer.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 做一些必要的清理工作
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reader = null;
            }

            if (writer != null) {
                writer.close();
                writer = null;
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
