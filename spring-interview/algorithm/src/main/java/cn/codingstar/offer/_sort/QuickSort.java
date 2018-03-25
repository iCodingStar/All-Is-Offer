package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: QuickSort.java
 * @time: 18-3-25 下午9:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class QuickSort extends BaseSort {

    @Override
    public void sort(int[] array) {
        qsort(array, 0, array.length - 1);
    }

    private void qsort(int[] array, int low, int high) {
        if (low < high) {
            // 先把当前数组进行partition
            int slot = partition(array, low, high);
            qsort(array, 0, slot - 1);
            qsort(array, slot + 1, high);
        }
    }

    /**
     * 将一个数组划分成两个数组,填坑法
     *
     * @param array
     * @param low
     * @param high
     */
    private int partition(int[] array, int low, int high) {
        // 选择array[low]元素作为基准
        int pivot = array[low];
        // 用基准划分数组，并且将基准放入正确的位置
        while (low < high) {
            // 先找到右边一个比pivot小的数放在左边
            while (low < high && array[high] >= pivot) {
                high--;
            }
            array[low] = array[high];
            // 然后找到左边一个比pivot大的数，放在刚才腾出的位置
            while (low < high && array[low] <= pivot) {
                low++;
            }
            array[high] = array[low];
            // 此时，左边又会出现一个坑
        }
        array[low] = pivot;
        return low;
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = BaseSort.dataSet();
        QuickSort sort = new QuickSort();
        sort.sort(array);
        sort.print(array);
    }
}
