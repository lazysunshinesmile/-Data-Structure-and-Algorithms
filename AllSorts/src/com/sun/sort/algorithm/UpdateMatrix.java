package com.sun.sort.algorithm;

import java.util.Arrays;
import java.util.Map;

public class UpdateMatrix {


    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
//        [[0,1,0],[0,1,0],[0,1,0],[0,1,0],[0,1,0]]
        int[][] answer = updateMatrix.updateMatrix(new int[][]{{0},{1}});
//[[1,0,1,1,0,0,1,0,0,1],[0,1,1,0,1,0,1,0,1,1],[0,0,1,0,1,0,0,1,0,0],[1,0,1,0,1,1,1,1,1,1],[0,1,0,1,1,0,0,0,0,1],[0,0,1,0,1,1,1,0,1,0],[0,1,0,1,0,1,0,0,1,1],[1,0,0,0,1,1,1,1,0,1],[1,1,1,1,1,1,1,0,1,0],[1,1,1,1,0,1,0,0,1,1]]
//        int[][] answer = updateMatrix.updateMatrix(new int[][]
//                {{1,0,1,1,0,0,1,0,0,1},
//                        {0,1,1,0,1,0,1,0,1,1},
//                        {0,0,1,0,1,0,0,1,0,0},
//                        {1,0,1,0,1,1,1,1,1,1},
//                        {0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}});

        for(int i = 0; i < answer.length;i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j]);
            }
        }
    }

    /**
     *  自己想的算法，超时
     * @param matrix 原数组
     */
    public int[][] updateMatrix2(int[][] matrix) {

        int[][] ret = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++) {
            Arrays.fill(ret[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i<matrix.length; i++) {
            for(int j =0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0) {
                    insertOneEle(matrix, ret, i, j, 0);
//                    break;
                }
            }
        }
        return ret;

    }

    /**
     *
     * @param matrix 原数组
     * @param ret   返回的集合
     * @param row   行
     * @param line  列
     * @param k     需要填的数
     * @return
     */
    public int[][] insertOneEle(int[][] matrix, int[][] ret, int row,int line, int k) {
        if(ret[row][line] > k) {
            ret[row][line] = k;
        }else{
            return ret;
        }

        int rowEnd = matrix.length;
        int lineEnd = matrix[0].length;

//        某一个空格被填了
        if(row - 1>= 0 && ret[row -1][line] >k+1) {

            insertOneEle(matrix, ret, row-1, line, k+1);
            ret[row -1][line] = k+1;
        }
        if(line - 1>= 0 && ret[row][line-1] >k+1) {
            insertOneEle(matrix, ret, row, line-1,k+1);
            ret[row][line-1] = k+1;

        }
        if(row + 1 < rowEnd && ret[row +1][line] >k+1) {
            insertOneEle(matrix, ret, row+1, line,k+1);
            ret[row+1][line] = k+1;
        }
        if(line + 1 < lineEnd && ret[row][line+1] >k+1) {
            insertOneEle(matrix, ret, row, line+1,k+1);
            ret[row][line +1] = k+1;

        }



        return ret;
    }

    /**
     * 标准答案
     * @param matrix
     * @return
     */
    public int[][] updateMatrix3(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return matrix;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        for(int i = 0; i < dist.length;i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE-10000;
            }
        }
        //First pass: check for left and top
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }

    /**
     * 自己看完答案重新编写。
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int rowEnd = matrix.length;
        int colEnd = matrix[0].length;
        int[][] ret = new int[rowEnd][colEnd];
        for(int i = 0; i<rowEnd;i++) {
            Arrays.fill(ret[i], rowEnd + colEnd +1);
        }

        //自上往下
        for(int i=0;i < rowEnd;i++) {
            for(int j = 0;j < colEnd;j++) {
                //两次循环中，第一次肯定要把0的路径值确定，并根据0的值，向右，向下赋值
                if(matrix[i][j ]== 0) {
                    ret[i][j] = 0;
                    continue;
                }

//                以要填的数为中心
                if(i - 1 >=0) {
                    ret[i][j] = Math.min(ret[i][j], ret[i-1][j] +1);
                }
                if(j - 1 >=0) {
                    ret[i][j] = Math.min(ret[i][j], ret[i][j -1] + 1);
                }
            }
        }

        //自下往上
        for(int i=rowEnd -1;i >=0;i--) {
            for(int j = colEnd -1;j >=0;j--) {
                //                以要填的数为中心
                if(i + 1 < rowEnd) {
                    ret[i][j] = Math.min(ret[i][j], ret[i+1][j] +1);
                }
                if(j+1 <colEnd) {
                    ret[i][j] = Math.min(ret[i][j], ret[i][j+1] + 1);
                }
            }
        }

        return ret;
    }



}
