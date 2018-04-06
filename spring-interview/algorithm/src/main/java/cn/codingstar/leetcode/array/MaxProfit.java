package cn.codingstar.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MaxProfit.java
 * @time: 18-4-6 下午9:36
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 购买和销售股票的最佳时机
 */
public class MaxProfit {

    /**
     * 每天股票交易的价格，求一段时间内购买销售股票一次，可获得的最大收益
     *
     * @param prices
     * @return
     */
    public static int maxProfitForOnce(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int minPrice = 0x7fffffff;
        int maxProfit = 0x80000000;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            // 计算差价
            int diff = prices[i] - minPrice;
            if (diff > maxProfit)
                maxProfit = diff;
        }
        return maxProfit;
    }

    /**
     * 计算一段时间内买卖股票可以获得的最大收益，必须先买后卖，不可重复购买
     *
     * @param prices
     * @return
     */
    public static int maxProfitForAll(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfitSum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff >= 0) {
                maxProfitSum += diff;
            }
        }
        return maxProfitSum;
    }

    /**
     * 计算一段时间内仅进行两次买入卖出所能获得的最大收益
     *
     * @param prices
     * @return
     */
    public static int maxProfitForTwice(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] maxProfitLeft = new int[prices.length];
        int minPrice = 0x7fffffff;
        int maxProfit = 0x80000000;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            int diff = prices[i] - minPrice;
            if (diff > maxProfit)
                maxProfit = diff;
            maxProfitLeft[i] = maxProfit;
        }
        int maxPrice = 0x80000000;
        maxProfit = 0x80000000;
        // 从右向左计算股票交易的最大利润
        int[] maxProfitRight = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (maxPrice < prices[i])
                maxPrice = prices[i];
            int diff = maxPrice - prices[i];
            if (diff > maxProfit)
                maxProfit = diff;
            maxProfitRight[i] = maxProfit;
        }
        //计算最终的最大收益
        maxProfit = 0x80000000;
        for (int i = 0; i < prices.length - 1; i++) {
            int sum = maxProfitLeft[i] + maxProfitRight[i + 1];
            if (maxProfit < sum)
                maxProfit = sum;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {3300, 3200, 3100, 4500, 4300, 4200, 4900};
        // 测试如果只进行一次买入和卖出能获得的收益
        System.out.println(maxProfitForOnce(prices));
        System.out.println(maxProfitForAll(prices));
        System.out.println(maxProfitForTwice(prices));
    }
}
