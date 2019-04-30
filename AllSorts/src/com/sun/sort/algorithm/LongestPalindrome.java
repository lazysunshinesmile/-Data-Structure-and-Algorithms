package com.sun.sort.algorithm;

import java.util.Arrays;

public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome2("babad"));
    }

    public String longestPalindrome(String str) {
        if(str.length() == 0) {
            return "";
        }
        // 1.构造新的字符串

        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文

        StringBuilder newStr = new StringBuilder();

        newStr.append('#');

        for (int i = 0; i < str.length(); i++) {

            newStr.append(str.charAt(i));

            newStr.append('#');

        }

        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身

        int[] rad = new int[newStr.length()];

        // right表示已知的回文中，最右的边界的坐标

        int right = -1;

        // id表示已知的回文中，拥有最右边界的回文的中点坐标

        int id = -1;

        // 2.计算所有的rad

        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。

        for (int i = 0; i < newStr.length(); i++) {

            // 2.1.确定一个最小的半径

            int r = 1;

            if (i <= right) {

                r = Math.min(rad[id] - i + id, rad[2 * id - i]);

            }

            // 2.2.尝试更大的半径

            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {

                r++;

            }

            // 2.3.更新边界和回文中心坐标

            if (i + r - 1 > right) {

                right = i + r - 1;

                id = i;

            }

            rad[i] = r;

        }

        // 3.扫描一遍rad数组，找出最大的半径

        int maxLength = 0;
        int centerIndex = 0;
        for (int i = 0;i<rad.length;i++) {

            if (rad[i] > maxLength) {
                maxLength = rad[i];
                centerIndex = i;
            }

        }

        return str.substring((centerIndex - maxLength + 2)/2, (centerIndex +maxLength-2)/2 + 1);

    }

    public String longestPalindrome2(String str) {
        if(str.length() == 0) {
            return "";
        }

//        先转换
        char[] str2 = preProcess(str);

        //回文字符串到达的最右边界
        int right = 0;
        //到达最右边界回文字符串的中心。
        int center = 0;

        int[] rad = new int[str2.length];
        rad[0] = 1;



        for(int i = 1; i<rad.length;i++) {
//            半径长
            int r = 1;
            int k= i - center;

            if(i < right) {
                rad[i] = Math.min(rad[i-k] -k, rad[i - 2*k]);
            }

//            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
            //超出right的长度
//            int N = 1;
            while(i+r < str2.length && i-r >= 0 && str2[i+r] == str2[i-r]) {
                r++;
            }


            rad[i] = r;
            if(i + r > right) {
                right = i + r;
                center = i;
            }
        }


        int maxCenter = 0;
        int maxRad = 0;
        for(int i = 0; i<str2.length;i++) {
            if(rad[i]>maxRad) {
                maxRad = rad[i];
                maxCenter = i;
            }
        }

        return str.substring((maxCenter - maxRad + 2)/2 , (maxCenter + maxRad)/2);

    }


    //插入字符使得统一都为奇数长度，"aaa"=>#a#a#a#
    public char[] preProcess(String str) {
        StringBuffer ret = new StringBuffer();
        for(int i = 0; i<str.length();i++) {
            ret.append("#").append(str.charAt(i));
        }
        ret.append("#");
        return ret.toString().toCharArray();
    }
}
