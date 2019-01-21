package me.arui.leetcode.nine;

import java.util.BitSet;

/**
 * 961. N-Repeated Element in Size 2N Array
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class RepeatedElement961 {

    public int repeatedNTimes(int[] A) {
        if(A.length < 4) return 0;
        BitSet bitSet  = new BitSet(1024);
        for(int i = 0; i < A.length; i++) {
            if(bitSet.get(A[i])) return A[i];
            bitSet.set(A[i]);
        }
        return 0;
    }

    public static void test(int[] prices) {
        RepeatedElement961 test = new RepeatedElement961();
        int result = test.repeatedNTimes(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{5,1,5,2,5,3,5,4});
    }

}
