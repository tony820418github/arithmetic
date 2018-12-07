package com.sh.zfc.graph.bfs;

import java.util.Arrays;
/*
   单源最小路径算法，给出从一个点到其他所有点的最小路径
   算法复杂度 O(VE)
 */
public class BellMan {
    int[] minPaths; //记录从源点到所有其他点的最短路径
    DigraphVEW di;  //带权值的图
    int INF= 65535; //带表正无穷

    /*
    初始化
     */
    public BellMan(DigraphVEW di) {
        this.minPaths = new int[di.getVerNum()];
        this.di = di;
        Arrays.fill(minPaths,INF);
        minPaths[0] = 0;
    }

    public boolean bellManMinPath(){
        //如有n个顶点，最大遍历n-1次
        boolean isFinished = true;  //标识是否完成松驰，如果某次迭代后，所有点最小路径数据没变，则认为完成了。
        for (int i = 1; i < di.getVerNum(); i++) {
            for (DigraphVEW.Edge edge: di.getEdgds()) {
                if (edge.weight + minPaths[edge.start] < minPaths[edge.end]) {
                    minPaths[edge.end] = edge.weight + minPaths[edge.start];
                    isFinished = false;
                }
            }
            if (isFinished) {
                break;
            }
        }

        for (DigraphVEW.Edge edge: di.getEdgds()) {
            if (edge.weight + minPaths[edge.start] < minPaths[edge.end]) {
                return false;
            }
        }
        return true;
    }

    public int[] getMinPaths() {
        return minPaths;
    }
}
