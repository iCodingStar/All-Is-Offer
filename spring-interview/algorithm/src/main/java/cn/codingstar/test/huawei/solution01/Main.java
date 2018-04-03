package cn.codingstar.test.huawei.solution01;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-4-3 下午7:04
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {

    public static int maxLength(String value) {
        if (value == null || value.length() == 0) {
            return 0;
        }
        if (value.length() == 1) {
            return 1;
        }
        int maxLength = 1;
        for (int i = value.length(); i >= 2; i--) {
            for (int j = 0; j < i - 1; j++) {
                String temp = value.substring(j, i);
                if (isTarget(temp) && maxLength < temp.length() && maxLength == 1) {
                    maxLength = temp.length();
                }
            }
        }
        return maxLength;
    }

    /**
     * 判断一个字符串是不是对称的
     *
     * @param value
     * @return
     */
    private static boolean isTarget(String value) {
        char[] values = value.toCharArray();
        int start = 0;
        int end = value.length() - 1;
        while (start < end) {
            if (values[start++] != values[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String value = in.nextLine().trim();
            System.out.println(maxLength(value));
        }
    }
}
