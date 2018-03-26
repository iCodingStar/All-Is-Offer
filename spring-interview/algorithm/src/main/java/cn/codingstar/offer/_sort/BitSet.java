package cn.codingstar.offer._sort;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: BitSet.java
 * @time: 18-3-26 下午7:24
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc: 通过位图实现去重与排序
 */
public class BitSet {

    // 通常一个int中有32位
    private static final int BITS_IN_WORD = 32;

    private static final int SHIFT = 5;

    // 5位掩码
    private static final int MASK = 0x1F;

    // 待去重数组中最大的数字
    private static final int N = 10000000;

    // 通过int类的数组来实现位图数组，相当于1个int类型的数字可以表示32个int类型的数字
    private static int[] bits = new int[N / BITS_IN_WORD + 1];


    public static void main(String[] args) {
        bitSort(new int[]{1, 100, 2, 10000, 9999, 4567, 78902});
    }

    public static void bitSort(int[] array) {
        for (int i = 0; i < N; i++)
            clr(i); // 位数组所有位清0
        for (int i = 0; i < array.length; i++)
            set(array[i]); // 阶段2
        for (int i = 0; i < N; i++)
            if (test(i))
                System.out.println(i);
    }

    /**
     * 置a[i>>SHIFT]的第(i & MASK)位为1，也就是位数组的第i位为1
     * 在数组bits中标识数字num出现了
     *
     * @param num
     */
    public static void set(int num) {
        // num >> SHIFT 代表为num寻找可以存储它的数组位置
        bits[num >> SHIFT] |= (1 << (num & MASK));
    }

    /**
     * 置a[i>>SHIFT]的第(i & MASK)位为0,也就是位数组的第i位为0
     *
     * @param num
     */
    public static void clr(int num) {
        bits[num >> SHIFT] &= ~(1 << (num & MASK));
    }

    /**
     * 测试数组的第num位是否为1，即测试数字num是否存在
     *
     * @param num
     * @return
     */
    public static boolean test(int num) {
        return (bits[num >> SHIFT] & (1 << (num & MASK))) == (1 << (num & MASK));
    }
}
