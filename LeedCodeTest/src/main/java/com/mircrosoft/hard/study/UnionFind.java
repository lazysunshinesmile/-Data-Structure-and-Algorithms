package com.mircrosoft.hard.study;

import java.util.Arrays;

public class UnionFind {
    int[] parent;
    int[] rank;
    UnionFind(int m) {
        parent = new int[m];
        rank = new int[m];
        Arrays.fill(parent, -1);
    }

    /**
     *
     * @param i 一个树
     * @param j 另一个树
     * @return 是否合并了
     */
    public boolean add(int i, int j) {
        int a = getParent(i);
        int b = getParent(j);
        if(a != b) {
            if(rank[a] > rank[b]) {
                parent[b] = a;
            } else if(rank[a] < rank[b]) {
                parent[a] = b;
            } else {
                parent[a] = b;
                rank[b]++;
            }
        }
        return a != b;
    }

    private int getParent(int i) {
        while(parent[i] != -1) {
            i = parent[i];
        }
        return i;
    }
}
