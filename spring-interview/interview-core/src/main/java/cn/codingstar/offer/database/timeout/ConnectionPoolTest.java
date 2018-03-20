package cn.codingstar.offer.database.timeout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ConnectionPoolTest.java
 * @time: 18-3-20 上午9:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);

    // 保证所有ConnectionRunner都能够同时开始
    static CountDownLatch start = new CountDownLatch(1);

    // main线程将会等所有的ConnectionRunner运行结束后才能停止
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        // 线程数量，可以修改它进行观察
        int threadCount = 100;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "Connection-" + i);
            thread.start();
        }

        // 保证所有的线程同时开始运行run方法逻辑
        start.countDown();
        // 等待所有的线程执行结束
        end.await();
        System.out.println("total invoke : " + (threadCount * count));
        System.out.println("total got : " + got);
        System.out.println("total not got : " + notGot);
    }

    static class ConnectionRunner implements Runnable {

        private int count;
        private AtomicInteger got;
        private AtomicInteger notGot;

        /**
         * @param count
         * @param got
         * @param notGot
         */
        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                //
                System.out.println("线程" + Thread.currentThread() + "已经就绪...");
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 从线程池获取连接，如果1000ms内无法获取到，将会返回null
            // 分别统计连接获取的数量got和连接未获取的数量notGot
            while (count > 0) {
                // 每个线程获取count次连接
                try {
                    Connection connection = pool.getConnection(10);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            System.out.println("线程" + Thread.currentThread() + "运行结束...");
            end.countDown();
        }
    }
}
