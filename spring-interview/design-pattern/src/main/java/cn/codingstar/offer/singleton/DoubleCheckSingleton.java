package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: DoubleCheckSingleton.java
 * @time: 18-3-15 下午3:52
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class DoubleCheckSingleton implements Singleton {

    /**
     * 必须使用volatile关键字来增加变量的内存可见性
     */
    private volatile static Singleton INSTANCE;

    private DoubleCheckSingleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
