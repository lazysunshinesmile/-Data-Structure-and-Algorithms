package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.List;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] kk = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ValidSudoku sudoku = new ValidSudoku();
        System.out.println(sudoku.isValidSudoku(kk));
    }



    private boolean isRight(char[] danyuan) {
        List<Character> all = new ArrayList<>();
        for(int i=0;i<9;i++) {
            char s = danyuan[i];
            if(s != '.') {
                Character sc = new Character(s);
                if(all.contains(sc)) {
                    return false;
                } else {
                    all.add(sc);
                }
            }
        }
        return true;

    }

    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<3;i++) {
            for(int j =0;j<9;j++) {
                char[] data = getData(board,i, j);
                if(!isRight(data)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param board
     * @param z 类型
     * @param m 第几个 从0开始
     * @return
     */
    private char[] getData(char[][] board, int z, int m){
        char[] ret = new char[9];
        if(z == 0) {
            //横
            for(int i=0; i<9;i++) {
                ret[i] = board[m][i];
            }

        } else if (z==1) {
            //竖
            for(int i=0; i<9;i++) {
                ret[i] = board[i][m];
            }
        } else {
            //方格
            int start =-1;
            if(m <=2) {
                start =0;
            } else if(m <=5) {
                start =3;
            }else  if(m<=8) {
                start = 6;
            }

            int end = (m%3 )*3 +2;
            int c =0;
            for(int i=start;i<=start+2;i++) {
                for(int j=end;j>=end-2;j--)
                    ret[c++] = board[i][j];
            }
        }

        return ret;

    }

}
