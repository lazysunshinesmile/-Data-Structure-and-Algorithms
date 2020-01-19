package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permu {
    public static void main(String[] args) {
        Permu permu = new Permu();
        String ss = "abcd";
        List<String> l = new ArrayList<>();
        permu.permu(ss.toCharArray(), 0, l);
        System.out.println(l.size());

    }

    public void permu(char[] chars, int i, List<String> list) {
        if(i == chars.length -1 ) {
            list.add(Arrays.toString(chars));
            return;
        }

        for(int j = i; j<chars.length;j++) {
            swap(chars, i, j);
            permu(chars, i+1,list);
            swap(chars, j,i);
        }
        return;
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
