package me.arui.leetcode;

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void test(int[] treeData) {
        TreeNode parent = create(0, treeData);
        SymmetricTree101 test = new SymmetricTree101();
        test.isSymmetric(parent);
    }

    public static TreeNode create(int i, int[] treeData) {
        if(i > (treeData.length -1)) return null;
        TreeNode node  = new TreeNode(treeData[i]);
        node.left = create(2 * i + 1, treeData);
        node.right = create(2 * i + 2, treeData);
        return node;
    }

    public static void main(String[] args) {
        test(new int[] {1, 2, 2, 3, 4, 4, 3});
    }
}
