package com.sun.sort.algorithm;

public class Convert {
    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.convert("PAYPALISHIRING", 3));
    }
    public String convert(String s, int numRows) {
        StringBuffer[] ret  = new StringBuffer[numRows];
        for(int j = 0;j<numRows;j++) {
            ret[j] = new StringBuffer();
        }
        int i = 0;

        while(i <s.length()) {
            for(int m = 0; m<numRows && i <s.length();m++) {
                ret[m].append(s.charAt(i++));
            }
            for(int m = numRows-2; m > 0 && i < s.length(); m--) {
                ret[m].append(s.charAt(i++));
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int j = 0;j<numRows;j++) {
            ans.append(ret[j]);
        }

        return  ans.toString();


    }
}
