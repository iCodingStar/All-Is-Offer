package cn.codingstar.test;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: PearlsSelect.java
 * @time: 18-3-15 上午9:15
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: N种珠子组成M长度的项链的方法
 */
public class PearlsSelect {

    public static int select(int n, int m, int[][] pearls) {
        int result = 0;
        // 寻找数组中起始最小值
        int minIndex = 0;
        for (int i = 1; i < pearls.length; i++) {
            if (pearls[i - 1][0] > pearls[i][0]) {
                minIndex = i;
            }
        }
        for (int i = 0; i <= pearls[minIndex][1]; i++) {
            result += min(m - (i + pearls[1][0] + pearls[2][0]) + 1, (i + pearls[1][1] + pearls[2][1]) - m + 1);
        }
        return result;
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = null;
        line = scanner.nextLine();
        String[] input = line.split(" ");
        int N = Integer.valueOf(input[0]);
        int M = Integer.valueOf(input[1]);
        int pearls[][] = new int[N][2];
        int count = 0;
        while (count < N) {
            input = scanner.nextLine().split(" ");
            pearls[count][0] = Integer.valueOf(input[0]);
            pearls[count][1] = Integer.valueOf(input[1]);
            count++;
        }
        System.out.println(select(N, M, pearls));
    }


}
