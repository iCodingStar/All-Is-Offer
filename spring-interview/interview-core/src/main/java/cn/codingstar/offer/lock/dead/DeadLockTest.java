package cn.codingstar.offer.lock.dead;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: DeadLockTest.java
 * @time: 18-3-17 下午2:48
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 死锁测试
 */
public class DeadLockTest {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new DeadLockTaskA(), "t1");
        Thread t2 = new Thread(new DeadLockTaskB(), "t2");
        t1.start();
        t2.start();
    }

    private class DeadLockTaskA implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "is trying to get lock A");
            synchronized (A) {
                System.out.println(Thread.currentThread() + "own lock A");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "is trying to get lock B");
                synchronized (B) {
                    System.out.println(Thread.currentThread() + "own lock B");
                    System.out.println(Thread.currentThread() + "is trying to release lock B");
                }
                System.out.println(Thread.currentThread() + "is released lock B");
                System.out.println(Thread.currentThread() + "is trying to release lock A");
            }
            System.out.println(Thread.currentThread() + " released lock A");
        }

    }

    private class DeadLockTaskB implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "is trying to get lock B");
            synchronized (B) {
                System.out.println(Thread.currentThread() + "own lock B");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "is trying to get lock A");
                synchronized (A) {
                    System.out.println(Thread.currentThread() + "own lock A");
                    System.out.println(Thread.currentThread() + "is trying to release lock A");
                }
                System.out.println(Thread.currentThread() + "is released lock A");
                System.out.println(Thread.currentThread() + "is trying to release lock B");
            }
            System.out.println(Thread.currentThread() + " released lock B");
        }

    }
}
