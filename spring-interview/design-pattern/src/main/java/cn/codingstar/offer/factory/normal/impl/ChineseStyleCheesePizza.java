package cn.codingstar.offer.factory.normal.impl;


import cn.codingstar.offer.factory.normal.Pizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ChineseStyleCheesePizza.java
 * @time: 18-3-15 上午11:30
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ChineseStyleCheesePizza implements Pizza {
    @Override
    public void make() {
        System.out.println("Chinese Style Cheese Pizza!");
    }
}
