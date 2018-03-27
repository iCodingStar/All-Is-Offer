package cn.codingstar.test.wangyi.w02;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-27 下午8:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {

    /**
     * @param N
     * @param K
     * @return
     */
    private static int probability(int N, int K) {
        int count = 0;
        for (int x = 1; x <= N; x++) {
            for (int y = K; y <= N; y++) {
                if (MOD(x, y) >= K) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int MOD(int x, int y) {
        return x - y * (x / y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, K;
        N = in.nextInt();
        K = in.nextInt();
        System.out.println(probability(N, K));
    }


}
