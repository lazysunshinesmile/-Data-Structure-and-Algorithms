package com.mircrosoft.hard.study;

public class NumMatrix {
    private int row = 0;
    private int line = 0;
    private int[][] horizicalSum;
    // private int[][] verticalSum;
    private int[][] matrix;
    private boolean isnull = false;


    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 ) {
            isnull = true;
            return;
        }
        row = matrix.length;
        line = matrix[0].length;
        horizicalSum = new int[row][line];
        // verticalSum = new int[row][line];
        for(int i=0; i<line; i++) {
            for(int j=0; j<row; j++) {
                horizicalSum[j][i] = (i-1 < 0?0:horizicalSum[j][i-1]) + matrix[j][i];
            }
        }

        // for(int i=0; i<row; i++) {
        //     for(int j=0; j<line; j++) {
        //        verticalSum[i][j] = i-1 < 0?0:verticalSum[i-1][j] + matrix[i][j];
        //     }
        // }
    }

    public void update(int row, int col, int val) {
        if(isnull) {
            return;
        }
        int add = val - matrix[row][col];
        // for(int i=row; i<this.row; i++) {
        //     verticalSum[i][col] += add;
        // }
        matrix[row][col] = val;
        for(int i=col; i<this.line; i++) {
            horizicalSum[row][i] += add;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(isnull) {
            return 0;
        }
        int ret = 0;
        for(int i=row1; i<=row2; i++) {
            ret = ret + horizicalSum[i][col2] - horizicalSum[i][col1] + matrix[i][col1];
        }

        return ret;
    }
}
