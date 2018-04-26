package cn.codingstar.leetcode.v1.tree;

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

;

import java.util.*;

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

    /**
     * 层次遍历二叉树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        // 初始当前层结点数量为1
        int currentLevel = 1;
        // 初始下一层结点数量为0
        int nextLevel = 0;
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            currentLevel--;
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (currentLevel == 0) {
                // 保存该层的结点数据
                res.add(new ArrayList<>(level));
                // 清空容器，用于下一层的保存法
                level.clear();
                // 更新下一层几点的数量
                currentLevel = nextLevel;
                // 初始化下下一层结点数
                nextLevel = 0;
            }
        }
        return res;
    }

    private int max = 0x80000000;

    /**
     * 计算二叉树的最大路径和
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        pathSumHelper(root);
        return max;
    }

    /**
     * 二叉树路径和辅助工具
     *
     * @param root
     * @return
     */
    private int pathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = pathSumHelper(root.left);
        int right = pathSumHelper(root.right);
        // 连接父结点的最大路径是一、二、四这三种情况的最大值
        int currentSum = Math.max(Math.max(left + root.val, right + root.val), root.val);
        // 当前结点的最大路径是一、二、三、四这四种情况的最大值
        int currentMax = Math.max(currentSum, left + right + root.val);
        // 用当前最大值更新全局最大值
        max = Math.max(currentMax, max);
        return currentSum;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lmin = minDepth(root.left);
        int rmin = minDepth(root.right);
        // 如果访问到了叶子结点
        if (lmin == 0 && rmin == 0) {
            return 1;
        }
        if (lmin == 0) {
            lmin = 0xfffffff;
        }
        if (rmin == 0) {
            rmin = 0xfffffff;
        }
        return lmin < rmin ? lmin + 1 : rmin + 1;
    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lmax = maxDepth(root.left);
        int rmax = maxDepth(root.right);

        if (lmax == 0 && rmax == 0) {
            return 1;
        }

        return lmax > rmax ? lmax + 1 : rmax + 1;
    }

    /**
     * 寻找node1与node2的最近的公共祖先,时间复杂度O(n)
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getLastCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        TreeNode temp;
        while (node1 != null) {
            node1 = node1.parent;
            // 逐个检查node1的父结点，看是不是其公共祖先
            temp = node2;
            while (temp != null) {
                if (node1 == temp.parent) {
                    return node1;
                }
                temp = temp.parent;
            }
        }
        return null;
    }


    /**
     * 将求公共祖先转化成求链表的相交结点,思路很nice
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getLastCommonAncestorByLinkedList(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        // 将两个链表长度统一化
        int len1 = high(root, node1);
        int len2 = high(root, node2);
        for (; len1 > len2; len1--) {
            node1 = node1.parent;
        }
        for (; len2 > len1; len2--) {
            node2 = node2.parent;
        }

        // 让两个链表同时走
        while (node1 != null && node2 != null && node1 != node2) {
            node1 = node1.parent;
            node2 = node2.parent;
        }

        // 如果结束时，两个结点相同，说明找到了公共结点
        if (node1 == node2) {
            return node1;
        } else {
            return null;
        }
    }

    /**
     * 求node祖先结点的个数
     *
     * @param root
     * @param node
     * @return
     */
    private int high(TreeNode root, TreeNode node) {
        int len = 0;
        for (; node != null; node = node.parent) {
            len++;
        }
        return len;
    }


    /**
     * 二叉搜索树寻找最近公共祖先结点
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getLastCommonAncestorForBinarySearchTree(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        if (root.val > node1.val && root.val > node2.val) {
            return getLastCommonAncestorForBinarySearchTree(root.left, node1, node2);
        } else if (root.val < node1.val && root.val < node2.val) {
            return getLastCommonAncestorForBinarySearchTree(root.right, node1, node2);
        } else {
            return root;
        }
    }

    /**
     * 普通二叉树的公共祖先结点
     *
     * @param root
     * @param node1
     * @param node2
     * @return
     */
    public TreeNode getLastCommonAncestorByNormal(TreeNode root, TreeNode node1, TreeNode node2) {
        // 发现目标结点，则通过返回值标记该子树发现了某个目标结点
        if (root == null || node1 == root || node2 == root) {
            return root;
        }
        // 查看左子树是否含有目标结点
        TreeNode l = getLastCommonAncestorByNormal(root.left, node1, node2);
        TreeNode r = getLastCommonAncestorByNormal(root.right, node1, node2);
        // 查看返回值，判断当前的根结点是否为这两个结点的祖先结点
        if (l != null && r != null) {
            return root;
        }
        // 向上标记
        return l != null ? l : r;
    }
}
