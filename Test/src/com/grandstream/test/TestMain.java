package com.grandstream.test;

public class TestMain {
    public static void main(String[] args) {
        int m = Integer.MAX_VALUE;
        int[][] adjacencyMatrix = new int[][] {
                {0,10,m,m,m,11,m,m,m},
                {10,0,18,m,m,m,16,m,12},
                {m,18,0,22,m,m,m,m,8},
                {m,m,22,0,20,m,m,16,21},
                {m,m,m,20,0,26,m,7,m},
                {11,m,m,m,26,0,17,m,m},
                {m,16,m,m,m,17,0,19,m},
                {m,m,m,16,7,m,19,0,m},
                {m,12,8,21,m,m,m,m,0}
        };
        Prim prim = new Prim(adjacencyMatrix);
        prim.getMethod();
    }
}
