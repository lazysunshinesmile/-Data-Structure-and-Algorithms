package com.sun.sort.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUse {
    public static void main(String[] args) {
        String origin = "3113";

        String oldRegex = "{<3=011>x+}";
        String regularExpression = numberRegixToRegularExpression(oldRegex);
        System.out.println(oldRegex);
        System.out.println(regularExpression);
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(origin);
        String kk = matcher.replaceAll("");
        System.out.println(kk);



    }



    /*
    * 设置话机所接受的号码范围或者实现快捷缩位拨号等。其语法规则如下：
        1.有效值
        1,2,3,4,5,6,7,8,9,0,*,#,T；
        2.拨号规则
        •xx - 表示任何两位 0-9 的数字；								n位的数字：^\d{2}$
        •xx+ - 表示至少任何两位 0-9 的数字；					 至少n位的数字：^\d{2,}$
        • xx. - 表示至少任何一位 0-9 的数字；						^\d{1,}$
        • xx? – 表示一或者两位 0-9 的数字；							m-n位的数字：^\d{m,n}$  ^\d{1,2}$
        • ^ - 拒绝；
        • T - 匹配后延时呼出；
        • [3-5] – 拨数字 3, 4, 或者 5；							[3-5]
        • [147] – 拨数字 1, 4, 或者 7；							[147]
        • <2=011> - 当拨号数字为 2 的时候将替换为 011；				2
        • 设置 {x+} 允许所有的数字号码呼出。							^[0-9]*$
        2.实例
        例一: {[369]11 | 1617xxxxxx} – 允许 311, 611, 911, 任何 10 位数字开始为1617的呼叫出去；
        例二: {^1900x+ | <=1617>xxxxxxx} – 将拒绝拨打号码为 1900 头的号码，与拨打任何7位数增加前缀1617。

    * */

    public static String numberRegixToRegularExpression(String oldRegex){
        String oldRegex2 = oldRegex;
        oldRegex2 = oldRegex2.substring(1,oldRegex2.length() -1);
        oldRegex2 = oldRegex2.replace("xx+", "\\d{2,}");
        oldRegex2 = oldRegex2.replace("x+", "\\d{1,}");
        oldRegex2 = oldRegex2.replace("xx.", "\\d{1,}");
        oldRegex2 = oldRegex2.replace("xx?", "\\d{1,2}");
        oldRegex2 = oldRegex2.replace("xx", "\\d{2}");
        while(oldRegex2.contains("<") && oldRegex2.contains(">") && oldRegex2.contains("=")) {
            int start = oldRegex2.indexOf("<");
            int end = oldRegex2.indexOf(">");
            String toRepalce = oldRegex2.substring(start, end +1);
            String repalceRegex = oldRegex2.substring(start+1, end);
            String[] strings = repalceRegex.split("=");
            oldRegex2 = oldRegex2.replace(toRepalce, strings[0]);
        }
        oldRegex2 = "^" + oldRegex2 + "$";
        return oldRegex2;
    }
}
