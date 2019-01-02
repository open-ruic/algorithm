package me.arui.leetcode;

import java.util.Date;

/**
 *
 * leetcode 154. Find Minimum in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 */
public class FindMinimum {

    public int findMin(int[] nums) {
        int min = nums[0];
        for (int number : nums) {
            if(number <  min) {
                min = number;
                break;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 3};
//        int[] arr = {6, 7, 8, 0, 1, 1, 2, 2, 3};
//        int[] arr = {2,2,2,0,1};
        FindMinimum findMinimum = new FindMinimum();
        Date beginDate = new Date();
        System.out.println(findMinimum.findMin(arr));
        Date endDate = new Date();
        System.out.println("Time : "  + (endDate.getTime() - beginDate.getTime()));
    }
}
