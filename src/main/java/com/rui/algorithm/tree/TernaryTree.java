package com.rui.algorithm.tree;

import java.util.HashSet;
import java.util.Set;


/**
 * Ternary Search Tree
 */
public class TernaryTree {

    private Node root;

    private int maxLevel = 0;

    private int preLevel = 0;

    private int spaceLevel = 0;

    public TernaryTree() {}


    public void addWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Node tmp = null;
        for(int i = 0; i < chars.length; i++) {
            Node newNode = new Node(chars[i], (i < (chars.length - 1)) ? NodeType.UNCOMPLETED : NodeType.COMPLETED);
            if(root == null) {
                root = newNode;
                tmp = newNode;
            } else {
                tmp = addChild(tmp, newNode);
            }
        }
    }

    public Node addChild(Node parent, Node newNode) {
        if(parent == null) {
            return root.addBrotherChild(newNode);
        } else {
            return parent.addChild(newNode);
        }
    }

    public Set<String> findSimilar(String word) {
        Node tmp = findWord(word);
        if(tmp == null) return new HashSet<>();
        return dfs(word, tmp);
    }

    private Set<String> dfs(String prefix, Node tmp) {
        Set<String> result = new HashSet<>();
        dfs(prefix, tmp, result);
        return result;
    }

    private void dfs(String prefix, Node node, Set<String> result) {
        if(node.type == NodeType.COMPLETED) {
            result.add(prefix);
        }
        if(node.leftChild != null) {
            dfs(prefix + node.leftChild.word, node.leftChild, result);
        }
        if(node.rightChild != null) {
            dfs(prefix + node.rightChild.word, node.rightChild, result);
        }
        if(node.centerChild != null) {
            dfs(prefix + node.centerChild.word, node.centerChild, result);
        }
    }

    private Node findWord(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Node pre = root;
        Node tmp = root;
        for(char cha : chars) {
            pre = tmp;
            tmp = findWord(cha, tmp);
        }
        return pre;
    }

    private Node findWord(char word, Node node) {
        if(node == null) return null;
        if(node.word == word) {
            return node.centerChild;
        } else if(word < node.word) {
            return findWord(word, node.leftChild);
        } else {
            return findWord(word, node.rightChild);
        }
    }

    public void print() {
        char[][] result = new char[10][10];
        printNode(0, root, result);
        for(char[] re : result) {
            if(re != null) {
                for(char num : re) {
                    if(num != 0) {
                        System.out.print(" " + num + " ");
                    } else {
                        System.out.print("   ");
                    }
                }
                System.out.print("\n");
            }
        }
    }

    public void printNode(int level, Node node, char[][] result) {
        if(node == null) return;
        if(maxLevel < level) maxLevel = level;
        int nextLevel = level + 1;
        printNode(nextLevel, node.leftChild, result);
        if(level < preLevel) {
            spaceLevel++;
        }
        preLevel = level;
        result[level][spaceLevel] = node.word;
        printNode(nextLevel, node.centerChild, result);
        printNode(nextLevel, node.rightChild, result);
    }

    private class Node {

        private char word;

        private NodeType type;

        private Node leftChild, centerChild, rightChild;

        public Node(char word) {
            this.word = word;
            this.type = NodeType.UNCOMPLETED;
        }

        public Node(char word, NodeType type) {
            this.word = word;
            this.type = type;
        }

        public Node addChild(Node newNode) {
            if(this.centerChild == null) {
                this.centerChild = newNode;
                return this.centerChild;
            } else {
                if(centerChild.word == newNode.word) {
                    this.centerChild.type = newNode.type;
                    return this.centerChild;
                } else {
                    return this.centerChild.addBrotherChild(newNode);
                }
            }
        }

        private Node addBrotherChild(Node newNode) {
            if(newNode.word == this.word) {
                this.type = newNode.type;
                return this;
            } else if(newNode.word < this.word) {
                return addLeftChild(newNode);
            } else {
                return addRightChild(newNode);
            }
        }

        private Node addLeftChild(Node newNode) {
            if(this.leftChild == null) {
                this.leftChild = newNode;
                return this.leftChild;
            } else {
                if(leftChild.word == newNode.word) {
                    this.leftChild.type = newNode.type;
                    return this.leftChild;
                } else {
                    return this.leftChild.addBrotherChild(newNode);
                }
            }
        }

        private Node addRightChild(Node newNode) {
            if(this.rightChild == null) {
                this.rightChild = newNode;
                return this.rightChild;
            } else {
                if(rightChild.word == newNode.word) {
                    this.rightChild.type = newNode.type;
                    return this.rightChild;
                } else {
                    return this.rightChild.addRightChild(newNode);
                }
            }
        }
    }

    private enum NodeType {
        COMPLETED,
        UNCOMPLETED
    }
}
