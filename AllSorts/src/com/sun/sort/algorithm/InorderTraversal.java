package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {


    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);


//        List ret = inorderTraversal.inorderTraversal(treeNode);
//        System.out.println(ret);


        TreeNode t = new TreeNode(2);
        TreeNode m = t;
        t.val = 12;
        System.out.println(m.val);
    }

    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        ret.addAll(inorderTraversal(root.left));
        ret.add(root.val);
        ret.addAll(inorderTraversal(root.right));


        return ret;
    }*/


    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        TreeNode temp = root.left;
        while() {
            while (temp.left != null) {
                temp = temp.left;
            }

            ret.add(temp.val);

            temp = root.right;

            while (temp.right != null) {
                temp = temp.right;
            }

            ret.add(temp.val);
        }
        return ret;
    }*/




    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
