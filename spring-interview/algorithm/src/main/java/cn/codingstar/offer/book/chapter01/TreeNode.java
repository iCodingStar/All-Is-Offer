package cn.codingstar.offer.book.chapter01;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: TreeNode.java
 * @time: 18-3-9 下午7:07
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class TreeNode<T> {

    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {

    }

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
