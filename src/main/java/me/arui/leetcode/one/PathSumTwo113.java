package me.arui.leetcode.one;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumTwo113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        Stack<List<Integer>> pathStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.add(root);
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        pathStack.add(path);
        sumStack.add(sum - root.val);
        int curSum;
        List<Integer> curPath;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            curSum = sumStack.pop();
            curPath = pathStack.pop();
            if (curSum == 0 && node.right == null && node.left == null) {
                result.add(curPath);
            }

            if (node.right != null) {
                stack.add(node.right);
                List<Integer> nextPath = new ArrayList<>(curPath);
                nextPath.add(node.right.val);
                pathStack.add(nextPath);
                sumStack.add(curSum - node.right.val);
            }

            if (node.left != null) {
                stack.add(node.left);
                List<Integer> nextPath = new ArrayList<>(curPath);
                nextPath.add(node.left.val);
                pathStack.add(nextPath);
                sumStack.add(curSum - node.left.val);
            }
        }
        return result;
    }

    public static void test(String treeData, int sum) {
        TreeNode parent = TreeUtil.stringToTreeNode(treeData);
        PathSumTwo113 test = new PathSumTwo113();
        List<List<Integer>> result = test.pathSum(parent, sum);
        for (List<Integer> row : result) {
            for (Integer data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test("[5,4,8,11,null,13,4,7,2,null,null,5,1]", 22);
        test("[5, 4, 8, 11, null, 9, 4, 7, 1, null, null, null, null, null, 1]", 22);
        test("[-2, null, 3]", -2);
        test("[1,2]", 1);
    }
}
