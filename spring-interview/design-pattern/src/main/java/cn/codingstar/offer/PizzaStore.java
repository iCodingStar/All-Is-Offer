package cn.codingstar.offer;

import cn.codingstar.offer.factory.SimplePizzaFactory;
import cn.codingstar.offer.factory.simple.Pizza;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PizzaStore.java
 * @time: 18-3-15 上午11:15
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class PizzaStore {

    public static void main(String[] args) {
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        Pizza pizza = simplePizzaFactory.createPizza("sweet");
        pizza.make();
    }
}
