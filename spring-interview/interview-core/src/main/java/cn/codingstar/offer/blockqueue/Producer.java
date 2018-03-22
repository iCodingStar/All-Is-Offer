package cn.codingstar.offer.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Producer.java
 * @time: 18-3-22 下午3:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Producer implements Runnable {

    private BlockingQueue<String> queue;

    private AtomicInteger counter;

    public Producer(BlockingQueue<String> queue, AtomicInteger counter) {
        this.queue = queue;
        this.counter = counter;
    }


    @Override
    public void run() {
        // 如果队列满，阻塞

        synchronized (queue) {
            String product = Thread.currentThread() + " make product  " + counter.incrementAndGet();
            try {
                System.out.println(product);
                queue.put(product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
