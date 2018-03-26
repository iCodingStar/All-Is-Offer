package cn.codingstar.handbook.String;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ImplementStrStr.java
 * @time: 18-3-26 下午8:07
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ImplementStrStr {

    /**
     * 粗暴的字符串匹配算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    private static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        // 外层循环一定要注意前一个字符串剩余的长度至少为子串的长度
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 从前一个字符串位置i开始比较
            int j = 0;
            for (; j < needle.length(); j++) {
                // 如果检测到不一致，退出此轮比较，开始下一轮
                if ((haystack.charAt(i + j) != needle.charAt(j))) {
                    break;
                }
            }
            // 比较结束之后，检查子串是否到了最后，循环结束的时候，j已经到了needle.length()
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "aaaa";
        System.out.println(strStr(str1, str2));
    }
}
