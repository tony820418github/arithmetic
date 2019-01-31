package com.sh.zfc.graph.bfs;

import java.util.Arrays;

/*
   多源最短路径算法
 */
public class FloydWarshall {
    public int[][] getFolydWarshall(DigraphMatix di) {
        int verNum = di.getVerNum();
        int[][] result = new int[di.getVerNum()][di.getVerNum()];
        for (int i = 0; i < di.getVerNum(); i++) {
            result[i] = Arrays.copyOf(di.getMatrix()[i], di.getVerNum());
        }

        for (int k = 0; k < verNum; k++) {
            for (int i = 0; i < verNum; i++) {
                for (int j = 0; j < verNum; j++) {
                    if (result[i][k] != DigraphMatix.INFINITY &&
                            result[k][j] != DigraphMatix.INFINITY &&
                            result[i][k] + result[k][j] < result[i][j]) {
                        result[i][j] = result[i][k] + result[k][j];
                    }
                }
            }
        }
        return result;
    }
}
