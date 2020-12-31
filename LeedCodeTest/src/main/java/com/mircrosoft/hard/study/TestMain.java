package com.mircrosoft.hard.study;


import com.mircrosoft.hard.study.utils.Utils;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> ret = solution.numIslands3(3,3,
                new int[][]{{0,0},{0,1},{1,2},{2,1}});
        System.out.println(Arrays.toString(ret.toArray()));




    }
}
