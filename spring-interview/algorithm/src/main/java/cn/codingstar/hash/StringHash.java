package cn.codingstar.hash;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: StringHash.java
 * @time: 18-3-7 下午10:19
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource: http://www.cnblogs.com/xrq730/p/5186728.html
 * @desc: String哈希方法测试
 */
public class StringHash {

    public static void main(String[] args) {
        System.out.println("192.168.0.0:1111".hashCode());
        System.out.println("192.168.0.1:1111".hashCode());
        System.out.println("192.168.0.2:1111".hashCode());
        System.out.println("192.168.0.3:1111".hashCode());
        System.out.println("192.168.0.4:1111".hashCode());
        System.out.println("192.168.1.0:1111".hashCode());
    }
}
