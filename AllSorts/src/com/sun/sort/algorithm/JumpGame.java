package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class JumpGame {
//    private Set<Integer> counts = new HashSet<>();
    private int min;
    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.jump(new int[] {5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0}));
    }

    public int jump(int[] nums) {
        int end = 0;
        int furthest =0;
        int result=0;

        for(int i=0;i<nums.length-1;i++){
            furthest = Math.max(furthest, i+nums[i]);
            if(i==end){
                result+=1;
                end = furthest;
            }
        }

        return result;
    }
}
