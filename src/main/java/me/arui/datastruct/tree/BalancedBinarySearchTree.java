package me.arui.datastruct.tree;


import me.arui.datastruct.util.TreeNode;

/**
 * 平衡二叉树
 */
public class BalancedBinarySearchTree {

    private TreeNode root;

    public BalancedBinarySearchTree() {}

    /**
     * TODO 插入平衡
     * @param t
     */
    public void insert(int t) {
        if(root == null) {
            root = new TreeNode(t);
            return;
        }
        insert(root, t);
    }

    private void insert(TreeNode parent, int t) {
        if(parent.val < t) {
            if(parent.right != null) {
                insert(parent.right, t);
            } else {
                parent.right = new TreeNode(t);
                return;
            }
        } else {
            if(parent.left != null) {
                insert(parent.left, t);
            } else {
                parent.left = new TreeNode(t);
                return;
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

}
