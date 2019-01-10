package me.arui.datastruct.util;

import me.arui.datastruct.tree.RBTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    public static TreeNode create(int i, int[] treeData) {
        if (i > (treeData.length - 1)) return null;
        if(treeData[i] == -1) return null;
        TreeNode node = new TreeNode(treeData[i]);
        node.left = create(2 * i + 1, treeData);
        node.right = create(2 * i + 2, treeData);
        return node;
    }

    public static void firstOrderEcho(TreeNode treeNode) {
        if(treeNode == null) return;
        System.out.println(treeNode.val);
        firstOrderEcho(treeNode.left);
        firstOrderEcho(treeNode.right);
    }

    public static void centerOrderEcho(TreeNode treeNode) {
        if(treeNode == null) return;
        centerOrderEcho(treeNode.left);
        System.out.println(treeNode.val);
        centerOrderEcho(treeNode.right);
    }

    public static void lastOrderEcho(TreeNode treeNode) {
        if(treeNode == null) return;
        lastOrderEcho(treeNode.left);
        lastOrderEcho(treeNode.right);
        System.out.println(treeNode.val);
    }

    public static void bfsEcho(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode cruNode = queue.poll();
            System.out.println(cruNode.val);
            if(cruNode.left != null) queue.offer(cruNode.left);
            if(cruNode.right != null) queue.offer(cruNode.right);
        }
    }

    public static void print(TreeNode treeNode) {
        print(treeNode, null, 0, false);
    }

    private static void print(TreeNode node, TreeNode parent, int level, boolean isLeft) {
        if (level == 0) {
            System.out.printf("Root(%s)\n", node.val);
        } else {
            if (node == null) {
                System.out.printf("Level%d(%s,%s,%s)\n", level, "NIL", isLeft ? 'L' : 'R', 'B', parent.val);
            } else {
                System.out.printf("Level%d(%s,%s,%s)\n", level, node.val, isLeft ? 'L' : 'R',  parent.val);
            }
        }
        if (node != null) {
            print(node.left, node, level + 1, true);
            print(node.right, node, level + 1, false);
        }
    }
}
