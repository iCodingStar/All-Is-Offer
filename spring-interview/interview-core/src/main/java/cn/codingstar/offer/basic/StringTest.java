package cn.codingstar.offer.basic;

import java.util.Scanner;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: StringTest.java
 * @time: 18-4-28 下午5:23
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: https://www.zhihu.com/question/36908414p
 * @desc:
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "a";
        String param = new String("param" + a);
        String paramSame = param.intern();
        System.out.println(param == paramSame);

        String b = new Scanner(System.in).next();
        String param2 = new String("param2" + b);
        String param2Same = param2.intern();
        System.out.println(param2 == param2Same);
    }
}
