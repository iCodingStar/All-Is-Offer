package cn.codingstar.offer.sort;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: InsertSort.java
 * @time: 2018/2/28 20:06
 * @software: Intellij Idea
 * @desc:
 */
public class InsertSort extends BaseSort {
    @Override
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        // 假定第一个元素已经排好序
        for (int i = 1; i < array.length; i++) {
            System.out.println("插入元素" + array[i]);
            // 给第i个元素找合适的位置插入
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
                print(array);
            }
        }
        print(array);
    }

    @Override
    public void _sort(int[] array) {

    }

    public static void main(String[] args) {
        Sort sort = new InsertSort();
        sort.sort(BaseSort.dataSet());
    }
}
