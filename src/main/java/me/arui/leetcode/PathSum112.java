package me.arui.leetcode;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

import java.util.Stack;

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.add(root);
        sumStack.add(sum - root.val);
        int curSum;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            curSum = sumStack.pop();

            if(curSum == 0 && node.right == null && node.left == null) return true;

            if(node.right != null) {
                stack.add(node.right);
                sumStack.add(curSum - node.right.val);
            }

            if(node.left != null) {
                stack.add(node.left);
                sumStack.add(curSum - node.left.val);
            }
        }
        return false;
    }

    public static void test(String treeData, int sum) {
        TreeNode parent = TreeUtil.stringToTreeNode(treeData);
        PathSum112 test = new PathSum112();
        System.out.println(test.hasPathSum(parent, sum));
    }

    public static void main(String[] args) {
        test("[5, 4, 8, 11, null, 9, 4, 7, 1, null, null, null, null, null, 1]", 22);
        test("[-2, null, 3]", -2);
        test("[1,2]", 1);
    }
}
