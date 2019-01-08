package me.arui.leetcode;

import java.util.List;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 */
public class MergeSortedList21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }  else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode create(int[] nums) {
        ListNode first = null;
        ListNode pre = null;
        for(int num : nums) {
            ListNode listNode = new ListNode(num);
            if(pre == null) {
                first = listNode;
            } else {
                pre.next = listNode;
            }
            pre = listNode;
        }
        return first;
    }

    public static void echoList(ListNode listNode) {
        System.out.print(listNode.val);
        while (listNode.next != null) {
            System.out.print("->");
            System.out.print(listNode.next.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        MergeSortedList21 test = new MergeSortedList21();
        echoList(test.mergeTwoLists(test.create(new int[]{1,2, 4}), test.create(new int[]{1,3, 4})));
    }

}
