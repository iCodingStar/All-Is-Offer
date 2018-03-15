package cn.codingstar.offer.book.tree;

import cn.codingstar.offer.book.tree.node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

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
     * 使用队列打印即可
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
}
