package cn.codingstar.offer.book.chapter01;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ListNode.java
 * @time: 18-3-9 下午5:30
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 单向链表结点类
 */
public class ListNode<T> {

    T value;

    ListNode<T> next;

    public ListNode() {
        this.value = null;
        this.next = null;
    }

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }
}
