package cn.codingstar.offer.nio.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ChannelBufferTest.java
 * @time: 18-3-11 上午11:00
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:  https://www.jianshu.com/p/052035037297
 * @desc: 测试java NIO中的Channel和Buffer
 */
public class ChannelBufferTest {

    public static void main(String[] args) throws IOException {
        /**
         * 在项目根目录下创建文件
         */
        File file = new File("random");
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println(file.getAbsoluteFile());
        File fileName = new File(file, "data.txt");
        if (!fileName.exists()) {
            file.createNewFile();
        }
        /**
         * 删除文件
         */
        if (file.exists()) {
            file.deleteOnExit();
        }
        if (fileName.exists()) {
            fileName.deleteOnExit();
        }

        String path = ChannelBufferTest.class.getClassLoader().getResource("data.txt").getPath();
        System.out.println(path);

        RandomAccessFile targetFile = new RandomAccessFile(path, "rw");
        FileChannel channel = targetFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(32);
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("Read : " + bytesRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            System.out.println();
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
    }
}
