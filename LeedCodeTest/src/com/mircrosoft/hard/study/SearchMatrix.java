package com.mircrosoft.hard.study;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; //行
        int line = matrix[0].length; //列
        if(target < matrix[0][0]) {
            return false;
        }
        if(target > matrix[row-1][line-1]) {
            return false;
        }
        for(int i=0; i<row;i++) {
            if(matrix[i][0] <= target && matrix[i][line-1] >= target) {
                for(int j=0; j<line; j++) {
                    if(matrix[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
