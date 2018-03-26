package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BubbleSort.java
 * @time: 18-3-26 下午2:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 冒泡排序
 */
public class BubbleSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        //已经排好序的数量
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                // 冒大泡
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        int[] array = BaseSort.dataSet();
        sort.sort(array);
        sort.print(array);
    }
}
