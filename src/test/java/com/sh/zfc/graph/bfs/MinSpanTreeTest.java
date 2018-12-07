package com.sh.zfc.graph.bfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinSpanTreeTest {

    @Test
    public void minSpanTree_Prim() {
        int[][] map = new int[][]{
                  {0, 2, 1, DigraphMatix.INFINITY}
                , {2,0, 3, 4}
                , {1, 3,0, 5}
                , {DigraphMatix.INFINITY,4,5,0}};

        DigraphMatix di = new DigraphMatix(map);
        MinSpanTree tree = new MinSpanTree();
        tree.MinSpanTree_Prim(di);//(0,2)(0,1)(1,3)
    }

}