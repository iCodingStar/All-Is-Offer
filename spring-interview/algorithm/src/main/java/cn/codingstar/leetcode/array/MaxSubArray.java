package cn.codingstar.leetcode.array;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MaxSubArray.java
 * @time: 18-4-8 下午7:52
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class MaxSubArray {

    public int maxSubArray(int[] array) {
        int sum = 0;
        int max = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            // 如果当前的和已经小于0，则重新开始计算
            if (sum < 0) {
                sum = 0;
            }
            max = max < sum ? sum : max;
        }
        return max;
    }
}
