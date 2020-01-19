package com.sun.sort.algorithm.tree;

public class TheSameTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode(int x) { val = x; }
    }

    // 该节点与他的直接子节点是否一样。
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q != null) {
            return false;
        }
        if(p == null && q == null) {
            return true;
        }

        if(p != null && q == null) {
            return false;
        }

        if(p.val != q.val) {
            return false;
        }

        if(!isSameTree(p.left, q.left)) {
            return false;
        }
        if(!isSameTree(p.right, q.right)) {
            return false;
        }




        return true;
    }


}
