package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: HeapSort.java
 * @time: 2018/2/28 17:34
 * @software: Intellij Idea
 * @desc: 堆排序nlog(n)
 */
public class HeapSort extends BaseSort {

    @Override
    public void sort(int[] array) {
        print(array);
        int len = array.length - 1;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, len);
        }
        print(array);
        // 排序
        // 当最后剩下两个数的时候，无需再处理
        while (len > 1) {
            // 将数组中第一个元素与当前堆的最后一个元素交换
            swap(array, 0, len--);
            print(array);
            // 调整交换后[0,len-1]的数组为最大堆
            heapAdjust(array, 0, len);
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    /**
     * @param array
     * @param i     当前需要调整的子树的根结点
     * @param len
     */
    private void heapAdjust(int[] array, int i, int len) {
        int left, right, j;
        // left为当前根的左结点索引
        left = 2 * i + 1;
        while (left < len) {
            // 右结点索引
            right = left + 1;
            // 将j指向左结点
            j = left;
            // 如果当前的j不是最后一个结点，并且左结点小于右结点，将指针指向右结点
            if (j < len && array[left] < array[right]) {
                j++;
            }
            // 如果父结点小于子结点中的最大值，那么交换
            if (array[i] < array[j]) {
                swap(array, i, j);
            } else {
                // 说明比孩子结点都大
                break;
            }
            i = j;
            left = 2 * i + 1;
        }
    }


    public static void main(String[] args) {
        Sort sort = new HeapSort();
        sort.sort(BaseSort.dataSet());
    }
}
