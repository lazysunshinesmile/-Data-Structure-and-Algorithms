package com.xiangsun.binaryheap;

public class MainTest {
    public static void main(String[] args) {
        Integer[] integer = new Integer[]{null, 13, 14, 16,19,21,20,68,65,26,32};

        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(integer);

        System.out.println(binaryHeap);

        binaryHeap.deleteMin();

        System.out.println(binaryHeap);
    }

}
