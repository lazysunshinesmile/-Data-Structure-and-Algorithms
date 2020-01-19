package com.sun.sort.algorithm.tree;

import java.util.*;

public class IsSymmetric {
    //是不是对称二叉树：
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/symmetric-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    //这个节点的左右对象是否相同
    public boolean isSymmetric(TreeNode root) {
        // 递归
        if(root == null) {
            return true;
        }

//        return isSame(root, root);

        //遍历
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);



        while(!queue.isEmpty()) {
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }
        return  true;

    }

    //递归 两个节点是否一样。
    //左节点的左节点与右节点的右节点比较，左节点的右节点与右节点的左节点比较。
    public boolean isSame(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) {
            return false;
        }

        if(isSame(left.left, right.right) &&
        isSame(left.right, right.left)) {
            return true;
        }

        return false;

    }
    // 遍历





}
