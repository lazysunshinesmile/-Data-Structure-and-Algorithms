package com.sun.sort.algorithm;

import java.util.Arrays;

public class BinaryHeap<E extends Comparable> {
    private static int DEFAULT_CAPACITY = 14;

    //但前数量，也是最后一个数的下标。
    private int currentSize;
    private E[] array;

    public BinaryHeap() {
        currentSize = 0;
        array = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public BinaryHeap<E> insert(E toInsert) {
        if(currentSize > DEFAULT_CAPACITY) {
            expand();
        }

        //必须是++currentSize 如果插入的刚好是最大的数，
        // 那么比较了第一个就会退出循环执行array[i] = toInsert;
        //如果i = currentSize++;那么就会把这个最大的数顶替掉最后一个数。
        int i = ++currentSize;
        for(array[0] = toInsert; toInsert.compareTo(array[i/2]) < 0; i/=2 ) {
            array[i] = array[i/2];
        }
        array[i] = toInsert;
        return this;

    }

    public BinaryHeap<E> deleteMin() {
        int i = ++currentSize;
        for(i = 1; i<= currentSize /2; i*=2) {
            if(array[i*2].compareTo(array[i*2+1]) < 0) {
                array[i] = array[i*2];
            } else {
                array[i] = array[i*2 +1];
            }
        }

        return this;
    }

    private void expand() {
        DEFAULT_CAPACITY *= 2;
        E[] array2 = (E[]) new Comparable[DEFAULT_CAPACITY];
        for(int i = 0; i< array.length; i++) {
            array2[i] = array[i];
        }
        array = array2;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
