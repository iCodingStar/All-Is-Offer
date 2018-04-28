package cn.codingstar.leetcode.v2.sequence;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: LongestSubString.java
 * @time: 18-4-28 下午8:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * @desc:
 */
public class LongestSubString {

    public int lengthOfLongestString(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        int maxLength = 0x80000000;
        char[] str = s.toCharArray();
        int[] table = new int[256];
        for (int i = 0; i < 256; i++) {
            table[i] = -1;
        }
        int leftBound = 0;
        for (int i = 0; i < str.length; i++) {
            // 如果当前的字符
            leftBound = table[str[i]] == -1 ? leftBound : table[str[i]] + 1;
            maxLength = Math.max(maxLength, i - leftBound + 1);
            table[str[i]] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(0x80000000);
        System.out.println(0x7fffffff);
        LongestSubString longestSubString = new LongestSubString();
        //System.out.println(longestSubString.lengthOfLongestString(""));;
        //System.out.println(longestSubString.lengthOfLongestString("abcab"));
        //System.out.println(longestSubString.lengthOfLongestString("aaaa"));
        //System.out.println(longestSubString.lengthOfLongestString("abcbcz"));
        System.out.println(longestSubString.lengthOfLongestString("abba"));

    }

}
