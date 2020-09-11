package com.mircrosoft.hard.study;

import com.mircrosoft.hard.study.bean.ListNode;
import com.mircrosoft.hard.study.utils.Utils;

import java.util.Arrays;
import java.util.Comparator;

public class TestMain {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] k;
        Arrays.sort(k, (String s, String t1) -> {
                return (t1 + s).compareTo(s + t1);
            }
        );


        long t1 = System.currentTimeMillis();
        for(int i=0; i< 1000000; i++) {
            //3413
//            String s = i + "";
//            System.out.println(s);
//2999
            String s = String.valueOf(i);
            System.out.println(s);
        }
        System.out.println("internal:" + (System.currentTimeMillis() - t1));

    }
}
