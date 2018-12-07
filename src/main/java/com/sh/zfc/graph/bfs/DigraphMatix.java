package com.sh.zfc.graph.bfs;

import java.util.Arrays;

public class DigraphMatix {
    //图矩阵
    int [][] matrix ;
    //权值最大值， 表示正无穷
    public final static  int INFINITY = 25536;
    //树的点个数
    int verNum = 0;

    public DigraphMatix(int[][] di) {
        this.matrix = di;
        verNum = di.length;
    }


    public int[][] getMatrix() {
        return matrix;
    }

    public DigraphMatix(int num) {
        matrix = new int[num][num];
        this.verNum = num;
        for (int i = 0; i < verNum; i++) {
            for (int j = 0; j < verNum; j++) {
                if (j == i) {
                    matrix[i][j] = 0;
                }
                matrix[i][j] = INFINITY;
            }
        }
    }
}
