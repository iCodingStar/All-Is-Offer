package cn.codingstar.offer.factory.simple.impl;

import cn.codingstar.offer.factory.simple.Pizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: GreekPizza.java
 * @time: 18-3-15 上午11:09
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class GreekPizza implements Pizza {
    @Override
    public void make() {
        System.out.println("Greek Pizza");
    }
}
