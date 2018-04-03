package cn.codingstar.test.toutiao.random;

import java.text.MessageFormat;
import java.util.Random;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: RandomGenerator.java
 * @time: 18-4-3 下午4:06
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class RandomGenerator {

    private static Random random = new Random();

    /**
     * 生成随机数(0 ~ 4)
     *
     * @return
     */
    public static int random5() {
        return random.nextInt(5);
    }

    /**
     * 算法一：
     * 将第一次random5()生成的num1与第二次random()5() * 5 生成的数num2组合，可以得到
     * (0~24)25个数,具体的方法如下所示：
     * 0  5  10  15  20
     * 0  0  5  10  15  20
     * 1  1  6  11  16  21
     * 2  2  7  12  17  22
     * 3  3  8  13  18  23
     * 4  4  9  14  19  24
     * 要点：random5()生成的最大数字为4，随机生成(0~4),所以这里只能取5才能使生成的数字连续且不重复
     *
     * @return
     */
    public static int random7ByRandom5() {
        int value = -1;
        int result = -1;
        do {
            value = random5() + random5() * 5;
            if (value < 21) {
                result = value % 7;
            }
        } while (value >= 21);
        return result;
    }

    /**
     * 通过random5()生成random2()
     *
     * @return
     */
    public static int random2ByRandom5() {
        int result = -1;
        int value = -1;
        do {
            value = random5();
            if (value <= 3) { // 0,1,2,3
                result = value % 2;
            }
        } while (value > 3);
        return result;
    }

    /**
     * 通过将random5转化成随机生成(0,1)，再生成随机数(0,7)
     *
     * @return
     */
    public static int random7ByRandom2() {
        int result = -1;
        int value = -1;
        do {
            int num1 = random2ByRandom5() << 2;
            int num2 = random2ByRandom5() << 1;
            int num3 = random2ByRandom5();
            value = num1 + num2 + num3;
            if (value <= 6) {
                result = value;
            }
        } while (value > 6);
        return result;
    }

    public static void testRandom7ByRandom5() {
        int[] count = new int[7];
        int totalNum = 100000000;
        for (int i = 0; i < totalNum; i++) {
            count[random7ByRandom5()]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(MessageFormat.format("count[{0}] = {1}", i, count[i] * 1.0 / totalNum));
        }
    }

    public static void testRandom2ByRandom5() {
        int[] count = new int[2];
        int totalNum = 100000000;
        for (int i = 0; i < totalNum; i++) {
            count[random2ByRandom5()]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(MessageFormat.format("count[{0}] = {1}", i, count[i] * 1.0 / totalNum));
        }
    }

    public static void testRandom7ByRandom2() {
        int[] count = new int[7];
        int totalNum = 100000000;
        for (int i = 0; i < totalNum; i++) {
            count[random7ByRandom2()]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println(MessageFormat.format("count[{0}] = {1}", i, count[i] * 1.0 / totalNum));
        }
    }

    public static void main(String[] args) {

        //testRandom2ByRandom5();
        testRandom7ByRandom2();
    }

}
