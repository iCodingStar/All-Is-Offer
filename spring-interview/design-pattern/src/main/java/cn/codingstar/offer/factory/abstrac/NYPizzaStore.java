package cn.codingstar.offer.factory.abstrac;

import cn.codingstar.offer.factory.abstrac.impl.NYPizzaIngredientFactory;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NYPizzaStore.java
 * @time: 18-3-15 下午3:32
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class NYPizzaStore {

    private PizzaIngredientFactory ingredientFactory;

    public NYPizzaStore() {
        ingredientFactory = new NYPizzaIngredientFactory();
    }

    public void makePizza() {
        Dough dough = ingredientFactory.createDough();
        Sauce sauce = ingredientFactory.createSauce();
        System.out.println(dough.doughType());
        System.out.println(sauce.sauceType());
    }
}
