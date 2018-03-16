package cn.codingstar.offer.lock.reentrant;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: UserReentrantLock.java
 * @time: 18-3-16 下午10:21
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class UserReentrantLock {

    private boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        // 如果已经被锁住，并且不是当前的线程
        while (isLocked && lockedBy != currentThread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = currentThread;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        // 相对来说，可重入就意味着：线程可以进入任何一个它已经拥有的锁所同步着的代码块。
    }
}
