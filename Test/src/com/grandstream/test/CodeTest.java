package com.grandstream.test;

import java.io.*;

public class CodeTest {
    public static void main(String[] args) {
        CodeTest codeTest = new CodeTest();
        try {
            codeTest.getUtf16String("/home/Sun/workspace/my_workspace_java/Data Structure and Algorithms/Test/src/com/grandstream/test/phonebook-utf-16.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //16
    private void getUtf16String(String filePath) throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;


        fileInputStream = new FileInputStream(new File(filePath));
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-16"));

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }


    }
}
