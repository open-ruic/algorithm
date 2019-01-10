package me.arui.leetcode;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne66 {

    public int[] plusOne(int[] digits) {
        boolean isCarry = false;
        for(int i = digits.length - 1; i >=0; i--) {
            isCarry = false;
            int plusResult = digits[i] + 1;
            if(plusResult < 10) {
                digits[i] = plusResult;
                break;
            }
            digits[i] = 0;
            isCarry = true;
        }

        if(isCarry) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 1; i < result.length; i++) {
                result[i] = digits[i-1];
            }
            return result;
        }
        return digits;
    }

    public static void test(PlusOne66 test, int[] digits) {
        print(test.plusOne(digits));
    }

    static void print(int[] digits) {
        for (int num : digits) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PlusOne66 test = new PlusOne66();
        test.test(test, new int[] {9,8,7,6,5,4,3,2,1,0});
        test.test(test, new int[] {0});
        test.test(test, new int[] {9});
    }

}
