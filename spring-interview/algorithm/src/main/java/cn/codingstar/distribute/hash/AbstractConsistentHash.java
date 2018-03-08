package cn.codingstar.distribute.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AbstractConsistentHash.java
 * @time: 18-3-8 下午4:18
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public abstract class AbstractConsistentHash implements ConsistentHash {

    /**
     * key表示虚拟结点的hash值，value表示虚拟结点的服务器名称
     */
    protected static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 待加入Hash环的服务器列表
     */
    protected String[] servers = {
            "192.168.0.0:111",
            "192.168.0.1:111",
            "192.168.0.2:111",
            "192.168.0.3:111",
            "192.168.0.4:111"
    };
}
