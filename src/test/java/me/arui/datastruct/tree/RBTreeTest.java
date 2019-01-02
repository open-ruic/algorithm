package me.arui.datastruct.tree;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {

    private RBTree<Integer> rbTree;

    @Before
    public void init() {
        rbTree = new RBTree<>();
        rbTree.insert(16);
        rbTree.insert(14);
        rbTree.insert(11);
        rbTree.insert(15);
        rbTree.insert(20);
        rbTree.insert(25);
        rbTree.insert(7);
        rbTree.insert(13);
    }

    @Test
    public void testRBTree() {
        rbTree.print();
    }

    @Test
    public void testPreOrder() {
        rbTree.preOrder();
        rbTree.preOrderLoop();
    }

    @Test
    public void testCenterOrder() {
        rbTree.centerOrder();
        rbTree.centerOrderLoop();
    }

    @Test
    public void testlastOrder() {
        rbTree.lastOrder();
        rbTree.lastOrderLoop();
    }
}
