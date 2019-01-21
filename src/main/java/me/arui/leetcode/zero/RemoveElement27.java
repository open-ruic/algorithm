package me.arui.leetcode.zero;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        int preIndex = 0;
        int existNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                existNum++;
            } else {
                if (i != preIndex) {
                    nums[preIndex] = nums[i];
                }
                preIndex = preIndex + 1;
            }
        }
        return nums.length - existNum;
    }

    public static void print(int length, int[] nums) {
        for (int i = 0; i < length; i++) {
            System.out.print(String.valueOf(nums[i]));
            if (i != length - 1) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void test(RemoveElement27 test, int[] nums, int val) {
        int len = test.removeElement(nums, val);
        print(len, nums);
    }

    public static void main(String[] args) {
        RemoveElement27 test = new RemoveElement27();
        test(test, new int[]{1, 1, 2}, 1);
        test(test, new int[]{0, 1}, 1);
        test(test, new int[]{1, 1}, 1);
        test(test, new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 2);
    }
}
