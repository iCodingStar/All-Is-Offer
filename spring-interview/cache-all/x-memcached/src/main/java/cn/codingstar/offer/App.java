package cn.codingstar.offer;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeoutException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, MemcachedException, TimeoutException {
        // 本地连接 Memcached 服务
        MemcachedClient mcc = new XMemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
        System.out.println("Connection to server sucessful.");
        mcc.set("123",123,"123");
        System.out.printf(mcc.get("123"));

        // 关闭连接
        mcc.shutdown();
    }
}
