package com.sun.sort.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
//        int[] val = testMain.fraction(new int[]{3,2,0,2});
//        System.out.println(val[0]+".." +val[1]);

//      boolean ret = testMain.robot("URRURRR",
//              new int[][]{{7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}},
//              4915, 1966);
//        System.out.println(ret);


        /*int n = 7;
        int[][] leadership = {{1, 2}, {2, 6}, {3, 7}, {2, 5}, {2, 4}, {1,3}};
        int[][] operations = {{1, 1, 500},  *//*{3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6}, {3,7},*//*
                {2, 2, 100}, *//*{3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6},{3,7},*//*
                {2, 3, 100}, *//*{3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6},{3,7},*//*
                {2, 7, 100}, *//*{3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6},{3,7},*//*
                {1, 1, 200}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {3, 6},{3,7},};
        int[] ret = testMain.bonus(n , leadership, operations);
        System.out.println(Arrays.toString(ret));*/
        testMain.isUnique("abc");

    }

    public boolean isUnique(String astr) {
        int[] res = new int[]
    }

//LCP5
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        fillTrees(n, leadership);
        int count = 0;
        for(int i=0; i<operations.length;i++) {
            if(operations[i][0] == 3) {
                count ++;
            }
        }

        int[] ret = new int[count];
        count = 0;
        for(int i=0; i<operations.length;i++) {
            int operation = operations[i][0]; //操作
            int no = operations[i][1]; //编号

            switch (operation) {
                case 1:
                    int money = operations[i][2]; //money
                    addAppointTree(no, money);
                    break;
                case 2:
                    money = operations[i][2]; //money
                    int update = addAppointAndSonTrees(no, money);
                    addParentTree(no, update);
                    break;
                case 3:
                    int result = queryAppointAndSonTreesMoney(no);
                    ret[count++] = result;
                    break;
            }
        }

        return  ret;
    }

    private int queryAppointAndSonTreesMoney(int no) {
        return trees[no].allSonsMoney + trees[no].money;
    }

    //返回所有孩子及其本身加的钱
    private int addAppointAndSonTrees(int no, int money) {

        Tree leader = trees[no];

        int oldmoey = leader.allSonsMoney;
        int update = 0;
        leader.money += money;
        if(leader.sons.size() == 0) {
            return money;
        }
        for(int i=0;i<leader.sons.size();i++) {

            update = addAppointAndSonTrees(leader.sons.get(i).no, money);
            leader.allSonsMoney += update;
        }
        return leader.allSonsMoney - oldmoey + money;
    }


    //给本身和父节点加钱
    private void addAppointTree(int no, int money) {
        trees[no].money += money;
        addParentTree(no, money);
    }

    private void addParentTree(int no, int money) {
        Tree parent = trees[no].parent;
        while(parent != null) {
            parent.allSonsMoney += money;
            parent = parent.parent;
        }
    }

    private Tree[] trees; //trees[0] 是空的

    private void fillTrees(int n, int[][] leadership){
        trees = new Tree[n+1];
        Tree tree;
        for(int i=0;i<n+1;i++) {
            tree = new Tree(i);
            trees[i] = tree;
        }
        for (int i=0; i<leadership.length;i++) {
            //给这个tree确认父子关系
            trees[leadership[i][0]].sons.add(trees[leadership[i][1]]);
            trees[leadership[i][1]].parent = trees[leadership[i][0]];
        }

    }

    class Tree {
        public Tree(int no) {
            this.no = no;
        }

        private int no = -1;
        private List<Tree> sons = new ArrayList<>(); //下属
        private int money;  //leetcoin 数目
        private Tree parent;
        private int allSonsMoney;   //所有下属的钱
    }





























    //LCP3
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int[][] path = getPath(command);
        if(!isArrive(path, x, y, x, y)) {
            return false;
        }
        for(int i=0; i<obstacles.length;i++) {
            int obstaclesX = obstacles[i][0];
            int obstaclesY = obstacles[i][1];
            if(isArrive(path,obstaclesX, obstaclesY, x, y)) {
                return false;
            }
        }

        return true;
    }


    /**
     * 记录再一次轮回中的路径
     * @param command 命令
     * @return 一个n行两列的数组，记录再一次轮回中的路径
     */
    private int[][] getPath(String command) {
        char[] chars = command.toCharArray();
        int x = 0; //当前x
        int y = 0; //当前y
        int len = chars.length;
        int[][] path = new int[len][2];

        for(int i=0; i<len;i++) {
            if(chars[i] == 'U') {
                y++;
            } else  if(chars[i] == 'R') {
                x++;
            }
            path[i][0] = x;
            path[i][1] = y;
        }
        return path;
    }


    private boolean isArrive(int[][] path, int obstaclesX, int obstaclesY, int targetX, int targetY) {
        if(obstaclesX > targetX || obstaclesY > targetY) {
            return false;
        }

        int maxX = path[path.length-1][0];
        int maxY = path[path.length-1][1];

        int lunhui = Math.min(obstaclesX/maxX, obstaclesY/maxY);
        obstaclesX = obstaclesX - maxX*lunhui;
        obstaclesY = obstaclesY - maxY*lunhui;

        if(obstaclesX == 0 && obstaclesY == 0) {
            //刚好到达最终点。
            return true;
        }


        for(int i=0;i<path.length;i++) {
            if(path[i][0] == obstaclesX) {
                if(obstaclesY < path[i][1]) {
                    return false;
                } else if(obstaclesY == path[i][1]) {
                    return true;
                }
            }else if(path[i][1] == obstaclesY) {
                if(obstaclesX < path[i][0]) {
                    return false;
                } else if(obstaclesX == path[i][0]) {
                    return true;
                }
            }
        }
        return false;
    };







    //LCP2
    public int[] fraction(int[] cont) {
        int[] val = new int[2];
        if(cont.length == 1) {
            return new int[]{cont[0], 1};
        }
        for(int i=cont.length -1; i>0 ;i--) {
            if(i== cont.length-1) {
                val = getres(cont[i-1], cont[i],1);
            } else {
                val = getres(cont[i-1], val[0], val[1]);
            }
        }
        int gcd = getGCD(val[0], val[1]);
        val[0] = val[0]/gcd;
        val[1] = val[1]/gcd;
        return val;
    }

    /**
     *
     * @param a 新来的数据
     * @param b 原来的分子
     * @param c 原来的分母
     * @return
     */
    private int[] getres(int a, int b, int c) {
        //a+1/(b/c) = a + c/b

        int[] res = new int[2];
        //分子
        res[0] = a *b +c;
        //分母
        res[1] = b;
        return res;
    }

    //获取最大公约数

    /**
     *
     * @param a 分子
     * @param b 分母
     * @return 最大公约数
     */
    private int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGCD(b, a % b);

    }
}
