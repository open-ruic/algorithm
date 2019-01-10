package me.arui.leetcode;

import java.util.Stack;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char now = chars[i];
            switch (now) {
                case '{':
                case '[':
                case '(':
                    stack.push(now);
                    break;
                case '}':
                case ')':
                case ']':
                    if (stack.isEmpty()) return false;
                    Character pop = stack.pop();
                    if (now == '}' && !pop.equals('{')) {
                        return false;
                    } else if (now == ')' && !pop.equals('(')) {
                        return false;
                    } else if (now == ']' && !pop.equals('[')) {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

    public static void main(String[] args) {
        ValidParentheses20 test = new ValidParentheses20();
        System.out.println(test.isValid("()"));
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("(]"));
        System.out.println(test.isValid("([)]"));
        System.out.println(test.isValid("{[]}"));
        System.out.println(test.isValid("{"));
        System.out.println(test.isValid("]"));
    }

}
