package cn.codingstar.offer.blockqueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Customer.java
 * @time: 18-3-22 下午3:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 消费者
 */
public class Customer implements Runnable {

    // 阻塞队列
    private BlockingQueue<String> queue;

    public Customer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        try {
            System.out.print(Thread.currentThread() + " take product : ");
            // 如果队列为空，就阻塞
            String product = queue.take();
            System.out.println(product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
