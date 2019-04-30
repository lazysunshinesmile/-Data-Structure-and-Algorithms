package com.sun.sort.algorithm;

import java.util.List;

public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord(""));
    }

    public int lengthOfLastWord(String s) {
//        if(s.charAt(s.length()-1) == ' ') {
//            return 0;
//        }
        int k = s.length()-1;

        while(k >= 0 &&s.charAt(k) == ' ') {
            k--;
        }
        if(k == -1) {
            return 0;
        }
        for(int i = k; i>=0;i--) {
            if(s.charAt(i)==' ') {
                return k - i;
            }
        }
        return k+1;


    }
}
