package com.sun.sort.algorithm;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()()";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.lengthOfLongestSubstring("pwwkew"));
    }

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;

    }

    public int lengthOfLongestSubstring(String s) {
        int[] all = new int[128];
        int ret = 0;
        //i是start, j 是end
        for(int i=0, j=0; j < s.length();j++) {
            i = Math.max(i, all[s.charAt(j)]);
            ret = Math.max(ret, j - i+1);
            all[s.charAt(j)] = j + 1;
        }

        return ret;
    }

}
