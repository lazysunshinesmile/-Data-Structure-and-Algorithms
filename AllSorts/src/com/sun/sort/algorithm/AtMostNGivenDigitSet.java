package com.sun.sort.algorithm;

public class AtMostNGivenDigitSet {
    public static void main(String[] args) {
        AtMostNGivenDigitSet atMostNGivenDigitSet = new AtMostNGivenDigitSet();
        System.out.println(atMostNGivenDigitSet.atMostNGivenDigitSet( new String[]{"1","3","5","7"}, 100));
    }


    public int atMostNGivenDigitSet(String[] D, int N) {
        int[] Dint = new int[D.length];
        int len = (N+"").length() -1;

        for(int i = 0; i<D.length;i++) {
            Dint[i] = Integer.parseInt(D[i]);
        }

        int[] Nint = new int[(N + "").length()];
        int k = len;
        while(k >= 0) {
            int meiyige = N % 10;
            Nint[k] = meiyige;
            k--;
            N/=10;
        }

        int[] ltNint = new int[len + 1];

        for(int i = 0; i<=len; i++) {
            int j = 0;
            for(; j<D.length; j++) {
                if(Dint[j] > Nint[i]) {
                    break;
                }
            }
            ltNint[i] = j;
        }

        int ret = 0;
        //位数小于Ｎ的先算出来
        int z = 1;
        while(z < len+1) {
            ret += Math.pow(D.length,z++);
        }

        //位数和Ｎ一样的,且最高位相等
        if(ltNint[0] < 1) {
            return ret;
        }
        if(Dint[ltNint[0]-1] == Nint[0]) {
            ret += (ltNint[0] -1)*Math.pow(D.length, Nint.length-1);
        }else {
            //位数和Ｎ　一样的，且最高位小了.
            ret += (ltNint[0])*Math.pow(D.length, Nint.length-1);
        }




        return ret;

    }
}
