package cn.codingstar.leetcode.string;

import java.util.Stack;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: LongestValidParentheses.java
 * @time: 18-4-8 下午10:18
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class LongestValidParentheses {
    /**
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')' && !stack.isEmpty() && arr[stack.peek()] == '(') {
                // 如果栈顶的元素与当前遍历到的元素匹配，那么弹出栈顶的元素
                stack.pop();
                if (stack.isEmpty()) {
                    // 如果此时栈空，说明左侧全部匹配，因此可以得到所有匹配括号的数量
                    res = i + 1;
                } else {
                    // 否则重新计算
                    res = Math.max(res, i - stack.peek());
                }
            } else {
                // 如果不能匹配，直接入栈处理之
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()()"));
    }
}
