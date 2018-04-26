package cn.codingstar.leetcode.v1.binary;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AddBinary.java
 * @time: 18-4-6 下午8:31
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class AddBinary {

    /**
     * a与b都是二进制的字符串，求解a与b相加的结果
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            char ai, bi;
            if (i >= 0) {
                ai = a.charAt(i);
            } else {
                ai = '0';
            }
            if (j >= 0) {
                bi = a.charAt(j);
            } else {
                bi = '0';
            }
            int currentVal = carry + (ai - '0') + (bi - '0');
            int val = currentVal % 2;
            sb.insert(0, val);
            carry = currentVal / 2;
        }
        if (carry == 1) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "11";
        System.out.println(addBinary(a, b));
    }
}
