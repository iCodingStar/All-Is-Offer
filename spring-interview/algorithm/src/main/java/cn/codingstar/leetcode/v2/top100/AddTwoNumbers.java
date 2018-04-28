package cn.codingstar.leetcode.v2.top100;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AddTwoNumbers.java
 * @time: 18-4-26 下午9:36
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            ListNode next = new ListNode(sum % 10);
            current.next = next;
            current = next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode next = new ListNode(carry);
            current.next = next;
        }
        return head.next;
    }
}
