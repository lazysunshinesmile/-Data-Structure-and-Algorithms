package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        int[] kk = new int[]{-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
        System.out.println(singleNumber(kk));

    }

    public static int singleNumber(int[] nums) {
        //排序
        Arrays.sort(nums);
        for(int i = 0; i+1< nums.length ;) {
            if(nums[i] == nums[i+1]) {
                i += 3;
            }else {
                return nums[i];
            }
        }
        return nums[nums.length -1];
    }
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> countOfNum = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            if(countOfNum.containsKey(nums[i])) {
                Integer count = countOfNum.get(nums[i]);
                countOfNum.put(nums[i], ++count);
            }else {
                countOfNum.put(nums[i], 1);
            }
        }

        for(Integer value : countOfNum.keySet()) {
            if(countOfNum.get(value) == 1) {
                return value;
            }
        }
        return 0;


    }
}
