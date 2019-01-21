package me.arui.leetcode.zero;


/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs[0].length() == 0) return "";
        char[] chars = strs[0].toCharArray();
        int commonIndex = chars.length;
        for (int i = 1; i < strs.length; i++) {
            commonIndex = strs[i].length() > commonIndex ? commonIndex : strs[i].length();
            for (int j = 0; j < commonIndex; j++) {
                char tmp = strs[i].charAt(j);
                if (tmp != chars[j]) {
                    commonIndex = j;
                    break;
                }
            }
            if (commonIndex == 0) {
                return "";
            }
        }
        return new String(chars, 0, commonIndex);
    }

    public static void main(String[] args) {
        LongestCommonPrefix14 test = new LongestCommonPrefix14();
        System.out.println(test.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(test.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(test.longestCommonPrefix(new String[]{"a", "b"}));
        System.out.println(test.longestCommonPrefix(new String[]{"aa", "a"}));
        System.out.println(test.longestCommonPrefix(new String[]{"aa", "aaaaa"}));
    }
}
