package cn.codingstar.leetcode.tree;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: IpRegionSearch.java
 * @time: 18-4-10 下午8:33
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class IpRegionSearch {

    class TrieTree {
        private Node root = null;   //根节点

        /*二叉树的节点*/
        private class Node {
            String element;  //非叶子节点为空 叶子节点标记为ISP
            Node[] children; //左孩子节点为0 右孩子节点为1

            public Node() {
                element = "";
                children = new Node[2];
                for (int i = 0; i < children.length; i++) {
                    children[i] = null;
                }
            }
        }

        public TrieTree() {
            root = new Node();
        }

        /*插入ip地址*/
        public void insert(Node root, String ipAddress, String isp) {
            if (ipAddress.length() > 32) {
                System.out.println("ip地址处理错误");
            } else {
                Node crawl = root;
                for (int i = 0; i < ipAddress.length(); i++) {
                    int index = (int) ipAddress.charAt(i) - '0';
                    if (crawl.children[index] == null) {
                        crawl.children[index] = new Node();
                    }
                    crawl = crawl.children[index];
                }
                crawl.element = isp;
            }
        }

        public void insert(String ipAddress, String isp) {
            insert(root, ipAddress, isp);
        }

        /*
         * 检索ip地址，返回其所对应的ISP
         * 若不在Trie树中，则返回null
         * */
        public String search(String binaryIP) {
            Node crawl = root;
            for (int i = 0; crawl.element.length() == 0; i++) {
                int index = (int) binaryIP.charAt(i) - '0';
                if (crawl.children[index] == null) {
                    return null;
                }
                crawl = crawl.children[index];
            }
            return crawl.element;
        }
    }


    /*将ip地址转换成32位的二进制*/
    public static String toBinaryNumber(String ipAddress) {
        String[] octetArray = ipAddress.split("\\.");
        String binaryNumber = "";
        for (String str : octetArray) {
            int octet = Integer.parseInt(str, 10);
            String binaryOctet = Integer.toBinaryString(octet);
            int bolength = binaryOctet.length();
            if (bolength < 8) {
                for (int i = 0; i < 8 - bolength; i++) {
                    binaryOctet = '0' + binaryOctet;            //补前导0
                }
            }
            binaryNumber += (binaryOctet);
        }
        return binaryNumber;
    }

    /*获取network地址部分*/
    public static String getNetworkAddress(String cidrAddress) {
        String[] cidrArray = cidrAddress.split("/");
        String binaryNumber = toBinaryNumber(cidrArray[0]);
        int size = Integer.parseInt(cidrArray[1]);
        return binaryNumber.substring(0, size);
    }

    /*main方法用于测试*/
    public static void main(String[] args) {
        String ip = "103.20.112.0/20";
        String bn = getNetworkAddress(ip);
        System.out.println(bn);
    }
}
