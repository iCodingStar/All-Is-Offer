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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null)
            return -1;
        if (gas.length < cost.length) {
            return -1;
        }
        int[] diff = new int[gas.length];
        // 计算出站点油存量与到达下一站耗油量的差值
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int leftGas = 0;
        int sum = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            leftGas += diff[i];
            sum += diff[i];
            if (sum < 0) {
                startStation = i + 1;
                sum = 0;
            }
        }
        if (leftGas < 0)
            return -1;
        else
            return startStation;
    }
}
