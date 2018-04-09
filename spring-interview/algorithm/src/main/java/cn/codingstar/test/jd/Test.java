package cn.codingstar.test.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Test.java
 * @time: 18-4-9 下午8:35
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resultource:
 * @desc:
 */
public class Test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long num = in.nextLong();
            if (num % 2 == 1) {
                result.add("No");
            } else {
                long x = num;
                while (x % 2 == 0) {
                    x = x / 2;
                }
                long y = num / x;
                result.add(x + " " + y);
            }
        }
        for (String word : result) {
            System.out.println(word);
        }
    }

}
