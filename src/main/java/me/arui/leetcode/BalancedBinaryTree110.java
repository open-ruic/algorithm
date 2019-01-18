package me.arui.leetcode;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(isBalanced(root.right) && isBalanced(root.left)) {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return Math.abs((leftHeight - rightHeight)) <= 1;
        }
        return false;
    }

    private int getHeight(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max (getHeight(node.left), getHeight(node.right));
    }

    public static void test(Integer[] nums) {
        BalancedBinaryTree110 test = new BalancedBinaryTree110();
        TreeNode node = TreeUtil.create(0, nums);
        System.out.println(test.isBalanced(node));
    }

    public static void main(String[] args) {
        test(new Integer[]{3,9,20,null,null,15,7});
    }

}
