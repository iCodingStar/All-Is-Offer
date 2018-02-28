package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: SelectionSort.java
 * @time: 2018/2/28 17:14
 * @software: Intellij Idea
 * @desc:选择排序 O(n ^ 2)
 */
public class SelectionSort extends BaseSort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        print(array);
        for (int i = 0; i < array.length; i++) {
            // 寻找array[i,array.length-1]中的最小值
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
            print(array);
        }
        print(array);
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        Sort sort = new SelectionSort();
        sort.sort(BaseSort.dataSet());
    }
}
