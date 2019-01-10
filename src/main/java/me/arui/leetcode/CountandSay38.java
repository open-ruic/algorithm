package me.arui.leetcode;

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 */
public class CountandSay38 {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String lastSay = "1";
        int i = 2;
        while (i <= n) {
            lastSay = say(lastSay);
            i++;
        }
        return lastSay;
    }

    public String say(String lastSay) {
        StringBuffer say = new StringBuffer();
        int sameNum = 0;
        for (int i = 0; i < lastSay.length(); i++) {
            sameNum++;
            if (i == lastSay.length() - 1 || lastSay.charAt(i) != lastSay.charAt(i + 1)) {
                say.append(sameNum).append(String.valueOf(lastSay.charAt(i)));
                sameNum = 0;
            }
        }
        return say.toString();
    }

    public static void test(CountandSay38 test, int num) {
        System.out.println(test.countAndSay(num));
    }

    public static void main(String[] args) {
        CountandSay38 test = new CountandSay38();
        test(test, 1);
        test(test, 2);
        test(test, 3);
        test(test, 4);
        test(test, 5);
        test(test, 6);
        test(test, 7);
        test(test, 30);
    }
}
