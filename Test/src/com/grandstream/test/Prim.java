package com.grandstream.test;

//给你一个图的邻接矩阵，算出遍历所有顶点，权值最小的走法
public class Prim {
    private int[][] mAdjacencyMatrix; //邻接矩阵
    private int mCount; //顶点数
    private int[] lowcost; //到达顶点的最小权值，lowcast[0] = 5; 表示到达顶点0的最小权值是5；
    private int[] adjvex; //到达顶点的最小权值对应的顶点，adjvex[0] = 5; 表示到达顶点0的最小权值顶点是5；

    public Prim(int[][] adjacencyMatrix) {
        mAdjacencyMatrix = adjacencyMatrix;
        mCount = mAdjacencyMatrix.length;
        lowcost = new int[mCount];
        adjvex = new int[mCount];
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=1;i<mCount;i++) {
            if(mAdjacencyMatrix[0][i] != Integer.MAX_VALUE) {
                lowcost[i] = mAdjacencyMatrix[0][i];
                adjvex[i] = 0;
            } else {
                lowcost[i] = Integer.MAX_VALUE;
            }
        }
        lowcost[0] = 0;
    }


    public void getMethod() {
        int sum = 0;
        //因为第一个数已经默认是0了，所以只需要确定接下来的mCount-1个顶点就行了
        for(int z =0; z <mCount-1; z++) {
            //找到lowcost中的最小min，下标minIndex也记住
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < mCount; i++) {
                if (lowcost[i] < min && lowcost[i] != 0) {
                    min = lowcost[i];
                    minIndex = i;
                }
            }

            // lowcost[minIndex]=0 表示这个顶点已经走过了,打印边(起点，终点)(adjvex[k], k);
            sum += min;
            lowcost[minIndex] = 0;
            System.out.println("从顶点"+ adjvex[minIndex]+ "到顶点"+ minIndex + ", 权值是" + min);


            //更新lowcost,遍历邻接矩阵mAdjacencyMatrix[minIndex][i],
            // 如果比lowcost[i]小 && mAdjacencyMatrix[minIndex][i]，就替换lowcost[i]。
            // adj[i] = minIndex


            for(int i=0 ;i<mCount; i++) {
                if(mAdjacencyMatrix[minIndex][i] < lowcost[i] && lowcost[i] != 0 && mAdjacencyMatrix[minIndex][i] != 0) {
                    lowcost[i] = mAdjacencyMatrix[minIndex][i];
                    adjvex[i] = minIndex;
                }
            }
        }

        System.out.println("总权值:" + sum);
    }
}
