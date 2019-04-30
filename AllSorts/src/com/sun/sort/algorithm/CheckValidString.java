package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CheckValidString {
    public static void main(String[] args) {
        CheckValidString checkValidString = new CheckValidString();
        System.out.println(checkValidString.checkValidString("("));
//        System.out.println(checkValidString.checkValidString("((()))()(())(*()()())**(())()()()()((*()*))((*()*)"));
    }
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for(int i = 0; i< s.length();i++) {
            Character c = s.charAt(i);
            if(c == '(') {
                low++;
                high++;
            }else if(c == '*') {
                if(low > 0) {
                    low--;
                }
                high++;
            }else {
                if(low > 0) {
                    low--;
                }
                high--;
            }
            if(high < 0) {
                return false;
            }
        }
        return low == 0;




    }
}
