package me.arui.datastruct.skiplist;


import java.util.Random;


/**
 *
 * 跳跃表
 *
 * 应用于有序数据集合类型，例如Redis的Sorted sets
 *
 * @param <T>
 */
public class SkipList<T> {

    private static final int DEFAULT_LIST_LEVEL = 4;

    private static final double DEFAULT_PROBABILITY =0.5;

    private static final int HEAD_KEY = Integer.MIN_VALUE;

    private static final int TAIL_KEY = Integer.MAX_VALUE;

    private int listLevel = DEFAULT_LIST_LEVEL;

    private Node<T> header, tail;

    private double probability = DEFAULT_PROBABILITY;

    private Integer size;

    private Random random;

    public  SkipList() {
        initList();
    }

    public  SkipList(int listLevel, double probability) {
        this.listLevel = listLevel;
        this.probability = probability;
        initList();
        random = new Random();
    }

    private void initList() {
        header = new Node<T>(HEAD_KEY, null, listLevel);
        tail = new Node<T>(TAIL_KEY, null, listLevel);
        header.setRight(tail);
        header.getDown().setRight(tail);
    }

    public void put(int key, T value) {
        int level = random.nextInt(listLevel);
        Node<T> node = this.findNear(key);
        this.insertAfter(node, new Node<T>(key, value, level));
    }

    private Node<T> findNear(int key) {
        return this.findNear(this.header, key);
    }

    private Node<T> findNear(Node<T> node, int key) {
        Node<T> next = node.getRight();
        if(next.getKey() ==  key) return next;
        while (next != null) {
            if(next.getKey() <= key && next.getRight() != null && next.getRight().getKey() <= key) {
                next = next.getRight();
                continue;
            }else {
                if(next.getDown() != null) {
                    this.findNear(next.getDown(), key);
                } else {
                    break;
                }
            }
        }
        return next;
    }

    private void removeNode(Node<T> node) {
        Node<T> pre = node.getLeft();
        Node<T> next = node.getRight();
        pre.setRight(next);
        next.setLeft(pre);
        while(node.getDown() != null) {
            removeNode(node.getDown());
        }
    }

    private void insertAfter(Node<T> node, Node<T> nextNode) {
        if(node.getLevel() == nextNode.getLevel()) {
            Node<T> tmpNode = node.getRight();
            node.setRight(nextNode);
            nextNode.setLeft(node);
            nextNode.setRight(tmpNode);
            while(node.getDown() != null && nextNode.getDown() != null) {
                insertAfter(node.getDown(), nextNode.getDown());
            }
        } else {
            while(node.getDown() != null) {
                insertAfter(node.getDown(), nextNode);
            }
        }
    }

    public String printLevel(Node<T> header) {
        StringBuffer str = new StringBuffer(this.header.toString());
        Node<T> next = this.header.getRight();
        while (next != null) {
            str.append("--");
            str.append(next);
            next = next.getRight();
        }
        str.append("\n");
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer(printLevel(this.header));
        Node<T> down = this.header.getDown();
        while(down != null) {
            str.append(printLevel(this.header));
        }
        return str.toString();
    }

}
