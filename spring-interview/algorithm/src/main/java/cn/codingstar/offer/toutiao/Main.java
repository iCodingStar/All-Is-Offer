package cn.codingstar.offer.toutiao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-24 下午7:03
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main {

    public static int getNum(int[] array, int K) {
        Set<String> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (map.get(array[i] - K) != null) {
                set.add(array[map.get(array[i] - K)] + array[i] + "");
            }
            if (map.get(array[i] + K) != null) {
                set.add(array[i] + array[map.get(array[i] + K)] + "");
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.trim().split(" ");
        int N = Integer.valueOf(values[0]);
        int K = Integer.valueOf(values[1]);
        value = scanner.nextLine();
        values = value.trim().split(" ");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.valueOf(values[i]);
        }
        System.out.println(getNum(array, K));
    }
}
