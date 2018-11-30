package com.sh.zfc.graph.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class DFS {

    String[] vertex ;
    int [][] graph ;
    int  vertexNum;
    List<Integer> visited = new ArrayList<Integer>(vertexNum);

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }


    public String[] getVertex() {

        return vertex;
    }

    public void setVertex(String[] vertex) {
        this.vertex = vertex;
        this.vertexNum = vertex.length;
        this.visited = new ArrayList<>(vertexNum);
    }

    /*
     *  关联矩阵法的深度优先算法遍历
     */
    public List<String> DFSTraverse( int start){
        //纪录此结点已访问
        visited.add(start);
        //如果此结点关连的结点都访问过了，则返回
        //如果此结点关连的结点还有末遍历的，则进入子层
        for (int i=0 ; i< vertexNum; i++) {
            if (graph[start][i] == 1 && !visited.contains(i)) {
                DFSTraverse(i);
            }
        }
        return  visited.stream().map((a)->vertex[a]).collect(Collectors.toList());
    }
}
