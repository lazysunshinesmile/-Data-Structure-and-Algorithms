package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy(19));
    }

    public boolean isHappy(int n) {
//        List<Integer> hasAppearedNum = new ArrayList<>();
//        hasAppearedNum.add(3);
//        hasAppearedNum.add(4);
//        hasAppearedNum.add(5);
//        hasAppearedNum.add(6);
//        hasAppearedNum.add(8);
//        hasAppearedNum.add(9);

        while(true) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1 || sum == 7) {
                return true;
            } else if (sum == 3 || sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9) {
                return false;

            }   else {
                n = sum;
            }
        }
    }
}
