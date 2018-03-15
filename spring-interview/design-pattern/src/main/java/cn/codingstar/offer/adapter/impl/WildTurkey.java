package cn.codingstar.offer.adapter.impl;

import cn.codingstar.offer.adapter.Turkey;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: WildTurkey.java
 * @time: 18-3-15 下午4:36
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class WildTurkey implements Turkey {


    @Override
    public void gobble() {
        System.out.println("Say gobble ...");
    }

    @Override
    public void fly() {
        System.out.println("Start fly ...");
    }
}
