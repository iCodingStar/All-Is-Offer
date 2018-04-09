package cn.codingstar.test.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: Q3.java
 * @time: 18-4-9 下午7:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class Q3 {

    public static String solution(String value) {
        char[] values = value.toCharArray();
        if (values.length <= 2) {
            return "No";
        }
        Stack<Integer> stack = new Stack<>();
        int validLength = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == ')' && !stack.isEmpty() && values[stack.peek()] == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    validLength = i + 1;
                } else {
                    validLength = Math.max(validLength, i - stack.peek());
                }
            } else {
                stack.push(i);
            }
        }
        if (values.length - validLength == 2 || values.length - validLength == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int samples = Integer.parseInt(in.nextLine().trim());
        int count = 0;
        List<String> result = new ArrayList<>();
        while (count < samples) {
            result.add(solution(in.nextLine().trim()));
            count++;
        }
        for (String res : result) {
            System.out.println(res);
        }
    }

}
