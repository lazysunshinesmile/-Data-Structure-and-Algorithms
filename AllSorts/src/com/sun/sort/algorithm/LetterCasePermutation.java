package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
//        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
//        System.out.println(letterCasePermutation.letterCasePermutation("ss11"));


//        ArrayList<String> test = new ArrayList<>();
//        test.add("aaa");
//        test.add("aaa");
//        test.add("aaa");
//        test.add("aaa");
//        System.out.println(test.toString().substring(1, test.toString().length() -2));
//        String kk = "(sdfsdfsdf)";
//        System.out.println(kk.substring(1, kk.length() -1));
        ArrayList<String> ss = new ArrayList<>();
        ss.add("aaa");
        ss.add(null);
        ss.add(null);
        while(ss.contains(null)) {
            ss.remove(null);
        }

        Collections.sort(ss);

    }


    public List<String> letterCasePermutation(String str) {
        List<String> ret = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for(int i=0;i < str.length();i++) {
            char c = str.charAt(i);
            if((c > 'a' && c < 'z') ||(c >'A' && c <'Z')) {
                index.add(i);
            }
        }

        for(int i=0;i<index.size();i++) {
            int in = index.get(i);
            char c = str.charAt(in);
            String res1 = str.substring(0,in);
            String res2 = str.substring(in+1);
            if(c < 'z')
                ret.add(res1 + (""+ c).toUpperCase() + res2);
            if(c > 'A')
                ret.add(res1 + (""+ c).toLowerCase() + res2);
        }

        return ret;
    }
}

