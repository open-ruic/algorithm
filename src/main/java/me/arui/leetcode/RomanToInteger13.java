package me.arui.leetcode;


/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger13 {

    public int romanToInt(String s) {
        int[] numbers = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int number = 0;
            switch (s.charAt(i)) {
                case 'I':
                    number = 1;
                    break;
                case 'V':
                    number = 5;
                    break;
                case 'X':
                    number = 10;
                    break;
                case 'L':
                    number = 50;
                    break;
                case 'C':
                    number = 100;
                    break;
                case 'D':
                    number = 500;
                    break;
                case 'M':
                    number = 1000;
                    break;
            }
            if (i > 0 && number > numbers[i - 1]) {
                numbers[i - 1] = numbers[i - 1] * -1;
                numbers[i] = number;
            } else {
                numbers[i] = number;
            }
        }
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    public static void main(String[] args) {
        RomanToInteger13 romanToInteger = new RomanToInteger13();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

}
