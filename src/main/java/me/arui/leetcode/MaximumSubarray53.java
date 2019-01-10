package me.arui.leetcode;

/**
 * 53. Maximum Subarray
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {
        int tempMax = nums[0];
        int maxTotal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempMax = Math.max(nums[i], nums[i] + tempMax);
            if (tempMax > maxTotal) {
                maxTotal = tempMax;
            }
        }
        return maxTotal;
    }

    public static void test(MaximumSubarray53 test, int[] nums) {
        System.out.println(test.maxSubArray(nums));
    }

    public static void main(String[] args) {
        MaximumSubarray53 test = new MaximumSubarray53();
        test(test, new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
