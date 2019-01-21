package me.arui.leetcode;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertBST108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);
        TreeNode parent = create(nums, 0, nums.length - 1);
        return parent;
    }

    private TreeNode create(int[] nums, int begin, int end) {
        if (begin <= end) {
            int center = (begin + end) / 2;
            TreeNode parent = new TreeNode(nums[center]);
            parent.left = create(nums, begin, center - 1);
            parent.right = create(nums, center + 1, end);
            return parent;
        }
        return null;
    }

    public static void main(String[] args) {
        ConvertBST108 test = new ConvertBST108();
        TreeUtil.bfsEcho(test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
    }

}