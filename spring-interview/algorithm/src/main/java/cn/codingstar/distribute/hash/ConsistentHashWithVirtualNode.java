package cn.codingstar.distribute.hash;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

import static cn.codingstar.distribute.util.HashGenerator.getHash;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ConsistentHashWithVirtualNode.java
 * @time: 18-3-8 下午4:03
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://www.cnblogs.com/xrq730/p/5186728.html
 * @desc: 带虚拟结点的一致性hash
 */
public class ConsistentHashWithVirtualNode extends AbstractConsistentHash {

    /**
     * 考虑到服务器的上线、下线，添加删除场景会比较频繁，使用LinkedList数据结构比较好
     */
    private static List<String> realNodes = new LinkedList<>();


    private static final int VIRTUAL_NODES_NUM = 5;


    public ConsistentHashWithVirtualNode() {
        init();
    }

    /**
     * 初始化，将所有虚拟结点服务器加入到环中
     */
    private void init() {
        // 将真实结点用LinkedList保存
        for (String server : servers) {
            realNodes.add(server);
        }
        // 将虚拟结点添加到哈希环
        for (String server : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES_NUM; i++) {
                String virtualNode = server + "&&VN" + i;
                int hash = getHash(virtualNode);
                System.out.println("[" + virtualNode + "]加入集合中，其Hash值为：" + hash);
                sortedMap.put(hash, virtualNode);
            }
        }
    }

    @Override
    public String getServer(String node) {
        // 得到待路由结点的hash
        int hash = getHash(node);
        // 得到大于该hash的所有Map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个key就是顺时针过去离node结点最近的值
        Integer targetKey = subMap.firstKey();
        // 返回对应的服务器名称
        String virtualNode = subMap.get(targetKey);
        return virtualNode.split("&&")[0];
    }


    public static void main(String[] args) {
        ConsistentHash consistentHash = new ConsistentHashWithVirtualNode();
        String[] nodes = {
                "127.0.0.1:1111",
                "255.226.0.1:2222",
                "188.221.0.1:5555",
        };
        for (int i = 0; i < nodes.length; i++) {
            System.out.println("[" + nodes[i] + "] 结点的hash值为 <" + getHash(nodes[i]) + "> 被路由到的服务器为：" + consistentHash.getServer(nodes[i]));
        }
    }

}
