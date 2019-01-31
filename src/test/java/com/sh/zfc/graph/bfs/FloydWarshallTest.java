package com.sh.zfc.graph.bfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloydWarshallTest {

    @Test
    public void getFolydWarshall() {
        int inf = DigraphMatix.INFINITY;
        int[][] map = new int[][]{
                  {0, 3, 8, inf, -4}
                , {inf, 0, inf, 1, 7}
                , {inf, 4, 0, inf, inf}
                , {2, inf, -5, 0, inf}
                , {inf, inf, inf, 6, 0}};

        DigraphMatix di = new DigraphMatix(map);
        int [][] result = new FloydWarshall().getFolydWarshall(di);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }
}