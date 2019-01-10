package me.arui.leetcode;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrtx69 {

    public int mySqrt(int x) {
        double precision = 0.0001f;
        double tmp = x;
        double result = x / (double) 2;
        while (tmp - result > precision) {
            tmp = result;
            result = (tmp + x / tmp) / (double) 2;
        }
        return (int) Math.floor(result);

    }

    public static void test(Sqrtx69 test, int x) {
        System.out.println(test.mySqrt(x));
    }

    public static void main(String[] args) {
        Sqrtx69 test = new Sqrtx69();
        test.test(test, 2147395599);
        System.out.println(Math.sqrt(2147395599));
//        test.test(test, 6);
//        test.test(test, 3);
//        test.test(test, 1);
    }
}
