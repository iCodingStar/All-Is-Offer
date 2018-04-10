package cn.codingstar.leetcode.tree;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: IpRegionDataBase.java
 * @time: 18-4-10 下午8:55
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class IpRegionDataBase {

    public static class TireTree {

        private Node root;


        private class Node {
            String city;
            Node[] child;

            public Node() {
                this.city = "";
                this.child = new Node[2];
            }
        }

        public TireTree() {
            this.root = new Node();
        }

        /**
         * 插入一条数据信息
         *
         * @param ipAddress
         * @param city
         */
        public void insert(String ipAddress, String city) {
            if (ipAddress.length() > 32) {
                throw new IllegalArgumentException("Bad argument : " + ipAddress);
            }
            Node current = root;
            // 为当前的ip地址创建对应的前缀库
            for (int i = 0; i < ipAddress.length(); i++) {
                int index = ipAddress.charAt(i) - '0';
                if (current.child[index] == null) {
                    current.child[index] = new Node();
                }
                current = current.child[index];
            }
            current.city = city;
        }

        /**
         * 通过ip地址查找对应的城市信息
         *
         * @param ipAddress
         * @return
         */
        public String search(String ipAddress) {
            Node current = root;
            for (int i = 0; current.city.length() == 0; i++) {
                int index = ipAddress.charAt(i) - '0';
                if (current.child[index] == null) {
                    return null;
                }
                current = current.child[index];
            }
            return current.city;
        }


    }

    public static void main(String[] args) {
        TireTree tireTree = new TireTree();
        tireTree.insert("11001100110011", "上海");
        tireTree.insert("1100110", "武汉");
        System.out.println(tireTree.search("11001100110011"));
    }
}
