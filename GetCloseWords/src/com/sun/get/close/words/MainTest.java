package com.sun.get.close.words;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainTest {
    public static void main(String[] args) {
        Alogrithm alogrithm = new Alogrithm();
        List<String> ll = new ArrayList<>();

        Random sd = new Random();
        for(int i=0; i< 89000; i++) {
            ll.add(getRandomString(new Random().nextInt(12)));
        }



        long b=System.currentTimeMillis();
        Map<Object, List<String>> res2 = alogrithm.computeAdjacentWords(ll);

        System.out.println("\r<br> 他的算法执行耗时 : "+(System.currentTimeMillis()-b)/1000f+" 秒 ");

        long a=System.currentTimeMillis();

        Map<Object, List<String>> res = alogrithm.myComputeAdjacentWords(ll);
        System.out.println("\r<br> 我的算法执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");





////
//        for(Object str : res.keySet()) {
//            System.out.println(str + ":" +res.get(str));
//        }

        System.out.println(res.size());
        System.out.println(res2.size());
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }



}

//
//aua:[sua]
//        son:[sun]
//        sua:[aua, sun]
//        sun:[son, sua]

//son:[sun]
//        aua:[sua]
//        sun:[son, sua]
//        sua:[aua, sun]