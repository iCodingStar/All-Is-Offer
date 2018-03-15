package cn.codingstar.offer.factory.normal.impl;


import cn.codingstar.offer.factory.normal.Pizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NYStyleCheesePizza.java
 * @time: 18-3-15 上午11:27
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class NYStyleCheesePizza implements Pizza {
    @Override
    public void make() {
        System.out.println("NY Style Cheese Pizza !");
    }
}