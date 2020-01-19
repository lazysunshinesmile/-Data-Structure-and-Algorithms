package com.sun.sort.algorithm;

public class JumpGameII {
    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
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

