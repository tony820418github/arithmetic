package com.sh.zfc.graph.bfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class BellManTest {

    @Test
    public void bellManMinPath() {
        String[] vertexs = new String[]{"A","B","C","D"};
        DigraphVEW.Edge[] edges = new DigraphVEW.Edge[]{
                new DigraphVEW.Edge(0,1,1),
                new DigraphVEW.Edge(0,2,2),
                new DigraphVEW.Edge(1,2,2),
                new DigraphVEW.Edge(1,3,6),
                new DigraphVEW.Edge(2,3,3)
        };
        DigraphVEW di = new DigraphVEW(vertexs,edges);

        BellMan bellMan= new BellMan(di);
        boolean result  = bellMan.bellManMinPath();
        assertEquals(true ,result);
        assertArrayEquals(new int[]{0,1,2,5},bellMan.getMinPaths());
    }

    @Test
    public void bellManMinPathFailed() {
        String[] vertexs = new String[]{"A","B","C","D"};
        DigraphVEW.Edge[] edges = new DigraphVEW.Edge[]{
                new DigraphVEW.Edge(0,1,1),
                new DigraphVEW.Edge(0,2,2),
                new DigraphVEW.Edge(1,2,2),
                new DigraphVEW.Edge(1,3,6),
                new DigraphVEW.Edge(2,3,3),
                new DigraphVEW.Edge(2,0,-5),
        };
        DigraphVEW di = new DigraphVEW(vertexs,edges);

        BellMan bellMan= new BellMan(di);
        boolean result  = bellMan.bellManMinPath();
        assertEquals(false ,result);
    }

}