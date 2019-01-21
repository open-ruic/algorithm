package me.arui.leetcode.nine;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 965. Univalued Binary Tree
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class UnivaluedBinaryTree965 {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return false;
        int value = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node.val != value) return false;
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }

    public static void test(Integer[] treeData) {
        TreeNode parent = TreeUtil.create(0, treeData);
        UnivaluedBinaryTree965 test = new UnivaluedBinaryTree965();
        boolean result = test.isUnivalTree(parent);
        System.out.println(result);
    }

    public static void main(String[] args) {
        test(new Integer[]{3, 3, 3});
    }

}
