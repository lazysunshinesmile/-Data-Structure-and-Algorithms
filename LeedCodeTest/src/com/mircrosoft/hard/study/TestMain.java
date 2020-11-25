package com.mircrosoft.hard.study;


import com.mircrosoft.hard.study.utils.Utils;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                solution.longestConsecutive(Utils.
                        string2TreeNode("[1,6,2,7,5,null,null,8,null,6,4,7,9,null,null,3,5,null,null,10,8,4,2,null,null,9,11,null,null,1]")));
    }
}
