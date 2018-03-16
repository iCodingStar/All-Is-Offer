package cn.codingstar.offer.lock;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SpinLock.java
 * @time: 18-3-16 下午9:51
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 自旋锁是采用让当前线程不停地的在循环体内执行实现的，当循环的条件被其他线程改变时 才能进入临界区。
 */

import java.util.concurrent.atomic.AtomicReference;

/**
 * 利用CAS实现自旋锁，利用一个volatile共享变量来实现锁的控制
 */
public class SpinLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();

    /**
     * 获得锁
     */
    public void lock() {
        // 通过让当前线程
        Thread current = Thread.currentThread();
        // 所有持有这把锁的线程，在此都会这样的不断尝试去获得锁，指到锁的持有者释放了锁
        while (!sign.compareAndSet(null, current)) {

        }
    }

    /**
     * 通过CAS的方式释放锁
     */
    public void unlock() {
        Thread current = Thread.currentThread();
        sign.compareAndSet(current, null);
    }
}
