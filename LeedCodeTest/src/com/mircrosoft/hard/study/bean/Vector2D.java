package com.mircrosoft.hard.study.bean;

public class Vector2D {
    private int out = 0;
    private int in = 0;
    private int[][] v;
    private boolean hasNext = true;
    public Vector2D(int[][] v) {
        this.v = v;
        jumpEmpty();
    }

    private void jumpEmpty() {
        for(int i=out; i<v.length; i++) {
            if(in < v[i].length) {
                out = i;
                // System.out.println(out);
                return;
            } else {
                in = 0;
            }
        }
        hasNext = false;
    }

    public int next() {
        jumpEmpty();
        return v[out][in++];
    }

    public boolean hasNext() {
        jumpEmpty();
        return hasNext;
    }


//16ms
    // private LinkedList<Integer> lists;
    // private Iterator<Integer> mIterator;
    // public Vector2D(int[][] v) {
    //     lists = new LinkedList<>();
    //     for(int i=0; i<v.length; i++) {
    //         for(int j=0; j<v[i].length; j++) {
    //             lists.add(v[i][j]);
    //         }

    //     }

    //     mIterator = lists.iterator();
    // }

    // public int next() {
    //     return mIterator.next();

    // }

    // public boolean hasNext() {
    //     return mIterator.hasNext();
    // }
}
