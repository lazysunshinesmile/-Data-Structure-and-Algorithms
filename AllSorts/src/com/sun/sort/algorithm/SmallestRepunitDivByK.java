package com.sun.sort.algorithm;

import java.math.BigInteger;

public class SmallestRepunitDivByK {

    public static void main(String[] args) {
        SmallestRepunitDivByK smallestRepunitDivByK = new SmallestRepunitDivByK();
        System.out.println(smallestRepunitDivByK.smallestRepunitDivByK(21));

//        System.out.println(111111%17);
    }
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }

        int i = 0;
        int count = 0;
        while (i <= K) {
            //自己做一做手动除法
            i = (i * 10 + 1) % K;
            count++;

            if (i == 0) {
                return count;
            }
        }
        return -1;
    }
}
