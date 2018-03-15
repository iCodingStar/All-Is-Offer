package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: HungrySingleton.java
 * @time: 18-3-15 下午3:37
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 饿汉式单例模式
 */

/**
 * 特点：
 * 1. 线程安全
 * 2. 不会节省资源
 */
public class HungrySingleton implements Singleton {

    /**
     * 私有静态变量
     */
    private static HungrySingleton INSTANCE = new HungrySingleton();

    /**
     * 私有化构造函数
     */
    private HungrySingleton() {

    }


    public static Singleton getInstance() {
        return INSTANCE;
    }
}
