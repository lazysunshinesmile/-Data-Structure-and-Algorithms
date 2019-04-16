package com.xiangsun.tree.study;

public class AVLTree<E extends Comparable> {

    public AVLTree() {
    }

    public AVLNode insert(E k, AVLNode<E> root) {
        if(root == null) {
            return new AVLNode(k);
        }
        int compareRes = root.getElement().compareTo(k);
        // root 小，放在root的右侧
        if(compareRes < 0) {
            // root小，插入root的右侧，递归插入
            root.setRightNode(insert(k, root.getRightNode()));
            root.setHeight(root.getHeight() + 1);

            //检测是否需要旋转，因为是插在右侧，所以即使会失掉平衡，也是右边的比左边的长
            if(height(root.getRightNode()) - height(root.getLeftNode()) >= 2) {
                if(root.getRightNode().getElement().compareTo(k) < 0) {
                    //左旋
                    root = leftRoate(root);
                }else if(root.getRightNode().getElement().compareTo(k) > 0) {
                    //先左旋再右旋
                    root = leftAndRightRoate(root);
                }
            }
        }else if(compareRes > 0) {
            // 插入这个根节点的左侧，递归插入
            root.setLeftNode(insert(k, root.getLeftNode()));
            root.setHeight(root.getHeight() + 1);

            //检测是否需要旋转，因为是插在左侧，所以即使会失掉平衡，也是左边的比右边的长
            if(height(root.getLeftNode())- height(root.getRightNode()) >= 2) {
                if(root.getRightNode() == null) {
                    //右旋
                    root = rightRoate(root);
                }else {
                    //先右旋再左旋
                    root = rightAndLeftRoate(root);
                }
            }
        }

        return root;

    }

    public AVLNode remove() {

        return null;
    }

    public AVLNode leftRoate(AVLNode<E> root) {
        AVLNode newRoot = root.getRightNode();
        root.setRightNode(newRoot.getLeftNode());
        newRoot.setLeftNode(root);

        root.setHeight( Math.max(height(root.getLeftNode()), height(root.getRightNode())) + 1);
        newRoot.setHeight(Math.max(height(newRoot.getLeftNode()), height(newRoot.getRightNode())) + 1);

        return newRoot;

    }

    public AVLNode rightRoate(AVLNode<E> root) {
        AVLNode newRoot = root.getLeftNode();
        root.setLeftNode(newRoot.getRightNode());
        newRoot.setRightNode(root);

        root.setHeight( Math.max(height(root.getLeftNode()), height(root.getRightNode())) + 1);
        newRoot.setHeight(Math.max(height(newRoot.getLeftNode()), height(newRoot.getRightNode())) + 1);

        return newRoot;

    }

    public AVLNode leftAndRightRoate(AVLNode<E> root) {
        root.setLeftNode(leftRoate(root.getLeftNode()));
        return rightRoate(root);
    }

    public AVLNode rightAndLeftRoate(AVLNode<E> root) {
        root.setRightNode(rightRoate(root.getRightNode()));
        return leftRoate(root);
    }


    public int height(AVLNode t) {
        return t == null ? -1 : t.getHeight();
    }

}
