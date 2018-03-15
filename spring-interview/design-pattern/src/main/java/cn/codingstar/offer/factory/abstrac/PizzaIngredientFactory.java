package cn.codingstar.offer.factory.abstrac;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PizzaIngredientFactory.java
 * @time: 18-3-15 下午3:28
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 类似抽象工厂
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

}
