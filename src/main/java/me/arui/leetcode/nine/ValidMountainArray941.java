package me.arui.leetcode.nine;

public class ValidMountainArray941 {

    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        if(A[1] < A[0]) return false;

        boolean top = false;
        for(int i = 2; i < A.length; i++) {
            if(top && A[i] >= A[i-1]) return false;
            if(!top && A[i] < A[i-1]) {
                top = true;
            }
        }
        return top;
    }

    public static void test(int[] prices) {
        ValidMountainArray941 test = new ValidMountainArray941();
        boolean result = test.validMountainArray(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{1,3,2});
        test(new int[]{14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3});
        test(new int[]{0,3,2,1});
    }

}
