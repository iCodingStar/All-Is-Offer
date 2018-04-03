package cn.codingstar.test.xiechen.p02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-29 下午7:57
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {

    public static int[][] convert(int[][] b) {
        if (b.length == 1) {
            return b;
        }
        int[][] temp = new int[b[0].length][b.length];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                temp[i][j] = b[b[i].length - j - 1][i];
            }
        }
        return temp;
    }

    public static void printArray(int[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                if (j != f.length - 1) {
                    System.out.print(f[i][j] + " ");
                } else {
                    System.out.print(f[i][j]);
                }
            }
            if (i != f.length - 1) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        String[] values = line.trim().split(" ");
//        if (values.length < 1) {
//            return;
//        }
//        int[][] array = new int[values.length][values.length];
//        for (int i = 0; i < values.length; i++) {
//            array[0][i] = Integer.valueOf(values[i]);
//        }
//        int count = 1;
//        while (count < values.length) {
//            for (int i = 0; i < values.length; i++) {
//                array[count][i] = scanner.nextInt();
//            }
//            count++;
//        }
//        printArray(convert(array));
    }
}
