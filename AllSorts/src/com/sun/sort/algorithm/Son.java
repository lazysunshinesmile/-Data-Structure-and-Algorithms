package com.sun.sort.algorithm;

import com.sun.jndi.toolkit.url.UrlUtil;

import javax.print.DocFlavor;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Son extends Parent {

    public static void main(String[] args) {
//        Son parent = new Son();
//        String name = parent.getName();
//        System.out.println(name);
//
//        String[] ss = new String[] {"aa","nbb"};
//        System.out.println(Arrays.toString(ss));
//        String ss2 = Arrays.toString(ss);
//        System.out.println(ss2.substring(1, ss2.length()-1));

//        System.out.println(Calendar.getInstance().getTimeInMillis());
//        long time = 1567130312554L;
//
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//
//        Calendar calendar1 = Calendar.getInstance();
//        System.out.println(simpleDateFormat.format(calendar1.getTime()));
//
//
//        Calendar calendar = Calendar.getInstance(Locale.CANADA);
//        calendar.setTimeInMillis(System.currentTimeMillis());
//
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
//
//        calendar = Calendar.getInstance(Locale.JAPAN);
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        System.out.println(simpleDateFormat.format(calendar.getTime()));
//        String ss = "192.168.132.45/fjslkd.java";
//        File file = new File(ss);
//        System.out.println(file.isDirectory());
//        System.out.println(file.isFile());
//
//
//        try {
//            String ss = UrlUtil.decode("192.168.132.45/fjslkd.java");
//            System.out.println(ss);
//        }catch (Exception e) {
//            System.out.println("wrong");
//        }

//        Son son = new Son();
//        son.containsFile();
        try {
            String ss = null;
            ss.length();
        }catch (Exception e) {
            System.out.println("e");
        }
        finally {
            System.out.println("over");
        }
    }


    @Override
    public String getCommonName() {
        return "son";
    }


    public void containsFile() {

        String[] mm = new String[]{"http://ww.bai.ciom",
                "https://192.168.123.12/hdjfk.jjj",
                "ftp://192.168.123.12/hdjfk.jjj",
                "https://192.168.123.12/",
                "https://192.168.123.12",
                "http://www.baidu.com/sjfk/",
                "http://www.baidu.com/sjfk",
                "http://www.baidu.com",
                "http://www.baidu.com/",
                "ftp://www.baidu.com/",
                "ftp://www.Baidu.com/",
                "www.baidu.com/sjfk/",
                "www.baidu.com/sjfk",
                "www.baidu.com/sjfk.phone",
                "www.baidu.com",
                "www.baidu.com/",
                "192.168.163.112",
                "192.168.163.112/",
                "192.168.132.123/sdf.jk",
                "192.168.132.123/.jk",
                "192.168.132.123/sdf",
                "192.168.132.123/sdf/"};

        for (int i = 0; i < mm.length; i++) {
            String url = mm[i];
            if (containsFile(url)) {
                System.out.println(url);
            } else {
                if(url.endsWith("/")) {
                    url += "phonebook.xml";
                } else {
                    url += "/phonebook.xml";

                }
                System.out.println(url);
            }

            //            System.out.println();
        }


    }

    public boolean containsFile(String url) {
        if (url == null || "".equals(url)) {
            return false;
        }
        url = url.toLowerCase();
        if(!url.startsWith("http") && !url.startsWith("ftp")) {
            url = "http://" + url;
        }
        try {

            URL url1 = new URL(url);
            String path = url1.getPath();
            if (path == null || "".equals(path)) {
                return false;
            }

            Pattern p = Pattern.compile("(\\w+\\.\\w+)$");
            Matcher m = p.matcher(url);
            return m.find();
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }

    }
}