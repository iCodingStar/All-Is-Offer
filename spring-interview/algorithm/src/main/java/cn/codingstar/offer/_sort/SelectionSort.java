package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SelectionSort.java
 * @time: 18-3-26 下午2:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 选择排序
 */
public class SelectionSort extends BaseSort {

    @Override
    public void sort(int[] array) {

        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }

    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        int[] array = BaseSort.dataSet();
        sort.sort(array);
        sort.print(array);
    }
}
