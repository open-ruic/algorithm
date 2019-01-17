package me.arui.datastruct.tree;

import me.arui.datastruct.util.TreeUtil;
import org.junit.Before;
import org.junit.Test;

public class AVLBinaryTreeTest {

    private AVLBinaryTree bstTree;

    @Before
    public void init() {
        bstTree = new AVLBinaryTree();
        bstTree.insert(1);
        bstTree.insert(2);
        bstTree.insert(3);
        bstTree.insert(4);
        bstTree.insert(5);
        bstTree.insert(6);
        bstTree.insert(7);
    }

    @Test
    public void testInsert() {
        bstTree.insert(10);
        TreeUtil.centerOrderEcho(bstTree.getRoot());
    }

    @Test
    public void testDelete() {
        bstTree.delete(4);
        TreeUtil.centerOrderEcho(bstTree.getRoot());
    }

}
