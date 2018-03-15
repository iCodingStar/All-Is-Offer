package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: InnerClassSingleton.java
 * @time: 18-3-15 下午4:14
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 静态私有内部类实现单例模式
 */

/**
 * 1. 懒加载
 * 2. 线程安全
 */
public class InnerClassSingleton implements Singleton {

    private InnerClassSingleton() {

    }

    private static class SingletonHolder {
        private final static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
