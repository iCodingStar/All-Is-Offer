package cn.codingstar.offer.algorithm;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: DiffBit.java
 * @time: 18-3-11 下午4:26
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 判断两个
 */
public class DiffBit {

    public static void main(String[] args) {
        int a = 1000;
        int b = 50000;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a ^ b));
        System.out.println(Integer.bitCount(a ^ b));
    }
}
