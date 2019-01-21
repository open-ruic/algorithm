package me.arui.leetcode.nine;

import java.util.Arrays;

public class LargestPerimeterTriangle976 {

    public int largestPerimeter(int[] A) {
        if(A.length < 3) return 0;
        Arrays.sort(A);
        for(int i = A.length -3; i >= 0; i--) {
            if(A[i] + A[i+1] > A[i+2]) {
                return A[i] + A[i+1] + A[i+2];
            }
        }
        return 0;
    }

    public static void test(int[] prices) {
        LargestPerimeterTriangle976 test = new LargestPerimeterTriangle976();
        int result = test.largestPerimeter(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{2,1,2});
    }

}
