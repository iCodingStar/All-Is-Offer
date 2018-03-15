package cn.codingstar.offer.decorator.impl;

import cn.codingstar.offer.decorator.Beverage;
import cn.codingstar.offer.decorator.CodimentDecorator;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Mocha.java
 * @time: 18-3-15 下午4:25
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Mocha extends CodimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }

}
