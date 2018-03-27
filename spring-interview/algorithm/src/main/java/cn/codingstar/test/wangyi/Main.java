package cn.codingstar.test.wangyi;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-27 下午8:22
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    /**
     * 返回最接近的分
     *
     * @param scores
     * @param score
     * @return
     */
    private static int getMax(int[] scores, int score) {
        int low = 0;
        int high = scores.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > score) {
                high = mid - 1;
            } else {
                return scores[mid];
            }
        }
//        for (int i = scores.length - 1; i >= 0; i--) {
//            if (scores[i] <= score) {
//                return scores[i];
//            }
//        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N, M;
        N = in.nextInt();
        M = in.nextInt();
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] scores = new int[N];
        while (count < N) {
            int score = in.nextInt();
            scores[count] = score;
            map.put(score, in.nextInt());
            count++;
        }
        Arrays.sort(scores);
        int[] partners = new int[M];
        count = 0;
        while (count < M) {
            partners[count++] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(getMax(scores, partners[i])));
        }
    }
}
