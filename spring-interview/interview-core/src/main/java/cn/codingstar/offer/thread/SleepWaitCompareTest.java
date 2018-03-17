package cn.codingstar.offer.thread;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SleepWaitCompareTest.java
 * @time: 18-3-17 上午10:34
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: java中sleep与wait的区别
 */
public class SleepWaitCompareTest {

    static class WaitTask implements Runnable {

        @Override
        public void run() {
            synchronized (SleepWaitCompareTest.class) {
                System.out.println("Execute WaitTask ...");
                System.out.println("WaitTask is going to wait for sometime ...");
                try {
                    SleepWaitCompareTest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("WaitTask recover running status ... ");
                System.out.println("WaitTask is over !");
            }
        }
    }

    static class SleepTask implements Runnable {

        @Override
        public void run() {
            synchronized (SleepWaitCompareTest.class) {
                System.out.println("Execute SleepTask ...");
                System.out.println("SleepTask is going to sleep for 10 seconds ...");
                SleepWaitCompareTest.class.notify();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("SleepTask wakeup now ...");
                System.out.println("SleepTask is over !");
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread sleep = new Thread(new SleepTask());
        Thread wait = new Thread(new WaitTask());
        wait.start();
        Thread.sleep(3000);
        sleep.start();
    }
}
