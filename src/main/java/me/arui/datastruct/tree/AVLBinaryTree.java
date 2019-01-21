package me.arui.datastruct.tree;


import me.arui.datastruct.util.TreeNode;

/**
 * AVL平衡二叉树
 * <p>
 * 特点： 左右子树高度差不超过1，插入和删除时，通过旋转达到平衡
 */
public class AVLBinaryTree {

    private TreeNode root;

    public AVLBinaryTree() {
    }

    public void insert(int t) {
        root = insert(root, t);
    }

    private TreeNode insert(TreeNode node, int t) {
        if (node == null) return new TreeNode(t);

        if (t > node.val) {
            node.right = insert(node.right, t);
        } else {
            node.left = insert(node.left, t);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return fixAfterInsertion(node, t);
    }

    private TreeNode fixAfterInsertion(TreeNode node, int t) {
        int balance = getBalance(node);

        //Left Left Case
        if (balance > 1 && t < node.left.val) {
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && t > node.right.val) {
            return leftRotate(node);
        }
        // Left Right Case
        if (balance > 1 && t > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && t < node.left.val) {
            node.right = rightRotate(node.left);
            return leftRotate(node);
        }

        return node;
    }

    public void delete(int t) {
        root = delete(root, t);
    }

    private TreeNode delete(TreeNode node, int t) {
        if (node == null) return null;

        if (t > node.val) {
            node.right = delete(node.right, t);
        } else if (t < node.val) {
            node.left = delete(node.left, t);
        } else {
            if ((node.left == null) || (node.right == null)) { // one child or two child
                TreeNode temp = node.left != null ? node.left : node.right;
                node = temp;
            } else {
                TreeNode temp = minValueNode(node.right);
                node.val = temp.val;
                node.right = delete(node.right, temp.val);
            }
        }

        if (node == null) return null;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return fixAfterDeletion(node, t);
    }

    private TreeNode fixAfterDeletion(TreeNode node, int t) {
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private TreeNode minValueNode(TreeNode node) {
        TreeNode minNode = node;
        while (minNode.left != null) {
            minNode = node.left;
        }
        return minNode;
    }

    int height(TreeNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalance(TreeNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public TreeNode getRoot() {
        return root;
    }

}
