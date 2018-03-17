# Java核心问题

## 锁
* 应用：用锁来保证原子性

### 原子性与原子操作
[原子操作和竞争](http://www.infoq.com/cn/articles/atomic-operations-and-contention)
* 概念：计算机最重要的构成单位是原子操作。原子操作是一种不可细分的操作，或者在系统中的其他处理器看来是不可再分了。
* 例子：(counter ++)两个处理器对同一个变量进行读取，写入操作。最终计数器只被加了一次。其中一个运算丢失了。
* 作用：原子操作可以防止上面的问题，原子操作让多条指令像执行一条指令一样，在其进行运算的时候，其他的CPU无法插手。
* 实现方式：
    * 加锁：在任何时候，只有一个处理器被允许执行一个原子操作，这个处理器在操作前必须先获得锁，操作完之后释放它。这就是x86的
    Lock前缀的作用。加锁会锁住数据总线，非常缓慢，x86试图通过缓存行机制来代替加锁协议。
    * 缓存行：在使用MESI协议及其衍生协议的系统总，为了确保缓存行操作具有原子性，只需要做到以下事情：
        * 保证在正确的地方摆放内存屏障，使内存周边的操作保证正确的顺序；
        * 在读任何东西前先获得缓存行的所有权；
        * 只有当我们在整个原子操作期间一直握有独占权，才可以把结果回写了；
#### CAS实现原子操作
>JVM中的CAS操作正是利用了处理器提供的CMPXCHG指令实现的。自旋CAS实现的基本思路就是循环进行CAS操作直到成功为止。
```java
package cn.codingstar.offer.lock.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Counter.java
 * @time: 18-3-16 下午8:56
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Counter {

    private AtomicInteger safeValue = new AtomicInteger(0);
    private Integer value = new Integer(0);

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        cas.casCount();
                        cas.count();
                    }
                }
            });
            list.add(t);
        }

        /**
         * 逐个启动线程
         */
        for (Thread thread : list) {
            thread.start();
        }

        // 等待所有线程执行完成
        for (Thread thread : list) {
            thread.join();
        }
        System.out.println(cas.safeValue);
        System.out.println(cas.value);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用cas实现线程安全的count
     */
    private void casCount() {
        for (; ; ) {
            int i = safeValue.get();
            boolean suc = safeValue.compareAndSet(i, ++i);
            // 如果通过cas更新失败，就
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全的加数器
     */
    private void count() {
        value++;
    }

}

```
CAS虽然很高效的解决原子操作，但是CAS仍然存在三大问题。ABA问题，循环时间长开销大和只能保证一个共享变量的原子操作。

* ABA问题(缺点)
>ABA问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加一，那么A－B－A 就会变成1A-2B－3A。
>从Java1.5开始JDK的atomic包里提供了一个类AtomicStampedReference来解决ABA问题。这个类的compareAndSet方法作用是首先检查当前引用是否等于预期引用，并且当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。
```java
public boolean compareAndSet

        (V      expectedReference,//预期引用

         V      newReference,//更新后的引用

        int    expectedStamp, //预期标志

        int    newStamp) //更新后的标志
```
* 循环时间长，开销大
> 如果JVM能支持处理器提供的pause指令那么效率会有一定的提升，pause指令有两个作用，第一它可以延迟流水线执行指令（de-pipeline）,使CPU不会消耗过多的执行资源，延迟的时间取决于具体实现的版本，在一些处理器上延迟时间是零。第二它可以避免在退出循环的时候因内存顺序冲突（memory order violation）而引起CPU流水线被清空（CPU pipeline flush），从而提高CPU的执行效率。

* 只能保证一个共享变量的原子操作
当对一个共享变量执行操作时，我们可以使用循环CAS的方式来保证原子操作，但是对多个共享变量操作时，循环CAS就无法保证操作的原子性，这个时候就可以用锁，或者有一个取巧的办法，就是把多个共享变量合并成一个共享变量来操作。比如有两个共享变量i＝2,j=a，合并一下ij=2a，然后用CAS来操作ij。从Java1.5开始JDK提供了AtomicReference类来保证引用对象之间的原子性，你可以把多个变量放在一个对象里来进行CAS操作。

#### 使用锁机制实现原子操作
> 锁机制保证了只有获得锁的线程能够操作锁定的内存区域。JVM内部实现了很多种锁机制，有偏向锁，轻量级锁和互斥锁，有意思的是除了偏向锁，JVM实现锁的方式都用到的循环CAS，当一个线程想进入同步块的时候使用循环CAS的方式来获取锁，当它退出同步块的时候使用循环CAS释放锁。

### 可重入锁与不可重如锁
[参考资料](https://www.cnblogs.com/dj3839/p/6580765.html)
#### 不可重入锁
* Java实现
```java
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
```
当调用print()方法时，获得了锁，这时就无法再调用doAdd()方法，这时必须先释放锁才能调用，所以称这种锁为不可重入锁，也叫自旋锁。

#### 重入锁
* Java实现
```java
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

```
> 第一个线程执行print()方法，得到了锁，使lockedBy等于当前线程，也就是说，执行的这个方法的线程获得了这个锁，执行add()方法时，同样要先获得锁，因不满足while循环的条件，也就是不等待，继续进行，将此时的lockedCount变量，也就是当前获得锁的数量加一，当释放了所有的锁，才执行notify()。如果在执行这个方法时，有第二个线程想要执行这个方法，因为lockedBy不等于第二个线程，导致这个线程进入了循环，也就是等待，不断执行wait()方法。只有当第一个线程释放了所有的锁，执行了notify()方法，第二个线程才得以跳出循环，继续执行。

* java中常用的可重入锁
   * synchronized
   * java.util.concurrent.locks.ReentrantLock
   
## ReentrantLock与synchronized的区别

* 可重入性
> 从名字上理解，ReenTrantLock的字面意思就是再进入的锁，其实synchronized关键字所使用的锁也是可重入的，两者关于这个的区别不大。两者都是同一个线程没进入一次，锁的计数器都自增1，所以要等到锁的计数器下降为0时才能释放锁。

* 功能性
  * synchronized 使用比较简洁，并且由编译器去保证锁的加锁和释放，
  * ReentrantLock需要手工声明加锁和释放，为了避免忘记手工释放造成死锁，最好在finally中声明释放锁。

* 锁的粒度
  * ReentrantLock优于synchronized

* ReentrantLock优势
  * 可以指定公平锁与非公平所锁，而synchronized只能是非公平所。公平是指先等待的线程可以先获得锁。
  * 提供了一个Condition类，用来分组唤醒需要被唤醒的线程们，而不像synchronized那样随机唤醒一个线程或者所有线程。
  * 提供了一种可以中断等待锁的线程的机制，通过lock.lockInterruptibly()来实现这个机制。

* ReentrantLock实现原理
  * ReentrantLock是一种自旋锁，通过循环调用CAS操作来实现加锁。它的性能比较好也是因为避免了使线程进入内核态的阻塞状态。想尽办法避免线程进入内核的阻塞状态是我们去分析和理解锁设计的关键钥匙。