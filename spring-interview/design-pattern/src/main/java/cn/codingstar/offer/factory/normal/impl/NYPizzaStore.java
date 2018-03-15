package cn.codingstar.offer.factory.normal.impl;

import cn.codingstar.offer.factory.normal.Pizza;
import cn.codingstar.offer.factory.normal.PizzaStore;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NYPizzaStore.java
 * @time: 18-3-15 上午11:32
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class NYPizzaStore implements PizzaStore {
    @Override
    public Pizza orderPizza(String item) {
        if (item == null) {
            throw new IllegalArgumentException("item : " + item);
        }
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("sweet")) {
            return new NYStyleSweetPizza();
        }
        throw new IllegalArgumentException("item : [cheese || sweet]");
    }
}
