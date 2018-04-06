package cn.codingstar.test.toutiao.pc;

import java.util.LinkedList;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Storage.java
 * @time: 18-4-6 下午7:56
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Storage {

    private LinkedList<Object> list = new LinkedList<>();

    private final static int MAX_SIZE = 100;

    // 生产产品
    public void produce(String producer) {
        synchronized (list) {
            // 如果仓库已满，停止生产，并通知消费者消费
            while (list.size() == MAX_SIZE) {
                System.out.println(Thread.currentThread() + "-->" + "仓库已满,[" + producer + "]暂停生产 ");
                try {
                    // 由于无法生产，生产者阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 开始生产产品
            list.add(new Object());
            System.out.println(Thread.currentThread() + "--> [" + producer + "]生产了产品\t当前仓储为：" + list.size());
            list.notifyAll();
        }
    }

    // 消费产品
    public void consume(String consumer) {

        synchronized (list) {
            while (list.size() == 0) {
                System.out.println(Thread.currentThread() + "--> 仓库为空，[" + consumer + "]暂时无法消费");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 可以先开始消费产品
            list.remove();
            System.out.println(Thread.currentThread() + "-->[" + consumer + "]消费了一个产品\t现在仓储为:" + list.size());
            list.notifyAll();
        }

    }
}
