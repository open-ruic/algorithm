package me.arui.leetcode.nine;

/**
 * 949. Largest Time for Given Digits
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class LargestTime949 {

    public String largestTimeFromDigits(int[] A) {
        if(A.length != 4) return "";
        return tryFind(A, 23);
    }

    public String tryFind(int[] A, int num) {
        for(int i = num; i >= 0 ; i--) {
            int firstNum = i/10;
            int secondNum = i%10;
            Integer[] hourIndex = new Integer[2];
            for(int j = 0; j < 4; j++) {
                if(A[j] == firstNum && hourIndex[0] == null) {
                    hourIndex[0] = j;
                } else if (A[j] == secondNum && hourIndex[1] == null) {
                    hourIndex[1] = j;
                }
            }
            if(hourIndex[0] != null && hourIndex[1] != null) {
                Integer[] minIndex = new Integer[2];
                for(int j = 0; j < 4; j++) {
                    if(!contains(hourIndex, j)){
                        if(minIndex[0] == null) {
                            minIndex[0] = j;
                        } else {
                            minIndex[1] = j;
                        }
                    }
                }
                int num1 = A[minIndex[0]]*10 + A[minIndex[1]];
                int num2 = A[minIndex[1]]*10 + A[minIndex[0]];
                if(num1 < 60 && num2 < 60) {
                    if(num1 > num2) {
                        return String.format("%s%s:%s%s", firstNum, secondNum, A[minIndex[0]], A[minIndex[1]]);
                    } else {
                        return String.format("%s%s:%s%s", firstNum, secondNum, A[minIndex[1]], A[minIndex[0]]);
                    }
                } else if(num1 < 60) {
                    return String.format("%s%s:%s%s", firstNum, secondNum, A[minIndex[0]], A[minIndex[1]]);
                } else if(num2 < 60) {
                    return String.format("%s%s:%s%s", firstNum, secondNum, A[minIndex[1]], A[minIndex[0]]);
                }
            }
        }
        return "";
    }

    public boolean contains(Integer[] excludeIndex, int num) {
        for(Integer index : excludeIndex) {
            if(index == num) return true;
        }
        return false;
    }

    public static void test(int[] prices) {
        LargestTime949 test = new LargestTime949();
        String result = test.largestTimeFromDigits(prices);
        System.out.println("执行结果：" + result);
    }

    public static void main(String[] args) {
        test(new int[]{2,0,6,6});
        test(new int[]{1,2,3,4});
        test(new int[]{5,5,5,5});
    }

}
