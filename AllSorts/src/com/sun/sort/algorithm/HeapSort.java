package com.sun.sort.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class HeapSort {
    private int count = 0;

    /**
     * 建堆前:[3, 7, 2, 11, 3, 4, 9, 2, 18, 0]
     * 建堆后:[18, 11, 9, 7, 3, 4, 2, 2, 3, 0]
     * 1次调整前:[0, 11, 9, 7, 3, 4, 2, 2, 3, 18]
     * 1次调整后:[11, 7, 9, 2, 3, 4, 2, 0, 3, 18]
     * 2次调整前:[3, 7, 9, 2, 3, 4, 2, 0, 11, 18]
     * 2次调整后:[9, 7, 4, 2, 3, 3, 2, 0, 11, 18]
     * 3次调整前:[0, 7, 4, 2, 3, 3, 2, 9, 11, 18]
     * 3次调整后:[7, 3, 4, 2, 0, 3, 2, 9, 11, 18]
     * 4次调整前:[2, 3, 4, 2, 0, 3, 7, 9, 11, 18]
     * 4次调整后:[4, 3, 2, 2, 0, 3, 7, 9, 11, 18]
     * 5次调整前:[3, 3, 2, 2, 0, 4, 7, 9, 11, 18]
     * 5次调整后:[3, 3, 2, 2, 0, 4, 7, 9, 11, 18]
     * 6次调整前:[0, 3, 2, 2, 3, 4, 7, 9, 11, 18]
     * 6次调整后:[3, 0, 2, 2, 3, 4, 7, 9, 11, 18]
     * 7次调整前:[2, 0, 2, 3, 3, 4, 7, 9, 11, 18]
     * 7次调整后:[2, 0, 2, 3, 3, 4, 7, 9, 11, 18]
     * 8次调整前:[2, 0, 2, 3, 3, 4, 7, 9, 11, 18]
     * 8次调整后:[2, 0, 2, 3, 3, 4, 7, 9, 11, 18]
     * 9次调整前:[0, 2, 2, 3, 3, 4, 7, 9, 11, 18]
     * 9次调整后:[0, 2, 2, 3, 3, 4, 7, 9, 11, 18]
     * 10次调整前:[0, 2, 2, 3, 3, 4, 7, 9, 11, 18]
     * 10次调整后:[0, 2, 2, 3, 3, 4, 7, 9, 11, 18]
     * [0, 2, 2, 3, 3, 4, 7, 9, 11, 18]
     */

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr) {
        //element_index = i; parent = (i-1)/2; leftChild=2*i+1; rightChild=2*i+2;
        //一个完全二叉树有arr.length个分支（一个父亲加两个儿子）需要修改
        System.out.println("建堆前:" + Arrays.toString(arr));
        for(int i=arr.length/2-1;i>=0;i--) {
            adjustHeap(arr,i, arr.length);
        }
        System.out.println("建堆后:" + Arrays.toString(arr));

        //开始排序
        for(int i=arr.length-1; i>=0;i--) {
            //吧最大的放到最后面，再重新建堆
            swap(arr, 0, i);
            System.out.println(++count + "次调整前:" + Arrays.toString(arr));
            adjustHeap(arr, 0, i-1);
            System.out.println(count + "次调整后:" + Arrays.toString(arr));
        }

    }

    /**
     * 调整堆
     * @param arr 原数组
     * @param parent 需要从哪个父节点开始向下调整
     * @param size 调整的末尾。一开始为arr.length;
     */

    public void adjustHeap(int[] arr,int parent, int size) {
        //parent的值是父亲的下标
        //大顶堆
        int leftChild = 2*parent+1;
        int rightChild = 2*parent +2;
        int i = parent;
        if(leftChild < size && arr[parent] < arr[leftChild]) {
            i = leftChild;
        }
        //如果上面已经发生变化，下面应该那arr[i] 和 arr[rightChild]比较
        if(rightChild < size && arr[i] < arr[rightChild]) {
            i = rightChild;
        }
        if(parent != i) {
            //如果i的做了修改，i变成了parent的左儿子或者右儿子，就要先交换再递归的修改他的子树
            swap(arr,i, parent);
            adjustHeap(arr, i, size);
        }
    }

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
