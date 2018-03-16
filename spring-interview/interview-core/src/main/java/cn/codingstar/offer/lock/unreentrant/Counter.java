package cn.codingstar.offer.lock.unreentrant;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Counter.java
 * @time: 18-3-16 下午10:17
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Counter {

    UnReentrantLock lock = new UnReentrantLock();

    public void print() throws InterruptedException {
        lock.lock();

    }

    public void doAdd() throws InterruptedException {
        lock.lock();
        // do Something
        lock.unlock();
    }

    public static void main(String[] args) {
        // 当调用print()方法时，获得了锁，这时就无法再调用doAdd()方法，
        // 这时必须先释放锁才能调用，所以称这种锁为不可重入锁，也叫自旋锁。
    }
}
