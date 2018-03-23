package cn.codingstar.offer.string;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: KMP.java
 * @time: 18-3-23 上午11:05
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class KMP {

    /**
     * 计算
     *
     * @param pattern
     */
    public static void compute_next(final String pattern) {
        final int patternLength = pattern.length();
        int[] next = new int[patternLength];

        next[0] = -1;
        int index;
        for (int i = 1; i < patternLength; i++) {
            // 存储前一个失败的位置
            index = next[i - 1];
            while (index >= 0 && pattern.charAt(i) != pattern.charAt(index + 1)) {
                index++;
            }
            if (pattern.charAt(i) == pattern.charAt(index + 1)) {
                next[i] = index + 1;
            } else {
                next[i] = -1;
            }
        }

        for (int i : next) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        compute_next("abcdabc");
    }
}
