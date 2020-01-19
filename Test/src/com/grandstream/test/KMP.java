package com.grandstream.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class KMP {


    public static void main(String[] args) {
        String ss = "你好";
        try {
            String sr = new String(ss.getBytes(), "Shift-JIS");
            System.out.println(sr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
