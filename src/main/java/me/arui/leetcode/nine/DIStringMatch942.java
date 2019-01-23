package me.arui.leetcode.nine;

/**
 * 942. DI String Match
 * https://leetcode.com/problems/di-string-match/
 */
public class DIStringMatch942 {

    public int[] diStringMatch(String S) {
        if(S.length() == 0) return new int[0];
        int length =S.length();
        int[] result = new int[length+1];
        int d = S.length();
        int i = 0;
        for(int j = 0; j < length; j++) {
            if(S.charAt(j) == 'I') {
                result[j] = i;
                i++;
            } else {
                result[j] = d;
                d--;
            }
        }
        if(S.charAt(length-1) == 'I') {
            result[length] = result[length-1] + 1;
        } else {
            result[length] = result[length-1] - 1;
        }
        return result;
    }

    public static void test(String S) {
        DIStringMatch942 test = new DIStringMatch942();
        int[] result = test.diStringMatch(S);
        System.out.println("执行结果：");
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        test("");
        test("IDID");
        test("DDD");
        test("DDI");
    }
}
