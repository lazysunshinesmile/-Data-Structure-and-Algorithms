package com.sun.sort.algorithm;

public class RoateImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        RoateImage roateImage = new RoateImage();
        roateImage.rotate(matrix);
        for(int i = 0; i<3;i++) {
            for (int j =0; j<3;j++) {
                System.out.println(matrix[i][j]);
            }
        }

    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[][] ret = new int[len][len];
        for(int row=0; row<len;row++) {
            for(int col=0; col<len;col++) {
                ret[col][len -1 -row]=matrix[row][col];
            }
        }
        for(int row=0; row<len;row++) {
            for(int col=0; col<len;col++) {
                matrix[row][col]=ret[row][col];
            }
        }
    }
}
