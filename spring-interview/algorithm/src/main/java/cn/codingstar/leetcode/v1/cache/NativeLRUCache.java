package cn.codingstar.leetcode.v1.cache;

import java.util.HashMap;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: NativeLRUCache.java
 * @time: 18-4-8 下午9:13
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class NativeLRUCache {

    private HashMap<Integer, DoubleListNode> map;
    private DoubleListNode head;
    private DoubleListNode tail;
    private int capacity;
    private int currentSize;

    public NativeLRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.map = new HashMap<>();
        this.head = this.tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //如果存在这个结点，访问之后应用LRU策略移动该结点到链表头
            DoubleListNode node = map.get(key);
            if (node == tail) {
                if (currentSize > 1) {
                    removeNodeFromTail(node);
                    moveNodeToHead(node);
                }
            } else if (node == head) {
                // pass
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                moveNodeToHead(node);
            }
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    private void removeNodeFromTail(DoubleListNode node) {
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
    }

    private void moveNodeToHead(DoubleListNode node) {
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新HashMap中对应的值，并将其移动到队列头部
            DoubleListNode node = map.get(key);
            node.value = value;
            if (node == tail) {
                removeNodeFromTail(node);
                moveNodeToHead(node);
            } else if (node == head) {
                // pass
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                moveNodeToHead(node);
            }
            map.put(key, node);
        } else {
            // 插入新的结点
            DoubleListNode node = new DoubleListNode(key, value);
            map.put(key, node);
            if (currentSize == 0) {
                head = tail = node;
                currentSize += 1;
            } else if (currentSize < capacity) {
                moveNodeToHead(node);
                currentSize += 1;
            } else {
                // 删除尾结点
                map.remove(tail.key);
                removeNodeFromTail(tail);
                // 增加头结点
                moveNodeToHead(node);
            }
        }
    }

    private static class DoubleListNode {
        public DoubleListNode prev;
        public DoubleListNode next;
        public int key;
        public int value;

        public DoubleListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    public static void main(String[] args) {
        
    }
}
