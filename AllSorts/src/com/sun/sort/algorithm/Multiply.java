package com.sun.sort.algorithm;

import java.math.BigInteger;

public class Multiply {
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("6913259244",
                "71103343"));
    }
    public String multiply(String num1, String num2) {
        BigInteger n1 = new BigInteger(num1);
        BigInteger n2 = new BigInteger(num2);
        return n1.multiply(n2).toString();
//        int n1 = Integer.parseInt(num1);
//        int n2 = Integer.parseInt(num2);
//        return n1*n2 + "";
    }
}
