package cn.codingstar.offer.lock.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Counter.java
 * @time: 18-3-16 下午8:56
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Counter {

    private AtomicInteger safeValue = new AtomicInteger(0);
    private Integer value = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3000; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100000000; j++) {
                        cas.casCount();
                        cas.count();
                    }
                }
            });
            list.add(t);
        }

        /**
         * 逐个启动线程
         */
        for (Thread thread : list) {
            thread.start();
        }

        // 等待所有线程执行完成
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(cas.safeValue);
        System.out.println(cas.value);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用cas实现线程安全的count
     */
    private void casCount() {
        for (; ; ) {
            int i = safeValue.get();
            boolean suc = safeValue.compareAndSet(i, ++i);
            // 如果通过cas更新失败，就
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全的加数器
     */
    private void count() {
        value++;
    }

}
