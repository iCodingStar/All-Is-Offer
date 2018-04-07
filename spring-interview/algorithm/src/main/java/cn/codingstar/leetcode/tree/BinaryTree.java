package cn.codingstar.leetcode.tree;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinaryTree.java
 * @time: 18-4-6 下午10:27
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

;import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    /**
     * 判断一棵树是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (getBalance(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public int getBalance(TreeNode node) {
        if (node == null)
            return 0;
        int left = getBalance(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getBalance(node.right);
        if (right == -1) {
            return -1;
        }
        if (left - right > 1 || right - left > 1) {
            return -1;
        }
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 使用迭代的方法，前序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                // 首先访问结点
                res.add(root.val);
                // 如果右结点非空，进行压栈操作
                if (root.right != null)
                    stack.push(root.right);
                // 移动root
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return res;
    }

    /**
     * 使用迭代的方法，中序遍历二叉树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                // 访问最后一个结点
                TreeNode current = stack.pop();
                res.add(current.val);
                // 转移访问控制点
                if (current.right != null) {
                    root = current.right;
                }
            }
        }
        return res;
    }

    /**
     * 用迭代的方法实现树的后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode r = null;
        while (stack.size() > 0 || p != null) {
            // 如果当前结点不为空，走到最左边
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                // 获取栈顶的元素
                p = stack.peek();
                if (p.right != null && p.right != r) {
                    p = p.right;
                } else {
                    stack.pop();
                    res.add(p.val);
                    // 记录最近访问过的结点
                    r = p;
                    // 结点访问后，重置指针p
                    p = null;
                }
            }
        }
        return res;
    }
}
