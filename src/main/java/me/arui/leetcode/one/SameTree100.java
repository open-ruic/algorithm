package me.arui.leetcode.one;

import java.util.Stack;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null && q != null) return false;

        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        TreeNode ptmp = p;
        TreeNode qtmp = q;

        while ((ptmp != null || qtmp != null) || !ps.isEmpty()) {
            while (ptmp != null || qtmp != null) {
                if (qtmp == null || ptmp == null || ptmp.val != qtmp.val) return false;
                ps.push(ptmp);
                ptmp = ptmp.left;

                qs.push(qtmp);
                qtmp = qtmp.left;
            }
            ptmp = ps.pop();
            ptmp = ptmp.right;

            qtmp = qs.pop();
            qtmp = qtmp.right;
        }
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
