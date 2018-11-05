package com.rui.algorithm.datastructure.tree;

import java.util.Stack;


/**
 * 红黑树算法
 *
 * @param <T>
 */
public class RBTree<T extends Comparable> {

    private RBNode<T> root;

    public void insert(T value) {
        RBNode needToAppendTo = root;
        RBNode temp = root;
        while(temp != null) {
            needToAppendTo = temp;
            if(value.compareTo(temp.getValue()) < 0) {
                temp = temp.getLeftChild();
            } else {
                temp = temp.getRightChild();
            }
        }

        if(needToAppendTo == null) {
            RBNode node = new RBNode(false, value);
            root = node;
        } else {
            RBNode node = new RBNode(value);
            node.setParent(needToAppendTo);
            if(value.compareTo(needToAppendTo.getValue()) < 0) {
                needToAppendTo.setLeftChild(node);
            } else {
                needToAppendTo.setRightChild(node);
            }
            fixAfterInsertion(node);
        }
    }

    private void fixAfterInsertion(RBNode<T> node) {
        while(node.getParent() != null && node.getParent().getRed()) {
            RBNode<T> parent = node.getParent();
            RBNode<T> grand = parent.getParent();
            if(parent.equals(grand.getLeftChild())) {
                RBNode<T> right = grand.getRightChild();
                if(right != null && right.getRed()) {
                    parent.setRed(false);
                    right.setRed(false);
                    grand.setRed(true);
                    node = grand;
                    continue;
                }

                if(node.equals(parent.getRightChild())) {
                    node = parent;
                    leftRotate(parent);
                }

                parent.setRed(false);
                grand.setRed(true);
                rightRotate(grand);
            } else {
                RBNode<T> left = grand.getLeftChild();
                if(left != null && left.getRed()) {
                    parent.setRed(false);
                    left.setRed(false);
                    grand.setRed(true);
                    node = grand;
                    continue;
                }

                if(node.equals(parent.getLeftChild())) {
                    node = parent;
                    rightRotate(parent);
                }

                parent.setRed(false);
                grand.setRed(true);
                leftRotate(grand);
            }
        }
        root.setRed(false);
    }

    public void remove(T value) {
        RBNode needToRemove = find(value);
        if(needToRemove == null)  return;

        if(needToRemove.getLeftChild() != null || needToRemove.getRightChild() != null) {
            RBNode<T> node = successor(needToRemove);
            needToRemove.setValue(node.getValue());
            needToRemove = node;
        }

        RBNode replacement = needToRemove.getLeftChild() != null ? needToRemove.getLeftChild() : needToRemove.getRightChild();
        if(replacement != null) {
            replacement.setParent(needToRemove.getParent());
            if(needToRemove.getParent() == null) {
                root = replacement;
            } else if(needToRemove.getLeftChild().equals(needToRemove)){
                needToRemove.getParent().setLeftChild(replacement);
            } else {
                needToRemove.getParent().setRightChild(replacement);
            }
            needToRemove.setRightChild(null);
            needToRemove.setLeftChild(null);
            needToRemove.setParent(null);

            if (!needToRemove.getRed())
                fixAfterDeletion(replacement);

        } else if(needToRemove.getParent() == null) {
            root = null;
        } else {
            if (!needToRemove.getRed())
                fixAfterDeletion(replacement);

            if(needToRemove.getParent() != null) {
                if(needToRemove.getLeftChild().equals(needToRemove)){
                    needToRemove.getParent().setLeftChild(null);
                } else {
                    needToRemove.getParent().setRightChild(null);
                }
                needToRemove.setParent(null);
            }
        }
    }

    private void fixAfterDeletion(RBNode<T> node) {

    }

    private RBNode<T> successor(RBNode<T> node) {
        if(node == null) return null;

        if(node.getRightChild() != null) {
            RBNode<T> tmp = node.getRightChild();
            while (tmp.getLeftChild() != null) {
                tmp = tmp.getLeftChild();
            }
            return tmp;
        } else if(node.getLeftChild() != null) {
            RBNode<T> tmp = node.getRightChild();
            while (tmp.getRightChild() != null) {
                tmp = tmp.getRightChild();
            }
            return tmp;
        }
        return null;
    }

    public RBNode<T> find(T value) {
        RBNode<T> cur = root;
        while(cur != null && !value.equals(cur.getValue())) {
            if(value.compareTo(cur.getValue()) < 0) {
                cur = cur.getLeftChild();
            } else {
                cur = cur.getRightChild();
            }
        }
        return cur;
    }

