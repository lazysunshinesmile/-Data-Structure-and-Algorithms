package com.sun.sort.algorithm;

import java.util.*;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
//        List<Character> cs = new ArrayList<>();
//        int max=0;
//        for(int i=0;i<s.length();i++) {
//            if(cs.contains(s.charAt(i))) {
//                if(cs.size() >max) {
//                    max = cs.size();
//                }
//                char c = s.charAt(i);
//                int index = cs.indexOf(c);
//                int size = cs.size() - index-1;
//                for(int j = 0; cs.size()>size;) {
//                    cs.remove(j);
//                }
//                cs.add(c);
//            }else {
//                cs.add(s.charAt(i));
//            }
//        }
//
//        return max > cs.size() ? max :cs.size();


        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        //i 代表的是set中第一个字母在原字符串的位置
        //j 代表的是set中最后一个字母在原字符串的位置
        //如果有重复的，就会从i开始删除，直到set.contains没有重复的。
        //ans会存储上一次删除之前最大的值。
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
