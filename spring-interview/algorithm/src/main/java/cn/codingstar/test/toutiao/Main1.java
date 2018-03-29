package cn.codingstar.test.toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Main1.java
 * @time: 18-3-24 下午7:44
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Main1 {


    private static void getOutputString(int value) {
        String zero =
                "66666" +
                        "6...6" +
                        "6...6" +
                        "6...6" +
                        "66666";
        String one =
                "....6" +
                        "....6" +
                        "....6" +
                        "....6" +
                        "....6";
        String two =
                "66666" +
                        "....6" +
                        "66666" +
                        "6...." +
                        "66666";
        String three =
                "66666" +
                        "....6" +
                        "66666" +
                        "....6" +
                        "66666";
        String four =
                "6...6" +
                        "6...6" +
                        "66666" +
                        "....6" +
                        "....6";
        String five =
                "66666" +
                        "6...." +
                        "66666" +
                        "....6" +
                        "66666";
        String six =
                "66666" +
                        "6...." +
                        "66666" +
                        "6...6" +
                        "66666";
        String seven =
                "66666" +
                        "....6" +
                        "....6" +
                        "....6" +
                        "....6";
        String eight =
                "66666" +
                        "6...6" +
                        "66666" +
                        "6...6" +
                        "66666";
        String nine =
                "66666" +
                        "6...6" +
                        "66666" +
                        "....6" +
                        "66666";
        Map<String, String> map = new HashMap<>();
        map.put("0", zero);
        map.put("1", one);
        map.put("2", two);
        map.put("3", three);
        map.put("4", four);
        map.put("5", five);
        map.put("6", six);
        map.put("7", seven);
        map.put("8", eight);
        map.put("9", nine);
        String values = String.valueOf(value);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < values.length(); j++) {
                String line = map.get(String.valueOf(values.charAt(j)));
                sb.append(line.substring(i * 5, i * 5 + 5));
                if (j != values.length() - 1) {
                    sb.append("..");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int calculate(String value) {
        StringBuilder left = new StringBuilder();
        for (char ch : value.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                left.append(ch);
            } else {
                break;
            }
        }
        String op = value.substring(left.length(), left.length() + 1);
        String rightValue = value.substring(left.length() + 1);
        String leftValue = left.toString();
        if (op.equals("+")) {
            return Integer.valueOf(leftValue) + Integer.valueOf(rightValue);
        }
        if (op.equals("-")) {
            return Integer.valueOf(leftValue) - Integer.valueOf(rightValue);
        }
        if (op.equals("*")) {
            return Integer.valueOf(leftValue) * Integer.valueOf(rightValue);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] values = new String[N];
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextLine();
        }

        for (String val : values) {
            getOutputString(calculate(val));
        }
    }


}
