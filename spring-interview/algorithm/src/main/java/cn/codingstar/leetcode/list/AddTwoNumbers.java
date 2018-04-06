package cn.codingstar.leetcode.list;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AddTwoNumbers.java
 * @time: 18-4-6 下午8:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 输入： 2->4->3 + 5->6->4
 * 输出： 7->0->8
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        // 虚拟头结点，只是为了返回时获取真正的头结点
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int value1, value2;
            if (l1 != null) {
                value1 = l1.val;
            } else {
                value1 = 0;
            }
            if (l2 != null) {
                value2 = l2.val;
            } else {
                value2 = 0;
            }
            int current = carry + value1 + value2;
            int value = current % 10;
            ListNode node = new ListNode(value);
            carry = current / 10;
            pre.next = node;
            pre = pre.next;
            // 移动链表
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        // 检查进位值是否非零
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            pre.next = node;
        }
        pre = result.next;
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode r = addTwoNumbers(l1, l2);
        ListNode curr = r;
        while (curr != null) {
            if (curr.next != null) {
                System.out.print(curr.val + "->");
            } else {
                System.out.print(curr.val);
            }
            curr = curr.next;
        }
    }
}
