package cn.codingstar.offer.factory.abstrac.impl;

import cn.codingstar.offer.factory.abstrac.Dough;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ThinCrustDough.java
 * @time: 18-3-15 下午3:25
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ThinCrustDough implements Dough {
    @Override
    public String doughType() {
        return "ThinCrustDough";
    }
}
