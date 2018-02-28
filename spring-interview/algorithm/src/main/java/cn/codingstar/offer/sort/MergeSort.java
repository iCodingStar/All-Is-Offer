package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: MergeSort.java
 * @time: 2018/2/28 20:57
 * @software: Intellij Idea
 * @desc: 归并排序O(nlog ( n))
 */
public class MergeSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        print(array);
    }

    private void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 合并两个有序数组
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        // 左有序序列指针
        int i = left;
        // 右有序序列指针
        int j = mid + 1;
        // 临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        // 获取上面数组中剩余的数字
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        // 将temp中的已排序部分复制到array中
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        Sort sort = new MergeSort();
        sort.sort(BaseSort.dataSet());
    }
}
