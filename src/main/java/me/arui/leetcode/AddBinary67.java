package me.arui.leetcode;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary67 {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) return addBinary(b, a);
        StringBuilder strBuilder = new StringBuilder(a);
        boolean carry = false;
        for (int i = 0; i < a.length(); i++) {
            int sum = a.charAt(a.length() - i - 1) - 48;
            if (i < b.length()) {
                sum += b.charAt(b.length() - i - 1) - 48;
            }
            if (carry) {
                sum++;
            }
            if (sum < 2) {
                carry = false;
                strBuilder.setCharAt(a.length() - i - 1, (char) (sum + 48));
            } else if (sum >= 2) {
                carry = true;
                strBuilder.setCharAt(a.length() - i - 1, (char) (sum - 2 + 48));
            }
            if (i == a.length() - 1 && carry) {
                strBuilder.insert(0, '1');
            }
        }
        return strBuilder.toString();
    }

    public static void test(AddBinary67 test, String a, String b) {
        System.out.println(test.addBinary(a, b));
    }

    public static void main(String[] args) {
        AddBinary67 test = new AddBinary67();
        test.test(test, "11", "1");
        test.test(test, "1010", "1011");
    }

}
