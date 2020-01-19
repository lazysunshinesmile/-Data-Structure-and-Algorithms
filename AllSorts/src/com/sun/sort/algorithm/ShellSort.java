package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

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
//    将上述四行数字，依序接在一起时我们得到：[ 10 14 73 25 23 13 27 94 33 39 25 59 94 65 82 45 ].
//    这时10已经移至正确位置了，然后再以3为步长进行排序：
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

    public static void main(String[] args) {
//        ShellSort shellSort = new ShellSort();
//        System.out.println(Arrays.toString(shellSort.sort(new int[]{13,14,94,33,82,25,59,94,65,23,45,27,73,25,100,10,})));

//        Hashtable<String, String> phone = new Hashtable<>();
//        String key = "2";
//        phone.put("1","");
//        phone.put("2", "strr");
//        phone.put("3", "sfds");
//        System.out.println(phone);
//        System.out.println(phone.get(key));
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(12);
        a1.add(14);
        ArrayList<Integer> a2 = new ArrayList<>(a1);
        a1.add(15);

        if(a1.equals(a2)) {
            System.out.println("xaing");
        }else {
            System.out.println("no");
        }

    }
    @Override
    public int[] sort(int[] array) {
        for(int step=(array.length-1)/2; step >=1;step/=2) {
            //step 步长
            //下面插入排序,参考insertSort
            for(int i=step;i<array.length;i+=step) {
                int toSort = array[i];
                //从当列的前一个数开始与toSort比较，比toSort大就往后挪一位，小就退出循环，并把toSort放在这个数的后面
                int k = i-step;
                for(;k>=0;k-=step) {
                    if(array[k] >toSort) {
                        array[k+step] = array[k];
                    }else {
                        break;
                    }
                }
                //toSort比array[k]大，所以放在array[k+step]中
                array[k+step] = toSort;
            }
        }
        return array;
    }
}
