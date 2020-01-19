package com.sun.sort.algorithm;

public class SmallestRepunDevideByK {
    public static void main(String[] args) {
        SmallestRepunDevideByK smallestRepunDevideByK = new SmallestRepunDevideByK();
        int m = 1;
        while(m < 100000000) {
            if(m %5 ==0) {
                m+=2;
                continue;
            }
            System.out.println(smallestRepunDevideByK.smallestRepunitDivByK(m));
            m+=2;
        }

        System.out.println(smallestRepunDevideByK.smallestRepunitDivByK(31));
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
        System.out.println("K = " +K);
        return -1;
    }



}
