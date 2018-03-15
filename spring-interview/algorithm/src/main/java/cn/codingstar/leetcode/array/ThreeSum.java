package cn.codingstar.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ThreeSum.java
 * @time: 18-3-14 下午9:47
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ThreeSum {

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        int i = 0;
        // 固定第一个元素之后，依次向后查找
        while (i < nums.length - 2) {
            // 如果第一个元素已经大于0，结束查找
            if (nums[i] > target) {
                break;
            }
            // 确定第一个元素之后，开始用twoSum的原理
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 求和
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                // 当求和小于或等于目标的时候
                if (sum <= target) {
                    while (nums[j] == nums[++j] && j < k) ;
                }
                // 当求和大于或等于目标的时候
                if (sum >= target) {
                    while (nums[k--] == nums[k] && j < k) ;
                }
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) ;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums, 0);
        System.out.println(lists.toString());
    }
}
