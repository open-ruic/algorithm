package me.arui.leetcode.zero;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthofLastWord58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }

    public static void test(LengthofLastWord58 test, String s) {
        System.out.println(test.lengthOfLastWord(s));
    }

    public static void main(String[] args) {
        LengthofLastWord58 test = new LengthofLastWord58();
        test.test(test, "Hello World");
    }
}
