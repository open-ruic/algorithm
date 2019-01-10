package me.arui.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int preIndex = 0;
        int dupNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[preIndex]) {
                if (i != preIndex + 1) {
                    nums[preIndex + 1] = nums[i];
                }
                preIndex = preIndex + 1;
            } else {
                dupNum++;
            }
        }
        return nums.length - dupNum;
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

    public static void test(RemoveDuplicates26 test, int[] nums) {
        int len = test.removeDuplicates(nums);
        print(len, nums);
    }


    public static void main(String[] args) {
        RemoveDuplicates26 test = new RemoveDuplicates26();
        test(test, new int[]{1, 1, 2});
        test(test, new int[]{0, 1});
        test(test, new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

}
