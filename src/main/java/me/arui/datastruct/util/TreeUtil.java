package me.arui.datastruct.util;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    public static TreeNode create(int i, Integer[] treeData) {
        if (i > (treeData.length - 1)) return null;
        if (treeData[i] == null) return null;
        TreeNode node = new TreeNode(treeData[i]);
        node.left = create(2 * i + 1, treeData);
        node.right = create(2 * i + 2, treeData);
        return node;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void preOrderEcho(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.val);
        preOrderEcho(treeNode.left);
        preOrderEcho(treeNode.right);
    }

    public static void centerOrderEcho(TreeNode treeNode) {
        if (treeNode == null) return;
        centerOrderEcho(treeNode.left);
        System.out.println(treeNode.val);
        centerOrderEcho(treeNode.right);
    }

    public static void lastOrderEcho(TreeNode treeNode) {
        if (treeNode == null) return;
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
            if (cruNode.left != null) queue.offer(cruNode.left);
            if (cruNode.right != null) queue.offer(cruNode.right);
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
                System.out.printf("Level%d(%s,%s,%s)\n", level, node.val, isLeft ? 'L' : 'R', parent.val);
            }
        }
        if (node != null) {
            print(node.left, node, level + 1, true);
            print(node.right, node, level + 1, false);
        }
    }
}
