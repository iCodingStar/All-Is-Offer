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

    /**
     * 返回目标值的最小索引值
     *
     * @param array
     * @param target
     * @return
     */
    public int lowerBounds(int[] array, int target) {
        int res = -1;
        if (array == null || array.length == 0) {
            return res;
        }
        int lo = -1;
        int up = array.length;
        while (lo + 1 < up) {
            int mid = lo + (up - lo) / 2;
            if (array[mid] < target) {
                lo = mid;
            } else {
                up = mid;
            }
        }
        return lo + 1;
    }


    /**
     * 返回目标值的最大索引值
     *
     * @param array
     * @param target
     * @return
     */
    public int upperBounds(int[] array, int target) {
        int res = -1;
        if (array == null || array.length == 0) {
            return res;
        }
        int lo = -1;
        int up = array.length;
        while (lo + 1 < up) {
            int mid = lo + (up - lo) / 2;
            if (array[mid] > target) {
                up = mid;
            } else {
                lo = mid;
            }
        }
        return up - 1;
    }

    public static void main(String[] args) {
        int[] array = BaseDataSet.SORTED_ARRAY;
        BinarySearch search = new BinarySearch();
        System.out.println(search.search(array, 5));
        System.out.println(search.lowerBounds(array, 5));
        System.out.println(search.upperBounds(array, 5));

        System.out.println(search.search(array, 25));
        System.out.println(search.lowerBounds(array, 25));
        System.out.println(search.upperBounds(array, 25));
    }
}
