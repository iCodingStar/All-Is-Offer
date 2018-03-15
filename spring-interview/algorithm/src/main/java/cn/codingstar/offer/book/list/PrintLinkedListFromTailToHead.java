package cn.codingstar.offer.book.list;

import cn.codingstar.offer.book.list.node.ListNode;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PrintLinkedListFromTailToHead.java
 * @time: 18-3-9 下午5:29
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 05:从尾到头的打印链表
 */
public class PrintLinkedListFromTailToHead {

    /**
     * 用递归的方法从尾至头的打印结点
     *
     * @param root
     */
    private static void printLinkedListByReverse(ListNode root) {
        if (root == null) {
            return;
        }
        printLinkedListByReverse(root.next);
        System.out.print(root.value + "->");
    }

    public static void main(String[] args) {
        ListNode<Integer> next = new ListNode<>(2);
        ListNode<Integer> root = new ListNode<>(1, next);

        for (int i = 3; i < 10; i++) {
            ListNode<Integer> node = new ListNode<>(i);
            next.next = node;
            next = node;
        }
        printLinkedListByReverse(root);
    }

    /**
     * 总结：
     */
}
