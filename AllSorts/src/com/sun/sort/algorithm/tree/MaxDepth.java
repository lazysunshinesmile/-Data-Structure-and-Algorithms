package com.sun.sort.algorithm.tree;

public class MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * @param root
     * @return
     */

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return getMaxDepth(root, 1);

    }


//height root 所在的高度。
    private int getMaxDepth(TreeNode root, int height) {
        if(root == null) {
            return height;
        }
        if(root.right == null && root.left == null) {
            return height;
        }
        height++;
        return Math.max(getMaxDepth(root.left, height), getMaxDepth(root.right, height));
    }
}
