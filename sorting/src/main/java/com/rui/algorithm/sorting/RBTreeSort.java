package com.rui.algorithm.sorting;

import com.rui.algorithm.datastructure.tree.RBTree;

public class RBTreeSort {

    public void sort(int[] array) {
        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < array.length; i++) {
            rbTree.insert(array[i]);
        }
        rbTree.centerOrder();
    }

    public static void main(String[] args) {
        int a[] = {3,1,5,7,2,4,9,6};
        RBTreeSort rbTreeSort = new RBTreeSort();
        rbTreeSort.sort(a);
    }

}
