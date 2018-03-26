package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MergeSort.java
 * @time: 18-3-26 下午2:11
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class MergeSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
    }

    private void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid, temp);
            mergeSort(array, mid + 1, right, temp);
            // 先划分，再合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * @param array
     * @param left  左有序数组起始坐标
     * @param mid   中间位置
     * @param right 右有序数组结束坐标
     * @param temp
     */
    private void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0; // 临时数组指针
        // 保证i,j位置合法
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        // 处理左有序数组中为处理完的部分
        while (i <= mid) {
            temp[t++] = array[i++];
        }

        // 处理右有序数组中未处理完的部分
        while (j <= right) {
            temp[t++] = array[j++];
        }
        // 处理结束，将temp数组中的数据回写到array
        i = left;
        t = 0;
        while (i <= right) {
            array[i++] = temp[t++];
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {

        int[] array = BaseSort.dataSet();
        MergeSort sort = new MergeSort();
        sort.sort(array);
        sort.print(array);
    }

}
