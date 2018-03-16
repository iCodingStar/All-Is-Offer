package cn.codingstar.offer.book.tree;

import cn.codingstar.offer.book.tree.node.TreeNode;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MirrorBinaryTree.java
 * @time: 18-3-16 上午9:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 镜像二叉树
 */
public class MirrorBinaryTree {

    /**
     * 判断一个树是否为对称二叉树
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        // 如果根节点为null,可视为对称
        if (pRoot == null) {
            return true;
        }
        // 否则继续判断其左右结点是否对称
        return isSymmetricalCore(pRoot.left, pRoot.right);
    }

    boolean isSymmetricalCore(TreeNode left, TreeNode right) {
        // 如果左右结点都为null,说明该子树对称
        if (left == null && right == null) {
            return true;
        }
        // 如果左右结点只有一个为null，说明不对称
        if (left == null || right == null) {
            return false;
        }
        // 如果左右结点的值相等，说明对称，继续向下判断
        if (left.val == right.val) {
            // 要求左子结点的左孩子与右子结点的右孩子相等，左子结点的右孩子与右子结点的左孩子相等
            return isSymmetricalCore(left.left, right.right) && isSymmetricalCore(left.right, right.left);
        }
        // 返回false
        return false;
    }

}
