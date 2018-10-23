package com.rui.algorithm.datastructure.tree;

public class RBNode<T extends Comparable> implements Comparable<RBNode<T>> {

    private RBNode parent;

    private RBNode leftChild;

    private RBNode rightChild;

    private Boolean isRed;

    private T value;

    public RBNode(T value) {
        this.value = value;
        this.isRed = true;
    }

    public RBNode(Boolean isRed, T value) {
        this.isRed = isRed;
        this.value = value;
    }

    @Override
    public int compareTo(RBNode o) {
        return value.compareTo(o.value);
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public RBNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RBNode leftChild) {
        this.leftChild = leftChild;
    }

    public RBNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RBNode rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T getRightChild) {
        this.value = value;
    }

    public Boolean getRed() {
        return isRed;
    }

    public void setRed(Boolean red) {
        isRed = red;
    }
}
