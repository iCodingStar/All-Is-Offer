package cn.codingstar.leetcode.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MaximumProductOfWordLength.java
 * @time: 18-3-13 下午10:13
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://leetcode.com/problems/maximum-product-of-word-lengths/description/
 * @desc: 位图法
 */
/*
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
*/

/**
 * 解题思路：
 * 题目中的关键点是假设字符串中只有小写字母，小写字母只有26个，int整形有32位，那么我们可以将每一个字符串转化成一个整型数字，通过位运算来判断两个字符串是否有重复的字符。
 * 解题步骤：
 * 1. 将字符串数组转化成整型数组
 * 2. 借用冒泡排序的思想，查找没有相同字符的字符串
 * 3. 计算长度，保留最大值
 */
public class MaximumProductOfWordLength {
    public int maxProduct(String[] words) {

        // 如果字符串数组小于一个，无需计算吧
        if (words.length <= 1) {
            return 0;
        }

        // 创建一个与字符串相同大小的整型数组，将字符串数组中的字符串用整形数字表示
        int[] val = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                // 注意运算符的优先级
                val[i] |= 1 << (c - 'a');
            }
        }

        // 通过冒泡排序的思想，逐个排除
        int ret = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((val[i] & val[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        // 如果结束还未找到，返回0
        return ret;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLength solution = new MaximumProductOfWordLength();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}; // 16
        System.out.println(solution.maxProduct(words));
    }
}
