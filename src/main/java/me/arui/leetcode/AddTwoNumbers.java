package me.arui.leetcode;

/**
 * leetcode 2. Add Two Numbers
 * <p>
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        boolean carry = false;
        ListNode nextCur1 = l1;
        ListNode nextCur2 = l2;
        ListNode cur = null;
        while (nextCur1 != null || nextCur2 != null) {
            int num1 = nextCur1 != null ? nextCur1.val : 0;
            int num2 = nextCur2 != null ? nextCur2.val : 0;
            int sum = carry ? num1 + num2 + 1 : num1 + num2;

            if (sum < 10) {
                carry = false;
            } else {
                carry = true;
                sum = sum - 10;
            }

            if (result == null) {
                result = new ListNode(sum);
                cur = result;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            nextCur1 = nextCur1 != null ? nextCur1.next : null;
            nextCur2 = nextCur2 != null ? nextCur2.next : null;
        }
        if (carry) {
            cur.next = new ListNode(1);
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(5);

        ListNode two = new ListNode(5);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(one, two);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

}
