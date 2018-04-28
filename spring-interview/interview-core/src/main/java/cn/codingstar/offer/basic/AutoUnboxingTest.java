package cn.codingstar.offer.basic;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AutoUnboxingTest.java
 * @time: 18-4-28 下午4:54
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class AutoUnboxingTest {

    public static void main(String[] args) {

        Integer a = 3;
        Integer b = 3;
        Integer c = new Integer(3);
        int d = 3;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a == d);

        Integer i1 = 127, i2 = 127, i3 = 128, i4 = 128, i5 = -128, i6 = -128, i7 = -129, i8 = -129;
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false
        System.out.println(i5 == i6); // true
        System.out.println(i7 == i8); // false
    }
}
