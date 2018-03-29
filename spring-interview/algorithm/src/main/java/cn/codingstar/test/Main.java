package cn.codingstar.test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-22 下午7:26
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

/**
 * 8,9;4,6;3,7;6,8
 * <p>
 * 8,9;
 * 4,6;
 * 3,7;
 * 6,8
 * <p>
 * <p>
 * 3,7
 * 4,6
 * 6,8
 * 8,9
 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) return;
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();
        sort(array);
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);
    }

    public static void sort(int[] array) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) array[j++] = array[i];
        }
        for (; j < array.length; j++) array[j] = 0;
    }
}