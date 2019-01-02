package me.arui.leetcode;

/**
 *
 * 8. String to Integer
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public int myAtoi(String str) {
        char[] numbers = new char[10];
        str = str.trim();
        if(str.isEmpty()) return 0;

        int numberIndex = 0;
        char sign = '\0';
        for(int i =0; i < str.length(); i++) {
            if(i == 0 && sign == '\0' && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                sign = str.charAt(i);
                continue;
            } else if(i > 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                break;
            }

            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if(numberIndex > numbers.length -1) {
                    if(sign != '-')
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
                if(numberIndex == 0 && str.charAt(i) == '0') {
                    continue;
                }
                numbers[numberIndex] = str.charAt(i);
                numberIndex++;
            }
        }

        int ans = 0;
        for(int i=0; i<numberIndex; i++) {
            int pop = sign != '-' ? (numbers[i] -48) : -(numbers[i] -48);
            if(i == 9) {
                if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7)) return Integer.MAX_VALUE;
                if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop <- 8)) return Integer.MIN_VALUE;
            }
            ans = ans * 10 + pop;
        }
        return ans;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
//        System.out.println(stringToInteger.myAtoi("w 42") == 0);
//        System.out.println(stringToInteger.myAtoi("-42") == -42);
//        System.out.println(stringToInteger.myAtoi("+-42") == 0);
//        System.out.println(stringToInteger.myAtoi("0-1") == 0);
//        System.out.println(stringToInteger.myAtoi("1-1") == 1);
//        System.out.println(stringToInteger.myAtoi("000123") == 123);
//        System.out.println(stringToInteger.myAtoi("-2147483648") == -2147483648);
//        System.out.println(stringToInteger.myAtoi("2147483647") == 2147483647);
        System.out.println(stringToInteger.myAtoi("2147483648") == 2147483647);
        System.out.println(stringToInteger.myAtoi("2147483648"));

//        System.out.println(stringToInteger.myAtoi("200000000000") == 2147483647);
    }

}
