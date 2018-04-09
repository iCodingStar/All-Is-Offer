package cn.codingstar.test.jd;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Q2.java
 * @time: 18-4-9 下午7:53
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Q2 {

    public static void solution() {
        Scanner in = new Scanner(System.in);
        int samples = Integer.valueOf(in.nextLine().trim());
        long[] values = new long[samples];
        int count = 0;
        while (count < samples) {
            values[count++] = Long.valueOf(in.nextLine().trim());
        }
        String[] result = new String[samples];
        for (int i = 0; i < samples; i++) {
            if (values[i] % 2 == 0) {
                long x = values[i] >> 1;
                long y = 2;
                while (x % 2 == 0) {
                    x = x >> 1;
                    y = y << 1;
                }
                result[i] = x + " " + y;
            } else {
                result[i] = "NO";
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int samples = Integer.parseInt(in.nextLine().trim());
        String[] result = new String[samples];
        int count = 0;
        while (count < samples) {
            long num = in.nextLong();
            if (num % 2 == 1) {
                result[count++] = "NO";
            } else {
                long x = num;
                while (x % 2 == 0) {
                    x = x >> 1;
                }
                long y = num / x;
                result[count++] = x + " " + y;
            }
        }
        for (String res : result) {
            System.out.println(res);
        }
    }
}
