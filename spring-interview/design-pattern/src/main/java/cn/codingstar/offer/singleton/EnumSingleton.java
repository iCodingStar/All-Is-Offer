package cn.codingstar.offer.singleton;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: EnumSingleton.java
 * @time: 18-3-15 下午4:08
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 枚举实现单例模式
 */

/**
 * 特点：
 * 1. 饿汉式
 * 2. 线程安全
 * 3. 序列化安全
 */
public enum EnumSingleton {
    INSTANCE;
}
