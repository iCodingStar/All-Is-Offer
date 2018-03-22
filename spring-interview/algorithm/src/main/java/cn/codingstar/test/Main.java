package cn.codingstar.test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main.java
 * @time: 18-3-22 下午7:26
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */

/**
 * 8,9;4,6;3,7;6,8
 *
 * 8,9;
 * 4,6;
 * 3,7;
 * 6,8
 *
 * <p>
 * 3,7
 * 4,6
 * 6,8
 * 8,9
 */
public class Main {


    private static final String carSplit = ";";
    private static final String timeSplit = ",";
    private static final String regress = "(\\d{1,2},\\d{1,2};)*\\d{1,2},\\d{1,2}$";

    public static void main(String[] args) {
        String inString = null;
        // 数据输入
        Scanner in = new Scanner(System.in);
        inString = in.nextLine();
        //字符串数组格式校验
        Pattern pat = Pattern.compile(regress);
        if (inString == null || inString.trim().equals("") || !pat.matcher(inString).matches()) {
            System.out.println("输入错误!");
            return;
        }
        Main sol = new Main();
        int countCars = sol.countCars(sol.convertToArray(inString));
        System.out.println(countCars);
    }

    //输入字符串转数组
    public int[][] convertToArray(String str) {
        String[] strArray = str.split(carSplit);
        int row = strArray.length;
        int col = 2;
        // 字符转数组判断
        int[][] carArray = new int[row][col];
        int start, end;
        for (int i = 0; i < row; i++) {
            start = Integer.parseInt(strArray[i].split(timeSplit)[0]);
            end = Integer.parseInt(strArray[i].split(timeSplit)[1]);
            if (start > end) {
                continue;
            }
            carArray[i][0] = start;
            carArray[i][1] = end;
        }
        return carArray;
    }

    //核心算法实现
    public int countCars(int[][] carArray) {
        int ans = 0;
//        int[] startTime = new int[carArray.length];
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < carArray.length; i++) {
//            startTime[i] = carArray[i][0];
//            map.put(carArray[i][0], carArray[i][1]);
////        }
//        Arrays.sort(startTime);
        for (int i = 0; i < carArray.length - 1; i++) {
            int current = 1;
            for (int j = i + 1; j < carArray.length; j++) {
                if ((carArray[j][0] > carArray[i][0] && carArray[j][0] < carArray[i][1])
                        || (carArray[j][1] > carArray[i][0] && carArray[j][1] < carArray[i][1])) {
                    current++;
                }

            }
            ans = Math.max(current, ans);
        }
        return ans; // 返回计算结果
    }

}
