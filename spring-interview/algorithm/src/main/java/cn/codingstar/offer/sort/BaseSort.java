package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: BaseSort.java
 * @time: 2018/2/28 15:29
 * @software: Intellij Idea
 * @desc:
 */
public abstract class BaseSort implements Sort {

    public void print(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    @Override
    public void swap(int[] array, int _index, int index_) {
        int temp = array[_index];
        array[_index] = array[index_];
        array[index_] = temp;
    }

    public static int[] dataSet() {
        return new int[]{1, 8, 3, 5, 9, 4, 2, 7, 6,};
    }

}
