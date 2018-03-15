package cn.codingstar.offer.factory.normal.impl;


import cn.codingstar.offer.factory.normal.Pizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ChineseStyleSweetPizza.java
 * @time: 18-3-15 上午11:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ChineseStyleSweetPizza implements Pizza {
    @Override
    public void make() {
        System.out.println("Chinese Style Sweet Pizza !");
    }
}
