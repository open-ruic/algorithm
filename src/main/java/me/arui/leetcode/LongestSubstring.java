package me.arui.leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int longest = 0;
        int header = 0;
        for (int cur = 1; cur < s.length(); cur++) {
            char curChar = s.charAt(cur);
            int log = 1;
            for (int j = header; j < cur; j++) {
                if (curChar == s.charAt(j)) {
                    header = j + 1;
                    break;
                } else {
                    log++;
                }
            }
            longest = log > longest ? log : longest;
        }
        return longest;
    }

    public static void main(String[] args) {
        String test = "aw";
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(test));
    }
}
