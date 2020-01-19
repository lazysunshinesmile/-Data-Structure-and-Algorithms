package com.sun.sort.algorithm;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] ret = sortColors.sortColors(new int[]{0});
        System.out.println(Arrays.toString(ret));
    }

    public int[] sortColors(int[] nums) {
        int i = 0; //当前0下标
        int j = nums.length -1; //当前2的下标
        for(int k = 0; k <= j;k++) {
            if(nums[k] == 0) {
                swap(nums, i++, k);
            } else if(nums[k] == 2) {
                swap(nums, k--, j--);
            }
        }

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
