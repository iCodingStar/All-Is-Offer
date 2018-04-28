package cn.codingstar.leetcode.v2.top100;

import java.util.Stack;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: ValidParentheses.java
 * @time: 18-4-26 下午9:46
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class ValidParentheses {

    /**
     * 通过使用栈来模拟消除可匹配的括号，如果最后栈中元素全部被消除，说明所有括号匹配
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null)
            return false;
        Stack<Character> stack = new Stack();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (stack.size() != 0 && isParentheses(stack.peek(), str[i])) {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }
        return stack.size() == 0;
    }

    /**
     * 判断两个括号是否可以配对
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isParentheses(char a, char b) {
        if (a == '(' && b == ')')
            return true;
        if (a == '[' && b == ']')
            return true;
        if (a == '{' && b == '}')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String str1 = "";
        String str2 = "{[()]}";
        String str3 = "{";
        String str4 = "{([])}";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(str1));
        System.out.println(v.isValid(str2));
        System.out.println(v.isValid(str3));
        System.out.println(v.isValid(str4));
    }
}
