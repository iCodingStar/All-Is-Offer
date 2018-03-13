package cn.codingstar.leetcode.ds;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: SumOfTwoIntegers.java
 * @time: 18-3-13 下午10:22
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 不使用加法计算两个整数的和
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example:
 * Given a = 1 and b = 2, return 3.
 */

/**
 Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */

/**
 * 解题思路：
 * 异或运算 ： 二进制中相同位异或结果为0，不同位异或结果为1，两个数异或运算后， 都为1的位化为0，不全为1的位保留了，都为1的位需要进位
 * 与运算：全为1的位运算结果为1，与运算后，向左移动一位即可实现进位
 * 递归运算直至与运算结果为0的时候，递归结束，异或运算结果即为相加的结果
 */
public class SumOfTwoIntegers {

    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum(4, 5));
    }
}
