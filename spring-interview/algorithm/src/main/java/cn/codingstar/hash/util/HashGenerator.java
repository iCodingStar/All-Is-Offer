package cn.codingstar.hash.util;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: HashGenerator.java
 * @time: 18-3-8 下午4:12
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: hash值生成工具
 */
public class HashGenerator {

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值，这里不使用重写hashCode的方法，最终效果没区别
     *
     * @param server
     * @return
     */
    public static int getHash(String server) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < server.length(); i++) {
            hash = (hash ^ server.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = -hash;
        }
        return hash;
    }

}
