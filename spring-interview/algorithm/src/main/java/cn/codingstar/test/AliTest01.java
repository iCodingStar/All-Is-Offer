package cn.codingstar.test;

/**
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @site: http://www.codingstar.cn
 * @file: AliTest01.java
 * @time: 18-3-20 下午7:07
 * @software: IntelliJ IDEA
 * @version: 1.0
 * @resource:
 * @desc:
 */
public class AliTest01 {

    private static int result = Integer.MAX_VALUE;


    public static int merge(int[] a, int[] b) {
        int[] R = new int[a.length + b.length];
        mergeCore(R, 0, a, 0, b, 0);
        return 0;
    }

    public static void mergeCore(int[] R, int startR, int[] A, int startA, int[] B, int startB) {
        if (startR == R.length) {
            int temp = 0;
            for (int i = 0; i < R.length; i += 2) {
                temp += R[i] * R[i + 1];
                System.out.print(R[i] + " " + R[i + 1] + " ");
            }
            System.out.print(" > " + result);
            System.out.println();
            result = Math.min(result, temp);
            return;
        }
        if (startA < A.length) {
            R[startR] = A[startA];
            mergeCore(R, startR + 1, A, startA + 1, B, startB);
        }
        if (startB < B.length) {
            R[startR] = B[startB];
            mergeCore(R, startR + 1, A, startA, B, startB + 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5};
        int[] b = {6};
        merge(a, b);
        System.out.println(result);
    }

}
