package me.arui.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromList83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            if(pre.val == tmp.val) {
                pre.next = tmp.next;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head;
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
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromList83 test = new RemoveDuplicatesFromList83();
        echoList(test.deleteDuplicates(test.create(new int[]{1,2,2,4})));
        echoList(test.deleteDuplicates(test.create(new int[]{1,1,1})));
    }

}
