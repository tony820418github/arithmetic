package com.sh.zfc.graph.bfs;

import java.util.Arrays;

public class MinSpanTree {
    public void MinSpanTree_Prim(DigraphMatix di) {
        int adjvex[] = new int[di.verNum]; //存放依次找到的最小生成树的结点
        int lowcost[] = new int[di.verNum];//存放已经生成的最小生成树到所有结点的权重值，已经访问到的结点对应的值为0

        Arrays.fill(adjvex, 0);
        lowcost = Arrays.copyOf(di.getMatrix()[0], di.verNum);
        lowcost[0] = 0;

        for (int i = 1; i < di.verNum; i++) {
            int min = DigraphMatix.INFINITY;

            int j = 0, k = 0;
            //遍历lowcost，找出lowcost中的最小权值，存入min,并记录在数组中的index到变量k。
            while (j < di.verNum) {
                if (lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[j];
                    k = j;
                }
                j++;
            }
            System.out.printf("(%d,%d)", adjvex[k], k);
            lowcost[k] = 0; //把找到的到最小权限结点的权限设置为0 , 此结点后续不会再处理，说明已经遍历过了
            for (int m = 1; m < di.verNum; m++) {
                if (lowcost[m] != 0 && di.getMatrix()[k][m] < lowcost[m]) {
                    lowcost[m] = di.getMatrix()[k][m];
                    adjvex[m] = k;
                }
            }
        }
    }


    public void MinSpanTree_Kruskal(DigraphMatix di) {

    }
}
