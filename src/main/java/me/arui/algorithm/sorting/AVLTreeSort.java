package me.arui.algorithm.sorting;

import me.arui.datastruct.tree.AVLBinaryTree;
import me.arui.datastruct.util.TreeUtil;

public class AVLTreeSort {

    public void sort(int[] array) {
        AVLBinaryTree avlTree = new AVLBinaryTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.insert(array[i]);
        }
        TreeUtil.centerOrderEcho(avlTree.getRoot());
    }

    public static void main(String[] args) {
        int a[] = {3, 1, 5, 7, 2, 4, 9, 6};
        AVLTreeSort avlTreeSort = new AVLTreeSort();
        avlTreeSort.sort(a);
    }
}
