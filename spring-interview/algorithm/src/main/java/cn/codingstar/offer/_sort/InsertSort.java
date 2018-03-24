package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: InsertSort.java
 * @time: 18-3-24 上午10:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class InsertSort extends BaseSort {

    /**
     * 插入排序是稳定的排序
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 假定第一个元素已经有序
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    /**
     * 1, 8, 3, 5, 9, 4, 2, 7, 6,
     *
     * @param array
     */
    @Override
    public void _sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            // 保存即将插入的元素
            int temp = array[i];
            // 条件必须写在这里
            for (; j > 0 && temp < array[j - 1]; j--) {
                // 将大元素后移,给目标元素找位置
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }


    public static void main(String[] args) {
        Sort sort = new InsertSort();
        int[] array = BaseSort.dataSet();
        sort._sort(array);
        sort.print(array);
    }

}
