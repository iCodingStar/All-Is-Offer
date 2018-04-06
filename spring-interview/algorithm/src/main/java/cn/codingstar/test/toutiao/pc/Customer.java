package cn.codingstar.test.toutiao.pc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Customer.java
 * @time: 18-4-3 下午9:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Customer implements Runnable {

    private String consumer;

    private Storage storage;

    public Customer(String consumer, Storage storage) {
        this.consumer = consumer;
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            storage.consume(consumer);
        }
    }
}
