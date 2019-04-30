package com.sun.sort.algorithm;

import javax.swing.tree.TreeNode;

class NumArray {
//    ["NumArray","sumRange","update","sumRange"]
//            [[[1,3,5]],[0,2],[1,2],[0,2]]


//    ["NumArray","sumRange","update","update","update","update","sumRange"]
//            [[[5,18,13]],[0,2],[1,-1],[2,3],[0,5],[0,-4],[0,2]]
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{5,18,13});
//        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray);
        numArray.update(0,2);
        System.out.println(numArray);

        numArray.update(1,-1);
        System.out.println(numArray);

        numArray.update(2,3);
        System.out.println(numArray);
        numArray.update(0,5);
        System.out.println(numArray);
        numArray.update(0,-4);
        System.out.println(numArray);
         numArray.update(0,2);
        System.out.println(numArray);
//        System.out.println(numArray.sumRange(0,2));

    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i =0;i<tree.length;i++) {
            stringBuffer.append(tree[i]+" ");
        }
        return stringBuffer.toString();
    }

    private  int[] tree;
    private int n;

    public NumArray(int[] nums) {

        n = nums.length;
        tree = new int[n * 2];

        createTree(nums);

    }

    public void createTree(int[] nums) {

        tree = new int[n*2];
        int last = 0;
        for(int i=0; i<n; i++) {
            tree[i+n] = nums[i];
        }
        for(int i=n-1;i>0;i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    public void update(int i, int val) {
        int cha = val-tree[n+i];
        tree[i+n] = val;
        int index = (i+n)/2;
        while(index > 0) {
            tree[index] = tree[index] + cha;
            index/=2;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int l = i + n;
        int r = j + n;
        while( l<=r) {
            if (l % 2 == 1) {
                //右孩子
                sum += tree[l];
                l++;
            }
            if(r %2 == 0) {
                //左孩子
                sum += tree[r];
                r--;
            }
            l/=2;
            r/=2;
        }

        return sum;


    }
}
