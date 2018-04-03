package cn.codingstar.test.huawei.solution03;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-4-3 下午7:49
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://blog.csdn.net/jeffleo/article/details/53504409
 * @desc: 40
 * 12 13 23 26
 * 11 11 20 30
 */
public class Main {

    public static void calculate(int[] weight, int[] value, int totalFlow) {

        int[][] f = new int[weight.length][totalFlow + 1];
        int n = weight.length - 1;
        int i = n, j;
        // 首先对最底下的进行填充
        for (j = 1; j <= totalFlow; j++) {
            if (j < weight[i]) {
                f[i][j] = 0;
            } else {
                f[i][j] = value[i];
            }
        }

        //然后对剩下的n-1个物品填充
        for (i = n - 1; i > 0; i--) {
            for (j = 1; j <= totalFlow; j++) {
                if (j < weight[i]) {
                    f[i][j] = f[i + 1][j];
                } else {
                    f[i][j] = max(f[i + 1][j - weight[i]] + value[i], f[i + 1][j]);
                }
            }
        }

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= totalFlow; j++) {
                System.out.print(f[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(f[1][totalFlow]);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flow = Integer.valueOf(in.nextLine().trim());
        int[] weight;
        int[] value;
        String line = in.nextLine().trim();
        String[] values = line.split(" ");
        weight = new int[values.length + 1];
        for (int i = 1; i <= values.length; i++) {
            weight[i] = Integer.valueOf(values[i - 1]);
        }

        line = in.nextLine().trim();
        values = line.split(" ");
        value = new int[values.length + 1];
        for (int i = 1; i <= values.length; i++) {
            value[i] = Integer.valueOf(values[i - 1]);
        }

        calculate(weight, value, flow);
    }
}
