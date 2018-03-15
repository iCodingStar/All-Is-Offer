package cn.codingstar.offer.factory;

import cn.codingstar.offer.factory.abstrac.NYPizzaStore;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NYPizzaStoreTestDrive.java
 * @time: 18-3-15 下午3:35
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class NYPizzaStoreTestDrive {

    public static void main(String[] args) {
        NYPizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.makePizza();
    }
}
