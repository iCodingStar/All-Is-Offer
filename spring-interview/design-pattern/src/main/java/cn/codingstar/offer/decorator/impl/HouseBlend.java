package cn.codingstar.offer.decorator.impl;

import cn.codingstar.offer.decorator.Beverage;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: HouseBlend.java
 * @time: 18-3-15 下午4:21
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class HouseBlend implements Beverage {

    @Override
    public double cost() {
        return 1;
    }
}
