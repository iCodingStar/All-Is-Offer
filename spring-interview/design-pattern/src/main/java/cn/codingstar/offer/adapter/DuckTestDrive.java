package cn.codingstar.offer.adapter;

import cn.codingstar.offer.adapter.impl.TurkeyAdapter;
import cn.codingstar.offer.adapter.impl.WildTurkey;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: DuckTestDrive.java
 * @time: 18-3-15 下午4:44
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class DuckTestDrive {

    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();// 让duck可以调用turkey的gobble方法
        duck.fly();
    }
}
