package com.sun.sort.algorithm;

import java.text.SimpleDateFormat;

public class SingleTon {
    private static SingleTon singleTon;
    private SingleTon() {

    }

    public static SingleTon getInstance() {
        if(singleTon == null) {
            synchronized (SingleTon.class) {
                if(singleTon == null) {
                    System.out.println("new yige");
                    singleTon = new SingleTon();
                }else {
                    System.out.println("old1");

                }
            }
        } else {
            System.out.println("old2");
        }

        return singleTon;
    }

}

