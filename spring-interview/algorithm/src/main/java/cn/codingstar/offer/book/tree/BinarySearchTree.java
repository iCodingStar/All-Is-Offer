package cn.codingstar.offer.book.tree;

import cn.codingstar.offer.book.tree.node.TreeNode;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinarySearchTree.java
 * @time: 18-3-15 下午9:41
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 二叉搜索树，找出第k大的结点
 */
public class BinarySearchTree {

    int index = 0;

    /**
     * 二叉搜索树中序遍历结果有序
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot == null) {
            return null;
        }
        target = KthNode(pRoot.left, k);
        index++;
        if (target == null) {
            if (index == k) {
                target = pRoot;
            }
        }
        // 防止在前面已经找到，没太想明白
        if (target == null) {
            target = KthNode(pRoot.right, k);
        }
        return target;
    }


}
