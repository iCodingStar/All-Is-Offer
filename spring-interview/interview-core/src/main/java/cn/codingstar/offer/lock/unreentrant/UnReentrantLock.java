package cn.codingstar.offer.lock.unreentrant;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UnReentrantLock.java
 * @time: 18-3-16 下午10:14
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 不可重入锁
 */
public class UnReentrantLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        // 如果显示已经锁着，阻塞自己
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
