package cn.codingstar.test.xiechen.p03;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-29 下午8:17
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if (N <= 0) {
            return;
        }
        int[][] array = new int[N][3];
        int count = 0;
        while (count < N) {
            for (int i = 0; i < 3; i++) {
                array[count][i] = in.nextInt();
            }
            count++;
        }
        int[] people = new int[3];
        count = 0;
        while (count < 3) {
            people[count++] = in.nextInt();
        }
        System.out.println(-1);
    }

}
