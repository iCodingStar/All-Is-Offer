package cn.codingstar.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: TwoSum.java
 * @time: 18-3-14 上午9:27
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {

    /**
     * 好久没写了，想的有点复杂,时间复杂度为O(2n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 数组检查
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap();
        // 将数组存放到HashMap中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 遍历数组，寻找答案
        Integer secondIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            // 寻找这个元素
            if ((secondIndex = map.get(target - nums[i])) != null) {
                // 判断是否是相同的元素
                if (i != secondIndex) {
                    // 找到了符合要求的元素
                    if (i > secondIndex) {
                        int temp = i;
                        i = secondIndex;
                        secondIndex = temp;
                    }
                    return new int[]{i, secondIndex};
                }
            }
        }
        return null;
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum_(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // 每遍历到一个元素，就检查map中是否存在这样的数字，如果有就更新之,最后得到的是最终出现的数字
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 4, 4};
        System.out.println(twoSum_(data, 6));
    }

}
