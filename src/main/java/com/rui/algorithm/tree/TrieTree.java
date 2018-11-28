package com.rui.algorithm.tree;


import java.util.HashSet;
import java.util.Set;


/**
 * Trie Tree
 *
 *
 */
public class TrieTree {

    private int ALPHABET_SIZE = 26;

    private Node root;

    public TrieTree() {
        this.root = new Node(' ');
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node tmp = root;
        for(int i = 0; i < chars.length; i++)  {
            Node newNode = new Node(chars[i], (i < (chars.length - 1)) ? NodeType.UNCOMPLETED : NodeType.COMPLETED);
            tmp = tmp.addChild(newNode);
        }
    }

    public Node findWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Node tmp = root;
        for(int i = 0; i < chars.length; i++)  {
            tmp = tmp.findChild(chars[i]);
            if(tmp == null) {
                return null;
            }
        }
        return tmp;
    }

    public Set<String> findSimilar(String word) {
        Node tmp = findWord(word);
        if(tmp == null) return new HashSet<>();
        return dfs(word, tmp);
    }

    private Set<String> dfs(String prefix, Node node) {
        Set<String> result = new HashSet<>();
        dfs(prefix, node, result);
        return result;
    }

    private void dfs(String prefix, Node node, Set<String> result) {
        for (Node child: node.childs) {
            if(child == null) break;
            dfs(prefix + child.word, child, result);
            if (NodeType.COMPLETED == child.type){
                result.add(prefix + child.word);
            }
        }
    }

    private class Node {

        private char word;

        private NodeType type;

        private Node[] childs;

        public Node(char word) {
            this.word = word;
            this.type = NodeType.UNCOMPLETED;
            this.childs = new Node[ALPHABET_SIZE];
        }

        public Node(char word, NodeType type) {
            this.word = word;
            this.type = type;
            this.childs = new Node[ALPHABET_SIZE];
        }

        public Node addChild(Node node) {
            int index = 0;
            for(; index < ALPHABET_SIZE; index++) {
                Node child = childs[index];
                if(child == null)
                    break;
                if(child.word == node.word ) {
                    if(node.type == NodeType.COMPLETED) {
                        child.type = node.type;
                    }
                    return child;
                }
            }
            childs[index] = node;
            return node;
        }

        public Node findChild(char word) {
            for(Node child : childs) {
                if(child != null && child.word == word) {
                    return child;
                }
            }
            return null;
        }

        public NodeType getType() {
            return type;
        }

        public Node[] getChilds() {
            return childs;
        }
    }

    private enum NodeType {
        COMPLETED,
        UNCOMPLETED
    }
}
