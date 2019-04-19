package com.sun.sort.algorithm;

import java.util.Arrays;

public class MainTest {
    private static int[] array = new int[]{34,8,64,51,32,21};

    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = new InsertAlgorithm();

        array = sortAlgorithm.sort(array);

        System.out.println(Arrays.toString(array));
    }

}
