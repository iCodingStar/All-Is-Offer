package cn.codingstar.test;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: MinNumber.java
 * @time: 18-3-22 下午8:58
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class MinNumber {

    public static void main(String[] args) {
        //
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        int[] num = new int[10];
        for (char ch : value.toCharArray()) {
            num[ch - 48]++;
        }
        System.out.println(getMinNumber(num));
    }

    private static int getMinNumber(int[] num) {
        for (int i = 1; i < num.length; i++) {
            if (num[i] == 0) {
                return i;
            }
        }
        if (num[0] == 0) {
            return 10;
        } else {
            return 11;
        }
    }
}

