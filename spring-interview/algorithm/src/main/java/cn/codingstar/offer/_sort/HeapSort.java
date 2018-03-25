package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: HeapSort.java
 * @time: 18-3-24 下午4:09
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class HeapSort extends BaseSort {


    @Override
    public void sort(int[] array) {

    }

    @Override
    public void _sort(int[] array) {

    }

    /**
     * 调整指定大小的数组为一个大顶堆
     *
     * @param array
     * @param heapIndex
     * @param currentSize
     */
    public void siftDown(int[] array, int heapIndex, int currentSize) {
        // 保存堆顶元素
        int temp = array[heapIndex];
        // 寻找堆顶元素实际需要存放的位置
        int hole = heapIndex;
        // 左孩子的位置
        int child;
        // 为temp寻找合适的存储位置
        for (; getLeftChild(hole) < currentSize; hole = child) {
            // 寻找较大的孩子
            child = getLeftChild(hole);
            if (child != currentSize - 1 && array[child] < array[child + 1]) {
                child++;
            }
            if (temp < array[child]) {
                // 如果temp比较大的孩子小，则将较大的孩子上移
                array[hole] = array[child];
            }
        }
        // 填入之
        array[hole] = temp;
    }

    /**
     * 获取当前结点的左孩子
     *
     * @param parent (从0开始)
     * @return
     */
    private int getLeftChild(int parent) {
        return 2 * parent + 1;
    }

    public static void main(String[] args) {
        int[] array = BaseSort.dataSet();

        HeapSort sort = new HeapSort();
        // 建堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            sort.siftDown(array, i, array.length);
        }
        // 每次删除堆顶元素，并重新调整堆
        for (int i = array.length - 1; i > 0; i--) {
            // 将堆顶元素与当前最后一个元素交换
            sort.swap(array, 0, i);
            // 重新调整堆
            sort.siftDown(array, 0, i);
        }
        sort.print(array);
    }
}
