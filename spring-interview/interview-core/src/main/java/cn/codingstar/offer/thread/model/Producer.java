package cn.codingstar.offer.thread.model;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Producer.java
 * @time: 18-4-2 上午11:10
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    private BlockingQueue<PCData> queue;// 内存缓冲区

    private static AtomicInteger counter = new AtomicInteger(0); // 总数，原子操作

    private static final int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        PCData data = null;
        Random random = new Random();
        try {
            while (isRunning) {
                Thread.sleep(SLEEP_TIME);
                data = new PCData(counter.incrementAndGet());
                System.out.println(data + "加入队列");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println(data + "加入队列失败");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
