package com.sun.sort.algorithm;

import java.util.Arrays;

public class ShellSort implements SortAlgorithm {


//    例如，假设有这样一组数[ 13 14 94 33 82 25 59 94 65 23 45 27 73 25 39 10 ]，如果我们以步长为5开始进行排序，我们可以通过将这列表放在有5列的表中来更好地描述算法，这样他们就应该看起来是这样：
//
//            13 14 94 33 82
//            25 59 94 65 23
//            45 27 73 25 39
//            10
//    然后我们对每列进行排序：
//
//            10 14 73 25 23
//            13 27 94 33 39
//            25 59 94 65 82
//            45
//    将上述四行数字，依序接在一起时我们得到：[ 10 14 73 25 23 13 27 94 33 39 25 59 94 65 82 45 ].这时10已经移至正确位置了，然后再以3为步长进行排序：
//
//            10 14 73
//            25 23 13
//            27 94 33
//            39 25 59
//            94 65 82
//            45
//    排序之后变为：
//
//            10 14 13
//            25 23 33
//            27 25 59
//            39 65 73
//            45 94 82
//            94
//    最后以1步长进行排序（此时就是简单的插入排序了）。
    @Override
    public int[] sort(int[] array) {
        for(int step = (array.length -1)/2; step>=1;step/=2 ){
            //下面是插入排序
            for(int i = step; i < array.length; i+=step) {
                int toSort = array[i];
                int j = i - step;
                for(; j >=0;j-=step){

                    if(toSort < array[j]) {
                        array[j+step] = array[j];
                    }else {
                        break;
                    }
                }
                array[j + step] = toSort;
            }
            System.out.println(Arrays.toString(array));

        }
        return array;
    }
}
