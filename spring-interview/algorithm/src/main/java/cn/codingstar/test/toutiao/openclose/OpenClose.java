package cn.codingstar.test.toutiao.openclose;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: OpenClose.java
 * @time: 18-4-3 下午9:34
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class OpenClose {

    public static Set<String> findAll(int n) {
        Set<String> result = new HashSet<>();
        if (n == 1) {
            result.add("()");
        } else {
            Set<String> current = findAll(n - 1);
            for (String s : current) {
                result.add(s + "()");
                result.add("(" + s + ")");
                result.add("()" + s);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Set<String> set = findAll(3);
        for (String s : set) {
            System.out.println(s);
        }
    }
}
