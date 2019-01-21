package me.arui.leetcode.nine;

import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresSortedArray977 {

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int square = A[i] * A[i];
            A[i] = square;
        }
        Arrays.sort(A);
        return A;
    }

    public static void test(int[] prices) {
        SquaresSortedArray977 test = new SquaresSortedArray977();
        int[] result = test.sortedSquares(prices);
        System.out.println("执行结果：");
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new int[]{-4,-1,0,3,10});
    }
}
