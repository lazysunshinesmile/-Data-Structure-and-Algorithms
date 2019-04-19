package com.xiangsun.binaryheap;

import java.nio.BufferUnderflowException;
import java.util.Arrays;

public class BinaryHeap<E extends Comparable> {
    private E[] array;
    private int currentSize;


    public BinaryHeap(E[] array) {
        this.array = array;
        currentSize = array.length -1;
    }

    public E[] getElement() {
        return array;
    }


    public E deleteMin() {
        if(array == null) {
            throw new BufferUnderflowException();
        }

        E minItem = array[1];
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    private void percolateDown(int hole) {
        int child;
        E tmp = array[hole];

        for(;hole *2 <currentSize; hole = child) {
            child = hole * 2;
            if(child != currentSize &&
                    array[child +1].compareTo(array[child]) < 0) {
                child++;
            }
            if(array[child].compareTo(tmp)<0) {
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }
    private void percolateDown2(int hole) {


        for(int i = hole; i*2 < currentSize;i*=2) {
            int child = i * 2;
            int parent = i;
            if (child < currentSize &&
                    array[child].compareTo(array[child + 1]) > 0) {
                child++;
            }
            array[parent] = array[child];
        }
        array[hole]
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
