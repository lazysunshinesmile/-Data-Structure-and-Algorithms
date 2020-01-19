package com.sun.sort.algorithm.tree;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
       /* TheSameTree theSameTree = new TheSameTree();

        TheSameTree.TreeNode treeNode = new TheSameTree.TreeNode(1);
        TheSameTree.TreeNode treeNode1 = new TheSameTree.TreeNode(2);
        TheSameTree.TreeNode treeNode2 = new TheSameTree.TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        TheSameTree.TreeNode treeNode3 = new TheSameTree.TreeNode(1);
        TheSameTree.TreeNode treeNode4 = new TheSameTree.TreeNode(3);
        TheSameTree.TreeNode treeNode5 = new TheSameTree.TreeNode(1);
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        boolean isSame = theSameTree.isSameTree(treeNode, treeNode3);
        System.out.println(isSame);
*/

       /* IsSymmetric isSymmetric = new IsSymmetric();
        IsSymmetric.TreeNode treeNode = new IsSymmetric.TreeNode(3);
        IsSymmetric.TreeNode treeNode1 = new IsSymmetric.TreeNode(4);
        IsSymmetric.TreeNode treeNode2 = new IsSymmetric.TreeNode( 5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = null;
        treeNode1.right = null;
        treeNode2.left = new IsSymmetric.TreeNode(8);
        treeNode2.right = new IsSymmetric.TreeNode(9);

        IsSymmetric.TreeNode treeNode3 = new IsSymmetric.TreeNode(3);
        IsSymmetric.TreeNode treeNode4 = new IsSymmetric.TreeNode(5);
        IsSymmetric.TreeNode treeNode5 = new IsSymmetric.TreeNode(4 );
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = new IsSymmetric.TreeNode(9);
        treeNode4.right = new IsSymmetric.TreeNode(8);
        treeNode5.right= null;
        treeNode5.left = null;






        IsSymmetric.TreeNode root = new IsSymmetric.TreeNode(1);
        root.left = treeNode;
        root.right = treeNode3;
        System.out.println(isSymmetric.isSymmetric(root));*/

//
//        TreeNode t1 = new TreeNode(3);
//        TreeNode t2 = new TreeNode(9);
//        TreeNode t3 = new TreeNode(20);
//        t1.left = t2;
//        t1.right = t3;
//
//        TreeNode t4 = new TreeNode(15);
//        TreeNode t5 = new TreeNode(7);
//        t3.left = t4;
//        t3.right = t5;
//
//        t2.left = t4;
//        t2.right = t5;
//
//        LevelOrder levelOrder = new LevelOrder();
//        List<List<Integer>> ret = levelOrder.levelOrder(t1);
//
//        for(List<Integer> arr: ret) {
//            System.out.println(Arrays.toString(arr.toArray()));
//        }



        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        t1.left = t2;
        t2.right = t3;
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(t1));


    }
}
