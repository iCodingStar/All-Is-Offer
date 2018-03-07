package cn.codingstar.offer.cache;

import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MemcacheManager {

    /**
     * 单例模式实现MemcacheManager
     */
    private static MemcacheManager manager = new MemcacheManager();

    private static MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));

    private static MemcachedClient client = null;

    /** 初始化加载客户端MemCache信息 */
    static {
        /*设置二进制保存文件*/
        builder.addAuthInfo(AddrUtil.getAddresses("127.0.0.1:11211").get(0), AuthInfo.plain("root", ""));
        builder.setCommandFactory(new BinaryCommandFactory());
        /*设置客户端连接数*/
        builder.setConnectionPoolSize(1);

        try {
            client = builder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MemcacheManager() {
    }

    public static MemcacheManager getInstance() {
        return manager;
    }

    /**
     * 往memcached添加数据
     *
     * @param key
     * @param expire
     * @param value
     * @throws InterruptedException
     * @throws MemcachedException
     * @throws TimeoutException
     */
    public void set(String key, int expire, Object value) throws InterruptedException, MemcachedException, TimeoutException {
        client.set(key, expire, value);
    }

    /**
     * 从memcached读取数据
     *
     * @param key
     * @return
     * @throws InterruptedException
     * @throws MemcachedException
     * @throws TimeoutException
     */
    public Object get(String key) throws InterruptedException, MemcachedException, TimeoutException {
        return client.get(key);
    }

    /**
     * MemCache通过compare and set即cas协议实现原子更新，类似乐观锁，每次请求存储某个数据都要附带一个cas值，MemCache
     * 比对这个cas值与当前存储数据的cas值是否相等，如果相等就覆盖老数据，如果不相等就认为更新失败，这在并发环境下特别有用
     */
    public boolean update(String key, Object o) throws InterruptedException, MemcachedException, TimeoutException {
        GetsResponse<String> response = client.get(key);
        long cas = response.getCas();
        if (!client.cas(key, 0, o, cas)) {
            return false;
        }
        return true;
    }
}
