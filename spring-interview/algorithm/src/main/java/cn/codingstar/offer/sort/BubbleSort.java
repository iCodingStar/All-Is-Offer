package cn.codingstar.offer.sort;

import java.util.Arrays;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: BubbleSort.java
 * @time: 2018/2/28 15:03
 * @software: Intellij Idea
 * @desc: 冒泡排序 : O(n^2)
 */
public class BubbleSort extends BaseSort {

    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        // 外围循环代表需要排序的序列
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                print(array);
            }
        }
    }

    /**
     * @param array
     */
    public void _sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                print(array);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 8, 3, 5, 9, 4, 2, 7, 6,};
        Sort sort = new BubbleSort();
        sort._sort(array);
        sort.print(array);
    }

}
