package me.arui.datastruct.tree;

import org.junit.Test;

import java.util.Set;

public class TrieTreeTest {

    @Test
    public void testTrieTree() {
        TrieTree trieTree = new TrieTree();
        trieTree.addWord("similar");
        trieTree.addWord("simi");
        trieTree.addWord("trie");
        trieTree.addWord("ailment ");
        trieTree.addWord("LIMITED");

        Set<String> sets = trieTree.findSimilar("sim");
        for(String set : sets) {
            System.out.println(set);
        }
    }
}
