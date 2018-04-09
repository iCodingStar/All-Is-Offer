package cn.codingstar.test.jd;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Q1.java
 * @time: 18-4-9 下午7:53
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Q1 {

    public static void solution(String value) {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine().trim();
        int N = word.length();
        long[][] fun = new long[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            fun[i][i] = 1;
        }
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i < N; i++) {
                int k = L + i - 1;
                if (k < N) {
                    if (word.charAt(i) == word.charAt(k)) {
                        fun[i][k] = fun[i][k - 1] + fun[i + 1][k] + 1;
                    } else {
                        fun[i][k] = fun[i][k - 1] + fun[i + 1][k] - fun[i + 1][k - 1];
                    }
                }
            }
        }
        System.out.println(fun[0][N - 1]);
    }

}
