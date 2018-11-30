package com.sh.zfc.graph.bfs;

import org.junit.Test;
import sun.security.provider.certpath.Vertex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

public class BFSTest {

    @Test
    public void BFSTraverse() {
        BFS bfs  = new BFS();
        /*
        *  输入： {0101
         *         1010
         *         0100
         *         1000}
        *             0
        *           1   3
         *       2
        */
        List<Integer> list = bfs.BFSTraverse(new int[][]{{0,1,0,1},{1,0,1,0},{0,1,0,0},{1,0,0,0}});
        assertEquals(Arrays.asList(0,1,3,2) , list);
    }

    /**
     *         *             A
     *         *           B   D
     *          *       C
     */
    @Test
    public void BFSTraverseTable() {
        BFS bfs  = new BFS();
        BFS.VerText[] vt = new BFS.VerText[4];
        vt[0] = new BFS.VerText("A");
        vt[1] = new BFS.VerText("B");
        vt[2] = new BFS.VerText("C");
        vt[3] = new BFS.VerText("D");

        BFS.LinkNode a2b = new BFS.LinkNode(1);
        BFS.LinkNode a2d = new BFS.LinkNode(3);
        a2b.setNext(a2d);
        vt[0].firstChild = a2b;

        BFS.LinkNode b2c = new BFS.LinkNode(2);
        vt[1].firstChild = b2c;

        List<BFS.VerText> list = bfs.BFSTraverseTable(vt);

    //    for (BFS.VerText v :list) {
    //        actural = actural + v.getData(); }

        String actural = list.stream().map(BFS.VerText::getData).collect(joining());

        assertEquals("ABDC", actural);
    }
}