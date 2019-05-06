package com.sun.sort.algorithm;

public class FirstBadVersion {
//    2126753390
//            1702766719

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }
    public int firstBadVersion(int n) {
        int maxFalse = 0;//low
        int minTrue = n;//high
        int mid = maxFalse + (minTrue - maxFalse)/2;
        while(maxFalse < minTrue) {
            boolean b = isBadVersion(mid);
            if(b) {
                minTrue = mid;
            }else {
                maxFalse = mid + 1;
            }
            mid = maxFalse + (minTrue - maxFalse)/2;
        }
        return mid;
    }

    public boolean isBadVersion(int n ) {
        if(n >= 1702766719) {
            return true;
        }
        else {
            return false;
        }
    }
}
