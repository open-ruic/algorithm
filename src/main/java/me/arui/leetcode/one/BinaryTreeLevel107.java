package me.arui.leetcode.one;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * <p>
 * BFS 广度优先
 */
public class BinaryTreeLevel107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> data = new ArrayList<>();
        if (root == null) return data;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                row.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            data.add(0, row);
        }
        return data;
    }

    public static void test(Integer[] treeData) {
        TreeNode parent = TreeUtil.create(0, treeData);
        BinaryTreeLevel107 test = new BinaryTreeLevel107();
        List<List<Integer>> result = test.levelOrderBottom(parent);
        for (List<Integer> data : result) {
            for (Integer i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        test(new Integer[]{3, 9, 20, null, null, 15, 7});
    }

}
