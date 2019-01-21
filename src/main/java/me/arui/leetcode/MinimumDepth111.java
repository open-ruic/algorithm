package me.arui.leetcode;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepth111 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int minDepth = Integer.MAX_VALUE;
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        if (root.left != null) {
            minDepth = Math.min(minDepth(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }
        return minDepth + 1;
    }

    public static void test(Integer[] treeData) {
        TreeNode parent = TreeUtil.create(0, treeData);
        MinimumDepth111 test = new MinimumDepth111();
        System.out.println(test.minDepth(parent));
    }

    public static void main(String[] args) {
        test(new Integer[]{1, 2});
    }

}
