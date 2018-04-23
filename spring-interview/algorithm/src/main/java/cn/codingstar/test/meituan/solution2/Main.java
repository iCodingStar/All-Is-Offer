package cn.codingstar.test.meituan.solution2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            int value = 1;
            int j = i;
            while (j > 0) {
                value *= 10;
                j--;
            }
            map.put(i, value);
        }

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] result = new int[N];
        int count = 0;
        while (count < N) {
            long num = in.nextLong();
            int sum = 0;
            int length = (num + "").length();
            if (length == 1) {
                sum = Integer.parseInt(num + "");
            } else {
                while (num > 0) {
                    sum += (num - map.get(length) + 1) * length;
                    num = map.get(length - 1);
                    length--;
                }
            }
            result[count++] = sum;
        }
        for (int res : result) {
            System.out.println(res);
        }
    }

}
