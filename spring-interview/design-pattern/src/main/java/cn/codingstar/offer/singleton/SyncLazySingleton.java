package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SyncLazySingleton.java
 * @time: 18-3-15 下午3:48
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

/**
 * 特点：
 * 1.延迟实例化，节省资源
 * 2.通过同步加锁的方法，确保多线程环境下也只会产生一个实例
 * 3.效率低下
 */
public class SyncLazySingleton implements Singleton {

    private static SyncLazySingleton INSTANCE;

    private SyncLazySingleton() {

    }

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SyncLazySingleton();
        }
        return INSTANCE;
    }
}
