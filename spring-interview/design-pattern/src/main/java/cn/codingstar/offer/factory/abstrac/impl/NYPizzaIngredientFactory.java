package cn.codingstar.offer.factory.abstrac.impl;

import cn.codingstar.offer.factory.abstrac.Dough;
import cn.codingstar.offer.factory.abstrac.PizzaIngredientFactory;
import cn.codingstar.offer.factory.abstrac.Sauce;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NYPizzaIngredientFactory.java
 * @time: 18-3-15 下午3:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: NY工厂
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
}
