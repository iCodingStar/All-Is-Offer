package cn.codingstar.offer.factory.normal;

import cn.codingstar.offer.factory.normal.impl.ChinesePizzaStore;
import cn.codingstar.offer.factory.normal.impl.NYPizzaStore;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PizzaStoreTest.java
 * @time: 18-3-15 下午3:15
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 工厂模式通过子类实现目标对象的创建，更加的多样化
 */
public class PizzaStoreTest {

    public static void main(String[] args) {
        PizzaStore chineseStore = new ChinesePizzaStore();
        Pizza pizza = chineseStore.orderPizza("sweet");
        pizza.make();
        PizzaStore NYStore = new NYPizzaStore();
        Pizza nyPizza = NYStore.orderPizza("sweet");
        nyPizza.make();
    }
}
