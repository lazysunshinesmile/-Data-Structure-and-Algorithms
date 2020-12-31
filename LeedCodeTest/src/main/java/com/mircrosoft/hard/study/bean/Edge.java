package com.mircrosoft.hard.study.bean;

public class Edge {
    public int start;
    public int end;
    public int quan;

    public Edge() {
    }

    public Edge(int start, int end, int quan) {
        this.start = start;
        this.end = end;
        this.quan = quan;
    }

    @Override
    public String toString() {
        return "start:" + start + ", end:" + end + ", quan:" + quan;
    }
}
