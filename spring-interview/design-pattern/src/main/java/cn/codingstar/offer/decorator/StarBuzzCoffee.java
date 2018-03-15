package cn.codingstar.offer.decorator;

import cn.codingstar.offer.decorator.impl.HouseBlend;
import cn.codingstar.offer.decorator.impl.Milk;
import cn.codingstar.offer.decorator.impl.Mocha;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: StarBuzzCoffee.java
 * @time: 18-3-15 下午4:29
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 设计不同种类的饮料，并且每种饮料可以动态添加新的材料，比如可以添加牛奶。计算一种饮料的价格。
 */

/**
 * 动态地将责任附加到对象上。在扩展功能上，装饰者提供了比继承更有弹性的替代方案。
 */
public class StarBuzzCoffee {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend(); // cost 1.0
        beverage = new Mocha(beverage); // cost 1.0 + 1.0
        beverage = new Milk(beverage); // cost 2.0 + 1.0
        System.out.println(beverage.cost());
    }

}
