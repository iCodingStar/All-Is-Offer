package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: LazySingleton.java
 * @time: 18-3-15 下午3:41
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 懒汉式单例模式
 */

/**
 * 特点：
 * 1. 延迟实例化，如果没有用到该类，就不实例化，节省资源
 * 2. 但是多线程不安全，会多次实例化实例
 */
public class LazySingleton implements Singleton {

    private static Singleton INSTANCE;

    private LazySingleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

}
