package cn.codingstar.offer.basic;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: StringBufferTest.java
 * @time: 18-4-28 下午5:08
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class StringBufferTest {

    public static void change(StringBuilder s1, StringBuilder s2) {
        s1 = s2; // s1指向了s2
        s1.append("word");//　相当于外面的s2为"bad word"
        s2 = new StringBuilder();
        s2.append("hello world");
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        s1.append("good ");
        s2.append("bad ");
        // Java是值传递，不会改变传入参数的值。。。
        change(s1, s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }
}
