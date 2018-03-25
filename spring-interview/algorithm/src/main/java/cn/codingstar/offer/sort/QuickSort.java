package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: QuickSort.java
 * @time: 2018/2/28 15:32
 * @software: Intellij Idea
 * @desc: 快速排序 nlog(n)
 * @link :https://www.cnblogs.com/codeskiller/p/6360870.html
 */
public class QuickSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        qsort(array, 0, array.length - 1);
        print(array);
    }

    private void qsort(int[] array, int low, int high) {
        if (low < high) {
            //int pivotIndex = partition(array, low, high);
            int pivotIndex = partition(array, low, high);
            qsort(array, 0, pivotIndex - 1);
            qsort(array, pivotIndex + 1, high);
        }
    }

    /**
     * @param unSortedArray
     * @param low
     * @param high
     * @return pivotIndex
     */
    private int partition(int[] unSortedArray, int low, int high) {
        // 选择第一个元素作为基准
        int pivot = unSortedArray[low];
        while (low < high) {
            while (low < high && unSortedArray[high] >= pivot) {
                high--;
            }
            // 首先找到右侧比基准小的一个元素，放在左边
            unSortedArray[low] = unSortedArray[high];
            print(unSortedArray);
            while (low < high && unSortedArray[low] <= pivot) {
                low++;
            }
            // 再找到左侧比基准大的一个元素放在上面m
            unSortedArray[high] = unSortedArray[low];
            print(unSortedArray);
        }
        unSortedArray[low] = pivot;
        print(unSortedArray);
        return low;
    }

    /**
     * @param unSortedArray
     * @param low
     * @param high
     * @return pivot存储位置
     */
    private int rightPartition(int[] unSortedArray, int low, int high) {
        // 选取最右边的元素作为基准
        int pivot = unSortedArray[high];
        while (low < high) {
            while (low < high && unSortedArray[low] <= pivot) {
                low++;
            }
            unSortedArray[high] = unSortedArray[low];
            while (low < high && unSortedArray[high] >= pivot) {
                high--;
            }
            unSortedArray[low] = unSortedArray[high];
        }
        unSortedArray[high] = pivot;
        return high;
    }

    /**
     * 非递归实现
     *
     * @param array
     */
    @Override
    public void _sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

    }

    public static void main(String[] args) {
        Sort sort = new QuickSort();
        sort.sort(BaseSort.dataSet());
    }
}
