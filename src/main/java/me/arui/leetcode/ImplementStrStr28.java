package me.arui.leetcode;


/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr28 {

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                if(haystack.length() - i < needle.length()) return -1;
                boolean has = true;
                for(int j =1; j< needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        has = false;
                        break;
                    }
                }
                if(has) return i;
            }
        }
        return -1;
    }

    public static void test(ImplementStrStr28 test, String haystack, String needle) {
        System.out.println(test.strStr(haystack, needle));
    }

    public static void main(String[] args) {
        ImplementStrStr28 test = new ImplementStrStr28();
        test(test, "hello", "ll");
        test(test, "aaaaa", "bba");
    }

}
