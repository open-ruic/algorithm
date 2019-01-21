package me.arui.leetcode.one;

import me.arui.datastruct.util.TreeNode;
import me.arui.datastruct.util.TreeUtil;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree101 {

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    public static void test(Integer[] treeData) {
        TreeNode parent = TreeUtil.create(0, treeData);
        SymmetricTree101 test = new SymmetricTree101();
        test.isSymmetric(parent);
    }

    public static void main(String[] args) {
        test(new Integer[]{1, 2, 2, 3, 4, 4, 3});
    }
}
