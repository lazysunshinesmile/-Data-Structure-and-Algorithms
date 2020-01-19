package com.sun.sort.algorithm;

import java.util.Arrays;

public class InsertSort implements SortAlgorithm{
    /**
     * 这个算法就是，拿第一层循环的那个值，也就是要排序的那个值，
     * 与前面的数对比（假设前面的数都是已经排好序的）。如果这个值小，
     * 就把那个数向后挪一位，因为前面是排序好的。如果这个值比较大，
     * 退出第二层循环，把这个数放到最后比较的这个数的后面。
     * 1,3,4,7,9,5,8,10;现在循环到了5也就是toSort=5,
     * 然后依次往前比较，9比5大，9向后挪一位覆盖5，同理7也是。
     * 到了4（j==3）5比4大，所以5放在4的后面（j==4）的位置。
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {

        for(int i = 1; i <array.length; i++) {
            int toSort = array[i];
            int j = i - 1;
            for(; j >=0;j--){

                if(toSort < array[j]) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j + 1] = toSort;
        }

        return array;
    }
}
