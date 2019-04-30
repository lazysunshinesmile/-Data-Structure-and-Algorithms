package com.sun.sort.algorithm;

public class IntealeavtingString {
    public static void main(String[] args) {
        IntealeavtingString intealeavtingString = new IntealeavtingString();
        System.out.println(intealeavtingString.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] ans = new boolean[s1.length() + 1][s2.length() + 1];
        for( int i = 0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                if(i==0 && j ==0) {
                    ans[i][j] = true;
                }else if(i == 0) {
                    ans[i][j] = ans[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j -1);
                }else if(j ==0) {
                    ans[i][j] = ans[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j -1);
                }else {
                    ans[i][j] =  (ans[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j -1)) || ( ans[i -1][j] && s1.charAt(i-1) == s3.charAt(i+j -1));
                }
            }
        }
        return ans[s1.length()][s2.length()];
    }


}

