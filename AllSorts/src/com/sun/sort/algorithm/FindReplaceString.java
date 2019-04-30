package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindReplaceString {

    public static void main(String[] args) {
        FindReplaceString findReplaceString = new FindReplaceString();
//        S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]

//        "vmokgggqzp"
//                [3,5,1]
//["kg","ggq","mo"]
//["s","so","bfr"]

//        "jjievdtjfb"
//                [4,6,1]
//["md","tjgb","jf"]
//["foe","oov","e"]

//        "vmokgggqzp"
//                [3,5,1]
//["kg","ggq","mo"]
//["s","so","bfr"]

//        "wqzzcbnwxc"
//                [5,2,7]
//["bn","zzc","wxc"]
//["t","lwb","nee"]

        //"wqlwbtnee"
        String ans = findReplaceString.findReplaceString("wqzzcbnwxc", new int[]{5,2,7},
                new String[]{"bn","zzc","wxc"},
                new String[]{"t","lwb","nee"});
        System.out.println(ans);
    }

    /**
     *
     * @param S     原始字符串
     * @param indexes   sources 每一个字符串在S 中的起始位置
     * @param sources   原字符串的子串
     * @param targets   目标字符串
     * @return
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);
        //把所有需要改变的字符串的手字符所在位置找出来，并用sources的下标表示。
        for(int i = 0; i <indexes.length ;i ++) {
            int ix = indexes[i];
            if(S.substring(ix, ix + sources[i].length()).equals(sources[i])) {
                match[ix] = i;
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i<S.length();) {
            if(match[i] >= 0) {
                stringBuffer.append(targets[match[i]]);
                i+= sources[match[i]].length();
            }else {
                stringBuffer.append(S.charAt(i++));
            }
        }

        return stringBuffer.toString();






//        int N = S.length();
//        int[] match = new int[N];
//        Arrays.fill(match, -1);
//
//        for (int i = 0; i < indexes.length; ++i) {
//            int ix = indexes[i];
//            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
//                match[ix] = i;
//        }
//
//        StringBuilder ans = new StringBuilder();
//        int ix = 0;
//        while (ix < N) {
//            if (match[ix] >= 0) {
//                ans.append(targets[match[ix]]);
//                ix += sources[match[ix]].length();
//            } else {
//                ans.append(S.charAt(ix++));
//            }
//        }
//        return ans.toString();
    }
}
