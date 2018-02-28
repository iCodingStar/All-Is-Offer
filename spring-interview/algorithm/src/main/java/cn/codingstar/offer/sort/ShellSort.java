package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: ShellSort.java
 * @time: 2018/2/28 20:23
 * @software: Intellij Idea
 * @desc: 希尔排序-插入排序的改进版
 * 好的：n(log(n)^2)
 */
public class ShellSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int gap = array.length / 2;
        while (gap > 0) {
            // 以gap为间隔对数组进行插入排序
            System.out.println("gap = " + gap);
            for (int i = gap; i < array.length; i++) {
                System.out.println("i = " + i);
                for (int j = i; j > 0; j -= gap) {
                    print(array);
                    if (j - gap >= 0 && array[j] < array[j - gap]) {
                        swap(array, j, j - gap);
                    } else {
                        break;
                    }
                }
            }
            gap = gap >>> 1;
        }
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        Sort sort = new ShellSort();
        sort.sort(BaseSort.dataSet());
    }
}
