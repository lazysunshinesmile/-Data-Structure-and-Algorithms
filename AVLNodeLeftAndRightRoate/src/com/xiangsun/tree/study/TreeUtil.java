package com.xiangsun.tree.study;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    public static void preorderTraversal(AVLNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getElement() + " ");
        preorderTraversal(node.getLeftNode());
        preorderTraversal(node.getRightNode());



    }

    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public static boolean isBalanced(AVLNode root) {
        // write your code here
        return levelOrder(root);

    }
    private static int getHeight(AVLNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(getHeight(root.getRightNode())+1, getHeight(root.getRightNode())+1);
        }
    }
    private static boolean levelOrder(AVLNode root){
        if(root==null){
            return true;
        }
        Queue<AVLNode> queue=new LinkedList<AVLNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            AVLNode node=queue.poll();
            if(Math.abs(getHeight(node.getLeftNode())-getHeight(node.getRightNode()))>1){
                if(node.getLeftNode() != null) {
                    if(node.getLeftNode().getElement().compareTo(node.getElement()) > 0) {
                        return false;
                    }
                }
                if(node.getRightNode() != null) {
                    if(node.getRightNode().getElement().compareTo(node.getElement()) < 0) {
                        return false;
                    }
                }
                return false;
            }
            if(node.getLeftNode()!=null){
                queue.offer(node.getLeftNode());
            }
            if(node.getRightNode()!=null){
                queue.offer(node.getRightNode());
            }
        }
        return true;
    }


}
