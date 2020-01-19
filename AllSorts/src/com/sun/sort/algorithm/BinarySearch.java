package com.sun.sort.algorithm;

public class BinarySearch {

    private int[] arr = new int[] {1,2,3,4,5};

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.getIndex(6));
    }

    private int getIndex(int target) {
        int start =0;
        int end = arr.length -1;
        while(true) {
            if(start > end) {
                break;
            }

            int index = (start + end) /2;
            if(target == arr[index]) {
                return index;
            }else if( target > arr[index]) {
                start = index + 1;
            } else if(target <arr[index]) {
                end = index -1;
            }



        }

        return -1;
    }
}
