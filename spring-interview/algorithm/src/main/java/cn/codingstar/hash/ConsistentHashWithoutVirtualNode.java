package cn.codingstar.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 导入hash生成方法
 */
import static cn.codingstar.hash.util.HashGenerator.getHash;

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
public class ConsistentHashWithoutVirtualNode extends AbstractConsistentHash {


    public ConsistentHashWithoutVirtualNode() {
        init();
    }

    /**
     * key表示服务器的hash值，value表示服务器的名称
     */
    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    /**
     * 程序初始化，将所有服务器加入sortedMap中
     */
    private void init() {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]加入集合中，其Hash值为：" + getHash(servers[i]));
            sortedMap.put(hash, servers[i]);
        }
    }

    /**
     * 得到应当路由到的结点
     *
     * @param node
     * @return
     */
    public String getServer(String node) {
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
        ConsistentHash consistentHash = new ConsistentHashWithoutVirtualNode();
        String[] nodes = {
                "127.0.0.1:1111",
                "221.226.0.1:2222",
                "100.221.0.1:5555",
        };
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "] 结点的hash值为 <" + getHash(nodes[i]) + "> 被路由到的服务器为：" + consistentHash.getServer(nodes[i]));
        }
    }

}
