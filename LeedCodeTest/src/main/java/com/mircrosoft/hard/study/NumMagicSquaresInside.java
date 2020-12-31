package com.mircrosoft.hard.study;

/**
 * 840（https://leetcode-cn.com/problems/magic-squares-in-grid/）
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 */
public class NumMagicSquaresInside {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i=1;i<grid.length-1;i++) {
            for(int j=1; j< grid.length -1;j++) {
                if(grid[i][j] == 5) {
                    if(checkRight(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;

    }

    //i,j分别表示5所在位置的坐标
    private boolean checkRight(int[][] grid, int i, int j) {
        if(grid[i-1][j-1] + grid[i+1][j+1] != 10
            || grid[i-1][j] + grid[i+1][j] != 10
            || grid[i-1][j+1] + grid[i+1][j-1] != 10
            || grid[i][j-1] + grid[i][j+1] != 10
            || grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] != 15 ||
                grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1] != 15 ||
                grid[i-1][j-1] + grid[i][j-1] + grid[i+1][j-1] != 15 ||
                grid[i-1][j+1] + grid[i][j+1] + grid[i+1][j+1] != 15
        ) {
            return false;
        }
        int[] checkDifferent = new int[9];
        for(int k=i-1;k<=i+1;k++) {
            for(int q=j-1;q<=j+1;q++) {
                if(grid[k][q] > 9 || grid[k][q] <= 0) {
                    return false;
                }
                if(checkDifferent[grid[k][q]-1] == -1) {
                    return false;
                }
                checkDifferent[grid[k][q]-1] = -1;
            }
        }

        return true;
    }
}
