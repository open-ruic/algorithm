package me.arui.leetcode;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ans = ans * 10 + pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-100));
    }

}
