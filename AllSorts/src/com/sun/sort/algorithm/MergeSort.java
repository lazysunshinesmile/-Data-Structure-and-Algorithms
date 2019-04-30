package com.sun.sort.algorithm;

public class MergeSort implements SortAlgorithm {
    @Override
    public int[] sort(int[] array) {
        int length = array.length;
        int[] tmp = new int[array.length];
        tmp = mergeSort(array, tmp, 0, length-1);
        return tmp;
    }

    public int[] mergeSort(int[] a, int[] tmp, int left, int right ) {
        if(left < right) {
            int center = (right + left) /2;
            //分冶，左边排序
            mergeSort(a, tmp, left, center);
            //分冶，右边排序
            mergeSort(a, tmp, center + 1, right);
            //分冶，合并
            mergeSort(a, tmp, left, center, right);

        }
        return a;
    }

    /**
     *array[left,center], array[center+1, right].左右两边的边界一定要统一。
     * @param a 原数组
     * @param tmp 合并之后的数组
     * @param left 左边的初始值
     * @param center 中间值,右边的初始值
     * @param right 右边的末尾值
     */
    public int[] mergeSort(int[] a, int[] tmp, int left, int center, int right) {
        int i=left, j = center + 1, k = left;

        while(i<=center && j<=right) {
            if(a[i] < a[j]) {
                tmp[k] = a[i];
                i++;
            }else {
                tmp[k] = a[j];
                j++;
            }
            k++;
        }

            //右边提前结束了,把左边的数组直接加过去
            while(i<= center){
                tmp[k++] = a[i++];
            }

            //左边提前结束了,把右边的数组直接加过去\
            while(j<= right) {
                tmp[k++] = a[j++];
            }


        for( int m = left; m <= right ;m ++) {
            a[m] = tmp[m];
        }

        return a;
    }


}
