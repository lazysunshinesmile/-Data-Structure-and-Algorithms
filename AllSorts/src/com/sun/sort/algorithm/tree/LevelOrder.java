package com.sun.sort.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOrder {
    /**
     * b给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> rootRet = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        rootRet.add(root.val);
        ret.add(rootRet);
//        ret = getNodeVal(ret, root, 1);



        return ret;

    }

    /**
     *
     * @param ret   返回的链表
     * @param root  需要统计的相对根节点
     * @param depth 统计的节点的深度
     * @return
     */
    /*public List<List<Integer>> getNodeVal(List<List<Integer>> ret, TreeNode root, int depth) {
        if(root == null) {
            return ret;
        }
        if(root.left == null && root.right == null) {
            return ret;
        }

        if(ret.size() <= depth) {
            ret.add(new ArrayList<>());
        }
        List<Integer> dep = ret.get(depth);
        if(dep == null) {
            ret.add(new ArrayList<>());
            dep = ret.get(depth);
        }

        if(root.left != null) {
            dep.add(root.left.val);
        }
        if(root.right != null) {
            dep.add(root.right.val);
        }

        getNodeVal(ret, root.left, ++depth);
        getNodeVal(ret, root.right, depth);
        return ret;
    }*/


}
