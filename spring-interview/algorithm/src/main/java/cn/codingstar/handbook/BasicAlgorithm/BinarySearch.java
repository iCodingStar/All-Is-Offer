package cn.codingstar.handbook.BasicAlgorithm;

import cn.codingstar.dataset.BaseDataSet;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BinarySearch.java
 * @time: 18-3-26 下午3:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 二分查找
 */
public class BinarySearch {

    /**
     * 在有序数组中查找目标，返回目标的索引，如果有多个索引，返回值是任意的
     *
     * @param array  排序数组
     * @param target 查找目标
     * @return
     */
    public int search(int[] array, int target) {
        int index = -1;
        if (array == null || array.length == 0) {
            return index;
        }
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] array = BaseDataSet.SORTED_ARRAY;
        BinarySearch search = new BinarySearch();
        for (int i = 0; i < array.length; i++) {
            System.out.println(search.search(array, i));
        }
    }
}
