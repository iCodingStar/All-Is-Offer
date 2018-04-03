package cn.codingstar.offer.thread.model;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PCData.java
 * @time: 18-4-2 上午11:11
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class PCData {

    private final int value;

    public PCData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "data:" + value;
    }
}
