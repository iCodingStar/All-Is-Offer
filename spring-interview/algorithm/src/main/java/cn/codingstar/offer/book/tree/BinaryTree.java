package cn.codingstar.offer.book.tree;

import cn.codingstar.offer.book.tree.node.TreeNode;

import java.util.*;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinaryTree.java
 * @time: 18-3-15 下午10:01
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 二叉树基本操作算法
 */
public class BinaryTree {

    /**
     * 层次打印二叉树:使用队列打印即可
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> levelPrint(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        // 在队列中先添加根结点
        queue.offer(pRoot);
        //
        int now = 1, next = 0;
        while (!queue.isEmpty()) {
            // 取出队首元素
            TreeNode node = queue.poll();
            tmp.add(node.val);
            //
            now--;
            if (node.left != null) {
                // 记录下一层元素的个数
                queue.offer(node.left);
                next++;
            }

            // 当前行的结点个数，下一行的结点个数
            if (node.right != null) {
                // 记录下一层元素的个数
                queue.offer(node.right);
                next++;
            }
            // 关键点
            if (now == 0) {
                // 如果now为0表示该层的元素已经输出完毕
                result.add(new ArrayList<>(tmp));
                // 将now修改为next,tmp和next清0
                // 开始下一轮
                now = next;
                tmp.clear();
                next = 0;
            }
        }
        return result;
    }


    /**
     * 层次交叉打印二叉树：按之字形打印二叉树
     * 使用数据结构栈
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> levelCrossPrint(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> levelResult = new ArrayList<>();
        stack.push(pRoot);
        // 记录当前所在层结点的个数
        int now = 1, next = 0, level = 1;
        while (!stack.isEmpty()) {
            // 保存栈中当前所有的结点
            List<TreeNode> current = new ArrayList<>();
            while (!stack.isEmpty()) {
                current.add(stack.pop());
            }
            // 如果当前层是奇数层，那么往栈中从左至右的添加下一层的结点，这样出栈的顺序就是从右至左
            for (TreeNode node : current) {
                levelResult.add(node.val);
                now--;
                if (level % 2 == 1) {
                    if (node.left != null) {
                        stack.push(node.left);
                        next++;
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                        next++;
                    }
                }
                // 如果当前是偶数层，那么往栈中从右至左的添加结点，这样出栈的顺序就是从左至右
                if (level % 2 == 0) {
                    if (node.right != null) {
                        stack.push(node.right);
                        next++;
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                        next++;
                    }
                }
            }
            // 说明当前层的结点遍历结束
            if (now == 0) {
                // 保存当前层的遍历结果
                result.add(new ArrayList<>(levelResult));
                // 清空当前层的数据
                levelResult.clear();
                // 重置当前层结点数量以及下一层节点数量
                now = next;
                next = 0;
                // 更新遍历层次
                level++;
            }
        }
        return result;
    }
}
