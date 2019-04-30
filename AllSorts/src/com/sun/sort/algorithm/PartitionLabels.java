package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String S) {
//        List<Integer> ret = new ArrayList<>();
//        for(int i=0; i<s.length();) {
//            char c = s.charAt(i);
//            int tempLast = findLast(c,s);
//            if(tempLast == -1) {
//                ret.add(1);
//                continue;
//            }
//            for(int j=i+1;j<tempLast;j++) {
//                if(s.charAt(j) == c) {
//                    continue;
//                }
//                tempLast = Math.max(tempLast, findLast(s.charAt(j), s));
//            }
//            ret.add(tempLast - i + 1);
//            i = tempLast +1;
//        }
//        return ret;

        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;




    }

    public int findLast(char c, String s) {
        for(int i=s.length() -1; i>=0;i--) {
            if(s.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }
}
