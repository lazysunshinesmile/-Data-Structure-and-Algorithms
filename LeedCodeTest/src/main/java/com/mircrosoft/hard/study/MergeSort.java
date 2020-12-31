package com.mircrosoft.hard.study;

public class MergeSort {
    /**
     * 归并排序（分治法）
     * 递归到最小的两个位置（index和index+1），
     * 再假定左（left）右（right）两个都是已排序好的。
     * 将左右两侧的依次最小（排序规则）的放入复制的数组中，
     * 最后可能left或者right还有一些数没有放进去。
     *
     */

    public void mergesort(int[] arr, int low, int hi) {
        if(low == hi) {
            return;
        }
        int mid = (hi - low) /2 + low;
        mergesort(arr, low, mid);
        mergesort(arr, mid+1, hi);
        mergeSortInternal(arr, low, hi, mid);
    }

    public void mergeSortInternal(int[] arr, int low, int hi, int mid) {
        //定义左右两个数组的起始位置
        int p1 = low;
        int p2 = mid + 1;
        //复制的数组
        int[] temp = new int[hi - low + 1];
        //temp的下标，从0开始。
        int index = 0;
        while(p1 <= mid && p2 <= hi) {
            if(arr[p1] < arr[p2]) {
                temp[index++] = arr[p1++];
            } else {
                temp[index++] = arr[p2++];
            }
        }

        while(p1 <= mid) {
            temp[index++] = arr[p1++];
        }

        while(p2 <= hi) {
            temp[index++] = arr[p2++];
        }
        //将temp重新复制到array中
        for(int i= low; i<=hi; i++) {
            arr[i] = temp[i-low];
        }


    }











}
