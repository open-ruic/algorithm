package me.arui.leetcode;


import java.util.HashMap;
import java.util.Map;


/**
 * leetcode 1. Two Sum
 * <p>
 * https://leetcode.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No solution available");
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 0};
        int target = 0;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(arr, target);
        System.out.println(String.format("%s, %s", result[0], result[1]));
    }
}
