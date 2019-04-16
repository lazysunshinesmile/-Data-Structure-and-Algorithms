package com.xiangsun.tree.study;

public class MainTest {
    public static void main(String[] args) {
        long a=System.currentTimeMillis();
        //这里放需要测试执行时间的代码段。

        AVLTree<Integer> avlTree2 = new AVLTree<>();
        AVLNode<Integer> avlNode2 = new AVLNode(0);
        for(int i = 1; i< 10000000; i++) {
//            avlNode2 = avlTree2.insert(i, avlNode2);
        }
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        System.out.println("是AVL ："+ TreeUtil.isBalanced(avlNode2));
    }
}