    public void leftRotate(RBNode<T> node) {
        RBNode<T> right  = node.getRightChild();
        node.setRightChild(right.getLeftChild());

        if(right.getLeftChild() != null)
            right.getLeftChild().setParent(node);

        right.setParent(node.getParent());
        if(node.getParent() == null) {
            this.root = right;
        } else {
            if(node.getParent().getLeftChild().equals(node)) {
                node.getParent().setLeftChild(right);
            } else {
                node.getParent().setRightChild(right);
            }
        }

        right.setLeftChild(node);
        node.setParent(right);
    }

    public void rightRotate(RBNode<T> node) {
        RBNode<T> left  = node.getLeftChild();
        node.setLeftChild(left.getRightChild());

        if(left.getRightChild() != null)
            left.getRightChild().setParent(node);

        left.setParent(node.getParent());
        if(node.getParent() == null) {
            this.root = left;
        } else {
            if(node.getParent().getRightChild().equals(node)) {
                node.getParent().setRightChild(left);
            } else {
                node.getParent().setLeftChild(left);
            }
        }
        left.setRightChild(node);
        node.setParent(left);
    }

    public void preOrder() {
        preOrder(root);
        System.out.print("\n");
    }

    private void preOrder( RBNode<T> node) {
        if(node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    public void preOrderLoop() {
        Stack<RBNode<T>> stack = new Stack<>();
        RBNode<T> cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                System.out.print(cur.getValue() + " ");
                stack.push(cur);
                cur = cur.getLeftChild();
            }
            if(!stack.empty()) {
                cur = stack.pop();
                cur = cur.getRightChild();
            }
        }
        System.out.print("\n");
    }

    public void centerOrder() {
        centerOrder(root);
        System.out.print("\n");
    }


    private void centerOrder( RBNode<T> node) {
        if(node != null) {
            centerOrder(node.getLeftChild());
            System.out.print(node.getValue() + " ");
            centerOrder(node.getRightChild());
        }
    }

    public void centerOrderLoop() {
        Stack<RBNode<T>> stack = new Stack<>();
        RBNode<T> cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeftChild();
            }
            if(!stack.empty()) {
                cur = stack.pop();
                System.out.print(cur.getValue() + " ");
                cur = cur.getRightChild();
            }
        }
        System.out.print("\n");
    }

    public void lastOrder() {
        lastOrder(root);
        System.out.print("\n");
    }

    private void lastOrder( RBNode<T> node) {
        if(node != null) {
            lastOrder(node.getLeftChild());
            lastOrder(node.getRightChild());
            System.out.print(node.getValue() + " ");
        }
    }

    public void lastOrderLoop() {
        Stack<RBNode<T>> stack = new Stack<>();
        stack.push(root);
        RBNode<T> cur, pre = null;
        while (!stack.empty()) {
            cur = stack.peek();
            if((cur.getRightChild() == null && cur.getLeftChild() == null)
                    || (pre != null && (pre.equals(cur.getLeftChild()) || pre.equals(cur.getRightChild())))) {
                System.out.print(cur.getValue() + " ");
                stack.pop();
                pre = cur;
            } else {
                if(cur.getRightChild() != null) {
                    stack.push(cur.getRightChild());
                }
                if(cur.getLeftChild() != null) {
                    stack.push(cur.getLeftChild());
                }
            }
        }
        System.out.print("\n");
    }

    public void print() {
        this.print(root,  null,0, false);
    }

    private void print(RBNode<T> node, RBNode<T> parent, int level, boolean isLeft) {
        if(level == 0) {
            System.out.printf("Root(%s,%s)\n", node.getValue(), node.getRed()? 'R' : 'B');
        } else {
            if(node == null) {
                System.out.printf("Level%d(%s,%s,%s,%s)\n", level, "NIL", isLeft? 'L':'R', 'B', parent.getValue());
            } else {
                System.out.printf("Level%d(%s,%s,%s,%s)\n", level, node.getValue(), isLeft? 'L':'R', node.getRed()?'R':'B', parent.getValue());
            }
        }
        if(node != null) {
            print(node.getLeftChild(), node, level + 1, true);
            print(node.getRightChild(), node, level + 1, false);
        }
    }

    private class RBNode<T extends Comparable> implements Comparable<RBNode<T>> {

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
        public int compareTo(RBNode<T> o) {
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
}
