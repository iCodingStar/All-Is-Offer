package cn.codingstar.offer._sort;

import jdk.nashorn.tools.Shell;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ShellSort.java
 * @time: 18-3-24 上午11:36
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ShellSort extends BaseSort {

    /**
     * 插入排序的优化
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                // 为array[i]寻找正确的插入位置
                int temp = array[i];
                for (; j >= gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            // 减小gap
            gap /= 2;
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = BaseSort.dataSet();
        Sort sort = new ShellSort();
        sort.sort(array);
        sort.print(array);
    }
}
