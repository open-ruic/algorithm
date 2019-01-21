package me.arui.leetcode;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring5 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            int tmp = 0;
            int length = 0;
            while (i - tmp > 0 && i + tmp < s.length()) {
                if (s.charAt(i - tmp) == s.charAt(i - tmp)) {
                    tmp++;
                    length++;
                }
            }
        }
        return "";
    }

}
