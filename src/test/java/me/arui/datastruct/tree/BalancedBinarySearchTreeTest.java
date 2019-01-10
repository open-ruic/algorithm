package me.arui.datastruct.tree;

import me.arui.datastruct.util.TreeUtil;
import org.junit.Before;
import org.junit.Test;

public class BalancedBinarySearchTreeTest {

    private BalancedBinarySearchTree bstTree;

    @Before
    public void init() {
        bstTree = new BalancedBinarySearchTree();
        bstTree.insert(16);
        bstTree.insert(14);
        bstTree.insert(11);
        bstTree.insert(15);
        bstTree.insert(20);
        bstTree.insert(25);
        bstTree.insert(7);
        bstTree.insert(13);
    }

    @Test
    public void test() {
        TreeUtil.centerOrderEcho(bstTree.getRoot());
    }

}
