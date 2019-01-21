package me.arui.leetcode.one;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepth104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMaxLevel = maxDepth(root.left);
        int rightMaxLevel = maxDepth(root.right);
        return Math.max(leftMaxLevel, rightMaxLevel) + 1;
    }

    public static void test(Integer[] treeData) {
        TreeNode parent = TreeUtil.create(0, treeData);
        MaxDepth104 test = new MaxDepth104();
        System.out.println(test.maxDepth(parent));
    }

    public static void main(String[] args) {
        test(new Integer[]{1, 2, 2, 3, 4, 4, 3});
    }

}
