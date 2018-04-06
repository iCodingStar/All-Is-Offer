package cn.codingstar.test.toutiao.pc;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Farmer.java
 * @time: 18-4-3 下午9:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Farmer {

    public static void main(String[] args) {
        final int CONSUMER_SIZE = 3;
        final int PRODUCER_SIZE = 3;
        Storage storage = new Storage();
        for (int i = 0; i < PRODUCER_SIZE; i++) {
            Thread thread = new Thread(new Producer("producer_" + (i + 1), storage));
            thread.start();
        }
        for (int i = 0; i < CONSUMER_SIZE; i++) {
            Thread thread = new Thread(new Customer("customer_" + (i + 1), storage));
            thread.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
