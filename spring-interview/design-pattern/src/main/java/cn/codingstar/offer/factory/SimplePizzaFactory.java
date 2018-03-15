package cn.codingstar.offer.factory;

import cn.codingstar.offer.factory.simple.Pizza;
import cn.codingstar.offer.factory.simple.impl.CheesePiazza;
import cn.codingstar.offer.factory.simple.impl.GreekPizza;
import cn.codingstar.offer.factory.simple.impl.SweetPizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SimplePizzaFactory.java
 * @time: 18-3-15 上午11:07
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 简单工厂:简单工厂不是设计模式，更像是一种编程习惯。
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new CheesePiazza();
        } else if (type.equals("greek")) {
            return new GreekPizza();
        } else if (type.equals("sweet")) {
            return new SweetPizza();
        }
        throw new RuntimeException("Illegal arguments !");
    }
}
