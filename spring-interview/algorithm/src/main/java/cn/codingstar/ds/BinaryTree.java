package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinaryTree.java
 * @time: 18-3-27 下午4:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://blog.csdn.net/eson_15/article/details/51138663
 * @desc: 二叉搜索树
 */
public class BinaryTree {

    private BNode root;//根结点

    static class BNode {
        int key;
        int data;
        BNode left;
        BNode right;
        BNode parent;

        public BNode() {

        }

        public BNode(int key, int data, BNode left, BNode right, BNode parent) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "[ key : " + key + " , data : " + data + " ] ";
        }
    }

    /**
     * 二叉搜索树的查找时间为log(n)
     *
     * @param key
     * @return
     */
    public BNode find(int key) {
        BNode current = root;
        // 如果没找到，就一直查找
        while (current != null && current.key != key) {
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        // 能从循环中出来，说明找到了
        return current;
    }

    /**
     * 二叉搜索树的插入
     *
     * @param key
     * @param data
     */
    public void insert(int key, int data) {
        BNode node = new BNode();
        node.key = key;
        node.data = data;
        if (root == null) { // 如果插入到一个空树中
            root = node;
        } else {
            BNode current = root;
            BNode parent;
            while (true) {
                parent = current;
                if (key < current.key) {// turn left
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        node.parent = parent;
                        return;
                    }
                } else {//turn right
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        node.parent = parent;
                        return;
                    }
                }
            }
        }

    }

    /**
     * 二叉树前序遍历:递归
     */
    public void preOrder(BNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 二叉树中序遍历
     *
     * @param root
     */
    public void inOrder(BNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }

    /**
     * 二叉树后序遍历
     *
     * @param root
     */
    public void postOrder(BNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

    /**
     * 二叉树的删除
     */
    public boolean delete(int key) {
        BNode current = root;// 用来保存待删除结点
        BNode parent = root; // 用来保存待删除结点的父结点
        boolean isLeftChild = true; // 用来确定待删除结点是父亲结点的左孩子还是右孩子
        // 和查找过程一样
        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            }
        }
        return true;
    }
}
