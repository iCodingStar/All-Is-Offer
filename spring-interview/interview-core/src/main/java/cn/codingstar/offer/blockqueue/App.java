package cn.codingstar.offer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: App.java
 * @time: 18-3-22 下午3:30
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class App {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
        AtomicInteger counter = new AtomicInteger(0);
        for (int i = 0; i < 5; i++) {
            new Thread(new Producer(queue, counter), "Thread " + i).start();
            new Thread(new Customer(queue), "Thread " + i).start();
        }
    }
}
