package com.sun.sort.algorithm;

import java.util.Arrays;

public class QuickSort {
    /**
     * 快速排序，取第一个作为基准值，每次执行partition 就是把基准值放在他该放的位置，
     * 比他的小的都放到他前面，比他大的都放到他后面。然后在把基准值前面的所有数再执行一遍partition，
     * 后面的也执行一遍。
     * @param args
     */
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{5,4,2,4,5,86,78,98,};
        quickSort.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid -1);
        quickSort(arr, mid+1, right);
    }


    public int partition(int[] arr, int left, int right) {
        int mid = arr[left];
        while(left < right){
            while(left <right && arr[right] >= mid) {
                right--;
            }
                arr[left] = arr[right];
            while(left <right && arr[left] <= mid) {
                left++;
            }
                arr[right] = arr[left];
        }
        arr[left] = mid;
        return left;
    }



}
