package cn.codingstar.test.xiechen.p01;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-29 下午7:22
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {

    private static void sort(int[] array) {
//        int i = 0;
//        int j = array.length - 1;
//        while (i < j) {
//            while (i < j && array[i] != 0) {
//                i++;
//            }
//            while (i < j && array[j] == 0) {
//                j--;
//            }
//            if (i < j) {
//                array[i] = array[j];
//                array[j] = 0;
//            }
//        }
//        for (int num : array) {
//            System.out.println(num);
//        }
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[j] = array[i];
                j++;
            }
        }
        for (; j < array.length; j++) {
            array[j] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N < 0) {
            return;
        }
        int[] array = new int[N];
        int count = 0;
        while (count < N) {
            array[count++] = in.nextInt();
        }
        sort(array);
    }
}
