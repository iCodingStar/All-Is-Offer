package cn.codingstar.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ConsistentHashWithoutVirtualNode.java
 * @time: 18-3-8 下午1:53
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://www.cnblogs.com/xrq730/p/5186728.html
 * @desc: 不带虚拟结点的一致性哈希算法
 */
public class ConsistentHashWithoutVirtualNode {

    /**
     * 待加入Hash环的服务器列表
     */
    private static String[] servers = {
            "192.168.0.0:111",
            "192.168.0.1:111",
            "192.168.0.2:111",
            "192.168.0.3:111",
            "192.168.0.4:111"
    };

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 程序初始化，将所有服务器加入sortedMap中
     */
    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中，其Hash值为：" + getHash(servers[i]));
            sortedMap.put(hash, servers[i]);
        }
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器的Hash值，这里不适用重写hashCode的方法，最终效果没区别
     *
     * @param server
     * @return
     */
    private static int getHash(String server) {
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

    /**
     * 得到应当路由到的结点
     *
     * @param node
     * @return
     */
    private static String getServer(String node) {
        // 得到待路由结点的hash
        int hash = getHash(node);
        // 得到大于该hash的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个key就是顺时针过去离node结点最近的值
        Integer targetKey = subMap.firstKey();
        // 返回对应的服务器名称
        return subMap.get(targetKey);
    }

    public static void main(String[] args) {
        String[] nodes = {
                "127.0.0.1:1111",
                "221.226.0.1:2222",
                "100.221.0.1:5555",
        };
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "] 结点的hash值为 <" + getHash(nodes[i]) + "> 被路由到的服务器为：" + getServer(nodes[i]));
        }
    }

}
