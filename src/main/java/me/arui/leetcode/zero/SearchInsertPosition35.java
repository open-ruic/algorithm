package me.arui.leetcode.zero;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[0] >= target) return 0;
        if (nums[nums.length - 1] == target) return nums.length - 1;
        if (nums[nums.length - 1] < target) return nums.length;
        return searchInsert(nums, 0, nums.length - 1, target);
    }

    public int searchInsert(int[] nums, int start, int end, int target) {
        if (end == start || (end - start) == 1) {
            return start + 1;
        }
        int index = Math.floorDiv(end + start, 2);
        if (nums[index] >= target) {
            return searchInsert(nums, start, index, target);
        } else {
            return searchInsert(nums, index, end, target);
        }
    }

    public static void test(SearchInsertPosition35 test, int[] nums, int target) {
        System.out.println(test.searchInsert(nums, target));
    }

    public static void main(String[] args) {
        SearchInsertPosition35 test = new SearchInsertPosition35();
        test(test, new int[]{1, 3, 5, 6}, 3);
        test(test, new int[]{1, 3, 5, 6}, 2);
        test(test, new int[]{1, 3, 5, 6}, 5);
        test(test, new int[]{1, 3, 5, 6}, 7);
        test(test, new int[]{1, 3, 5, 6}, 1);
        test(test, new int[]{1, 3, 5, 6}, 0);
    }

}
