package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(new int[]{-10,-1,-18,-19}, -19);
        for(int k =0;k<res.length;k++) {
            System.out.println(res[k]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        /*for(int i =0; i<nums.length;i++) {
            for(int j = nums.length-1;j>i;j--) {
                if(nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }

            }
        }*/


        Map<Integer, Integer> maps = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            int key = target - nums[i];
            if(maps.containsKey(key)) {
                ret[0] = i;
                ret[1] = maps.get(key);
                return ret;
            } else{
                maps.put(nums[i], i);
            }
        }
        return null;
    }
}
