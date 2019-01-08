package me.arui.leetcode;


/**
 *
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x >= 0 && x < 10) return true;
        if(x == 10) return false;
        char[] chars = String.valueOf(x).toCharArray();
        for(int i = 0; i < chars.length/2+1; i++) {
            if(chars[i] != chars[chars.length - i -1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if(x < 0 || (x % 10 ==0 && x != 0)) return false;
        int ans = 0;
        while(x > ans) {
            ans = ans * 10 + x % 10;
            x = x /10;
        }
        return x == ans || x == ans/10;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome2(1));
    }

}
