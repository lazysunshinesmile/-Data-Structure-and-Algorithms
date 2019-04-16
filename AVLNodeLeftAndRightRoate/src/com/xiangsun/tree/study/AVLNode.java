package com.xiangsun.tree.study;


public class AVLNode<E extends Comparable> {
    private E element;
    private AVLNode leftNode;
    private AVLNode rightNode;
    private int height;

    public AVLNode(E element) {
        this(element, null, null);
        this.height = 0;
    }

    public AVLNode(E element, AVLNode leftNode, AVLNode rightNode) {
        this.element = element;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public AVLNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNode leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
