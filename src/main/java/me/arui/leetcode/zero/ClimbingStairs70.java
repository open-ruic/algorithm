package me.arui.leetcode.zero;

public class ClimbingStairs70 {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int a = 1, b = 2;
        int result = 0;
        while (n > 2) {
            result = a + b;
            a = b;
            b = result;
            n--;
        }
        return result;
    }

    public static void test(ClimbingStairs70 test, int x) {
        System.out.println(test.climbStairs(x));
    }

    public static void main(String[] args) {
        ClimbingStairs70 test = new ClimbingStairs70();
        test.test(test, 3);
        test.test(test, 4);
        test.test(test, 5);
        test.test(test, 6);
        test.test(test, 7);
    }

}
