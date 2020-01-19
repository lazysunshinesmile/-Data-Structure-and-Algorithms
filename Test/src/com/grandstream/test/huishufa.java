//package com.grandstream.test;

import java.util.Calendar;

public class huishufa {
    private int mRow = 8; // row
    private int mLine = 8; //line
    private int[][] mChess = new int[mRow][mLine];
    private int bushu = 1;

    /**
     * @param x
     * @param y
     * @param tag
     * @return
     */
    private boolean isNextEnable(int x, int y, int tag) {
        switch (tag) {
            case 1:
                if (y - 1 >= 0 && x - 2 >= 0 && mChess[x-2][y-1] == 0) {
                    return true;
                }
                break;
            case 2:
                if (y + 1 < mRow && x - 2 >= 0 && mChess[x-2][y+1] == 0) {
                    return true;
                }
                break;
            case 3:
                if (y + 2 < mRow && x - 1 >= 0 && mChess[x-1][y+2] == 0) {
                    return true;
                }
                break;
            case 4:
                if (y + 2 < mRow && x + 1 < mLine && mChess[x+1][y + 2] == 0) {
                    return true;
                }
                break;
            case 5:
                if (y + 1 < mRow && x + 2 < mLine && mChess[x + 2][y + 1] == 0) {
                    return true;
                }
                break;
            case 6:
                if (y - 1 >= 0 && x + 2 < mLine && mChess[x+2][y -1] == 0) {
                    return true;
                }
                break;
            case 7:
                if (y - 2 >= 0 && x + 1 < mLine && mChess[x+1][y-2] == 0) {
                    return true;
                }
                break;
            case 8:
                if (y - 2 >= 0 && x- 1 >= 0 && mChess[x - 1][y - 2] == 0) {
                    return true;
                }
                break;
        }
        return false;
    }

    private int getNextY(int tag, int y) {
        switch (tag) {
            case 1:
                return y - 1;
            case 2:
                return y + 1;
            case 3:
                return y + 2;
            case 4:
                return y + 2;
            case 5:
                return y + 1;
            case 6:
                return y - 1;
            case 7:
                return y - 2;

            case 8:
                return y - 2;
        }
        return -1;
    }

    private int getNextX(int tag, int x) {
        switch (tag) {
            case 1:
                return x - 2;
            case 2:
                return x - 2;
            case 3:
                return x - 1;
            case 4:
                return x + 1;
            case 5:
                return x + 2;
            case 6:
                return x + 2;
            case 7:
                return x + 1;
            case 8:
                return x - 1;

        }
        return -1;
    }


    /**检测能否走[x,y]，
     * 能，再检测下下一步，如果还能，这一步就走
     * 不能，就清除填的标记，返回不能。
     */

    private boolean checkCanGo(int x, int y) {
        int tag = 0;
        if(bushu == mRow* mLine) {
            return true;
        }
        boolean canGoNext = isNextEnable(x, y, tag);
        while(!canGoNext && tag <= 8) {
            tag++;
            canGoNext = isNextEnable(x, y, tag);
        }

        if(!canGoNext) {
            return false;
        } else {
            mChess[x][y] = bushu++;
        }

        int tag2 = 0;
        canGoNext = isNextEnable(getNextX(tag, x), getNextY(tag, y), tag2);
        printChess();
        while(canGoNext) {
            if(checkCanGo(getNextX(tag, x), getNextY(tag, y))) {
                printChess();
                return true;
            } else {
                tag2++;
                canGoNext = isNextEnable(getNextX(tag,x), getNextY(tag, y), tag2);
                while(!canGoNext && tag2 <= 8) {
                    tag2++;
                    canGoNext = isNextEnable(getNextX(tag,x), getNextY(tag,y), tag2);
                }
            }

        }
        if(!canGoNext) {
            mChess[x][y] = 0;
            bushu--;
        }

        return false;
    }

    private boolean checkCanGo(int x, int y, int bushu) {

        mChess[x][y] = bushu;
        if(bushu == mRow * mLine) {
            return true;
        }

        int tag = 1;
        while(tag <= 8) {
            while(!isNextEnable(x, y, tag) && tag <=8) {
                tag++;
            }
            if(tag > 8) {
                return false;
            }
            int nextX = getNextX(tag, x);
            int nextY = getNextY(tag, y);

            if(checkCanGo(nextX, nextY, bushu+1)) {
                return true;
            } else {
                mChess[nextX][nextY] = 0;
                tag++;
            }
        }

        return false;
    }


    private void printChess() {
        for (int i = 0; i < mRow; i++) {
            for(int j = 0; j< mLine; j++) {
                System.out.print(mChess[i][j] + (mChess[i][j] >= 10 ? " ":"  "));
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        long startTime=calendar.getTimeInMillis();
        huishufa huishufa = new huishufa();
//        huishufa.getMethod(4,4);


        if(huishufa.checkCanGo(2,0, 1)) {
            long overTime = calendar.getTimeInMillis();
	    System.out.println("startTime:" + startTime + ",voerTime:" + overTime);
            System.out.println("chengggong, time:" + (overTime-startTime)/1000 + "s");
            huishufa.printChess();
        }
	 


    }
}
