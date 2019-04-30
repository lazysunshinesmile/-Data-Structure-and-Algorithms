package com.sun.sort.algorithm;

public class PrimePalindrome {

    public static void main(String[] args) {
//        PrimePalindrome primePalindrome = new PrimePalindrome();
//        System.out.println(primePalindrome.primePalindrome2(9));
        System.out.println(100_000_000);
    }
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }

    public int primePalindrome2(int N) {
        while (true) {
            if (N == reverse(N) && isPrime2(N))
                return N;
            N++;
            if (10_000_000 < N && N < 100_000_000)
                N = 100_000_000;
        }
    }

    public boolean isPrime2(int N) {
        if (N < 2 || N %2 ==0) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 3; d <= R; d+=2)
            if (N % d == 0) return false;
        return true;
    }

    public int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }
}
