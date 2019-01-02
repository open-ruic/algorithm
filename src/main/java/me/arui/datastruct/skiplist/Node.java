package me.arui.datastruct.skiplist;


public class Node<T> implements Cloneable {

    private int key;

    private T value;

    private int level;

    private Node<T> up, down, left, right;

    public Node(int key, T value, int listLevel) {
        this.key = key;
        this.value = value;
        this.level = listLevel;
        if(listLevel > 1) {
            this.setDown(new Node<T>(key, value, --listLevel));
        }
    }

    public boolean equals(Object o) {
        if (this==o) {
            return true;
        }
        if (o==null) {
            return false;
        }
        if (!(o instanceof Node<?>)) {
            return false;
        }

        Node<T> ent = (Node<T>)  o;
        return (ent.getKey() == key) && (ent.getValue() == value);
    }

    @Override
    public String toString() {
        return key + ":" + value;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getUp() {
        return up;
    }

    public void setUp(Node<T> up) {
        this.up = up;
    }

    public Node<T> getDown() {
        return down;
    }

    public void setDown(Node<T> down) {
        this.down = down;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
