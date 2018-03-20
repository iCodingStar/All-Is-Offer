package cn.codingstar.offer.database.timeout;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ConnectionPool.java
 * @time: 18-3-20 上午9:34
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }


    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后需要通知，这样其他消费者能够感知到连接池已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 在millis无法获得一个连接将返回null
     *
     * @param millis
     */
    public Connection getConnection(long millis) throws InterruptedException {
        synchronized (pool) {
            if (millis <= 0) {
                // 完全超时
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                // 如果millis大于0，意味着只阻塞millis事件
                long future = System.currentTimeMillis() + millis;
                long remaining = millis;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!pool.isEmpty()) {
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }

}
