package cn.codingstar.test.meituan.solution1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int p = in.nextInt();
        int[] A = new int[N];
        A[0] = p;
        for (int i = 1; i < N; i++) {
            A[i] = (A[i - 1] + 153) % p;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum += A[gcd(i, j) - 1];
            }
        }
        System.out.println(sum);
    }

    public static int gcd(int x, int y) {
        while (y != 0) {
            int r = y;
            y = x % y;
            x = r;
        }
        return x;
    }
}