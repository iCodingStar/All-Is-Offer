package cn.codingstar.test.toutiao.pc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Producer.java
 * @time: 18-4-3 下午9:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://www.cnblogs.com/Ming8006/p/7243858.html
 * @desc:
 */
public class Producer implements Runnable {

    private String producer;

    private Storage storage;

    public Producer(String producer, Storage storage) {
        this.producer = producer;
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            storage.produce(producer);
        }
    }
}
