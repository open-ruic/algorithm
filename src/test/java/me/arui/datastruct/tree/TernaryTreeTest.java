package me.arui.datastruct.tree;

import org.junit.Test;

import java.util.Set;

public class TernaryTreeTest {

    @Test
    public void testTernaryTree() {
        TernaryTree ternaryTree = new TernaryTree();
        ternaryTree.addWord("similar");
        ternaryTree.addWord("simi");
        ternaryTree.addWord("trie");
        ternaryTree.addWord("ailment");
        ternaryTree.addWord("LIMITED");
        ternaryTree.print();
        Set<String> sets = ternaryTree.findSimilar("sim");
        for(String set : sets) {
            System.out.println(set);
        }
    }
}
