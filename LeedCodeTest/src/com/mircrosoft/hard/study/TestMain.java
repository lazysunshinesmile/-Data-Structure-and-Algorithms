package com.mircrosoft.hard.study;

import com.mircrosoft.hard.study.bean.ListNode;
import com.mircrosoft.hard.study.bean.Vector2D;
import com.mircrosoft.hard.study.utils.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestMain {
    public static void main(String[] args) {
//[1111, 8118, 6119, 9116, 1881, 8888, 6889, 9886, 1001, 8008, 6009, 9006, 1691, 8698, 6699, 9696, 1961, 8968, 6969, 9966]
//["1001","1111","1691","1881","1961","6009","6119","6699","6889","6969","8008","8118","8698","8888","8968","9006","9116","9696","9886","9966"]
        Solution solution = new Solution();
//        System.out.println(solution.groupStrings(new String[]{"aa","bb","b"}));
//        ["Vector2D","hasNext","next","hasNext"]
//[[[[],[3]]],[null],[null],[null]]
        System.out.println(solution.getFactors(12));
    }
}
