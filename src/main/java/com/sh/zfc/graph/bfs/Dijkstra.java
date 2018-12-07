package com.sh.zfc.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
   单源最小路径算法，给出从一个点到其他所有点的最小路径
   算法复杂度
 */
public class Dijkstra {
    int[] minPaths; //记录从源点到所有其他点的最短路径
    boolean[] visisted;
    int INF= 65535; //带表正无穷
    Digraph<String> di;  //图的链表表示
    int verNum;//图的结点的个数
    List<Digraph.GraphVertex<String>> retainVertex;
    List<Digraph.GraphVertex<String>> visitedVertex;

    public Dijkstra(Digraph<String> di) {
        this.di = di;
        verNum = di.vertexNum;
        minPaths = new int[verNum];
        visisted = new boolean[verNum];
        Arrays.fill(minPaths,INF);
        minPaths[0] = 0;
        Arrays.fill(visisted,false);
        visitedVertex = new ArrayList<>();
    }

    public void dijkstraPath(){
        //找出最权值最小的顶点的下标
        int min = INF;
        int k = -1;
        for (int i = 0; i < verNum; i++) {
            if (visisted[i] == false && minPaths[i]<min) {
                min = minPaths[i];
                k = i;
            }
        }
        //如果没有最小的顶点了，则退出
        if (k == -1) {
            return;
        }
        //如果有对所有边进行松驰
        for (Integer edge:di.getEdge(k)) {


        }

        //继续执行
    }

}
