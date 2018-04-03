package cn.codingstar.offer.thread.model;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Consumer.java
 * @time: 18-4-2 上午11:19
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;

    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id : " + Thread.currentThread().getId());
        Random random = new Random();
        while (true) {
            try {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getValue();
                    System.out.println(MessageFormat.format("{0} * {1} * {2}", re));
                    Thread.sleep(SLEEP_TIME);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
