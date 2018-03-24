package cn.codingstar.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinaryHeap.java
 * @time: 18-3-24 下午4:18
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 堆
 */
public class BinaryHeap {

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int[] table;

    private int currentSize;

    public BinaryHeap() {
        table = new int[DEFAULT_CAPACITY];
    }

    public BinaryHeap(int capacity) {
        this.capacity = capacity;
        table = new int[capacity];
    }

    public BinaryHeap(int[] items) {
        currentSize = items.length;// table[0]不存储元素
        capacity = items.length + 1;
        table = new int[capacity];
        for (int i = 1; i < capacity; i++) {
            table[i] = items[i - 1];
        }
        buildHeap();
    }

    public void insert(int item) {
        // 第0个位置不存储元素，因而当currentSize = table.length - 1的时候，已经无法添加元素，需要扩容
        if (currentSize == table.length - 1) {
            resize(table.length * 2 + 1);
        }

        // Percolate up
        int hole = ++currentSize;
        // 循环查找x可以存放的位置,巧妙使用table[0]=item,便于
        for (table[0] = item/*不可或缺*/; item < table[hole / 2]; hole /= 2) {
            table[hole] = table[hole / 2];
        }
        table[hole] = item;
        // 初始化table[0]
        table[0] = 0;
    }

    public int findMin() {
        return table[1];
    }

    public int deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException("Operation is not permitted : table size " + currentSize);
        }
        int minItem = findMin();
        table[1] = table[currentSize--];
        // 重新调整堆的结构
        siftDown(1);
        return minItem;
    }

    /**
     * 从hole位置向下调整
     *
     * @param hole
     */
    private void siftDown(int hole) {
        int child;
        // 保存需要调整位置的元素
        int temp = table[hole];
        for (; hole * 2 <= currentSize; hole = child) {
            // 左孩子位置
            child = hole * 2;
            // 寻找子结点中较小的结点
            if (child != currentSize && table[child + 1] < table[child]) {
                child++;
            }
            // 如果子结点比hole位置的元素小，上移
            if (table[child] < temp) {
                table[hole] = table[child];
            } else {
                // 如果最小的子结点都比temp大，说明该位置就是temp应该存放的位置啊
                break;
            }
        }
        table[hole] = temp;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void makeEmpty() {
        this.currentSize = 0;
    }

    /**
     * 如果数组空间不够用的时候，实行扩容机制
     */
    private void resize(int newCapacity) {
        int[] newTable = new int[newCapacity];
        for (int i = 0; i <= currentSize; i++) {
            newTable[i] = table[i];
        }
        table = newTable;
        capacity = newCapacity;
        newTable = null;
    }

    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            siftDown(i);
        }
    }

    public void print() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.print(table[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] items = {6, 5, 4, 3, 2, 1};
        BinaryHeap heap = new BinaryHeap(items);
        heap.print();
    }
}
