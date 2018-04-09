package cn.codingstar.test.jd;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void solution(String value) {
        char[] values = value.toCharArray();
        if (values.length <= 2) {
            System.out.println("NO");
            return;
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
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int samples = Integer.valueOf(in.nextLine().trim());
        int count = 0;
        while (count < samples) {
            solution(in.nextLine().trim());
            count++;
        }
    }

}