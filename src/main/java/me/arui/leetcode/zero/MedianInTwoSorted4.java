package me.arui.leetcode.zero;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianInTwoSorted4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        return find(nums1, nums2);
    }

    private double find(int[] nums1, int[] nums2) {
        double result = 0f;
        int total = nums1.length + nums2.length;
        boolean hasTwoMid = total % 2 == 0 ? true : false;
        int medianIndex = (int) Math.ceil(total / (float) 2);

        int count = 0;
        int i = 0;
        int j = 0;
        while (count < medianIndex) {
            int num1 = getNumber(nums1, i);
            int num2 = getNumber(nums2, j);
            if (num1 < num2) {
                result = num1;
                i++;
            } else {
                result = num2;
                j++;
            }
            count++;
        }
        if (hasTwoMid) {
            int num1 = getNumber(nums1, i);
            int num2 = getNumber(nums2, j);
            if (num1 < num2) {
                result += (double) num1;
            } else {
                result += (double) num2;
            }
        }
        return hasTwoMid ? result / (double) 2 : result;
    }

    int getNumber(int[] nums, int n) {
        return n < nums.length ? nums[n] : Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3}; // 4, 1
        int[] nums2 = {2}; // 11, 4
//        1, 2, 2, 3, 4, 4, 5, 8, 11, 12, 15, 16, 17, 18, 19  // 15 , 7,  8
//        int[] nums1 = {1, 100, 102}; 1
//        int[] nums2 = {2};  0    2
        MedianInTwoSorted4 medianInTwoSorted = new MedianInTwoSorted4();
        System.out.println(medianInTwoSorted.findMedianSortedArrays(nums1, nums2));
    }

}