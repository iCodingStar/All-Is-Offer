package cn.codingstar.leetcode.array;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MaxAreaForWater.java
 * @time: 18-4-8 下午5:22
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class MaxAreaForWater {

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0x80000000;
        while (start < end) {
            int currentArea = height[start] < height[end] ? height[start] * (end - start) : height[end] * (end - start);
            maxArea = maxArea < currentArea ? currentArea : maxArea;
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
        System.out.println(maxArea(height));
    }
}
