package com.sh.zfc.graph.bfs;

import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.*;

public class DFSTest {

    @Test
    public void DFSTraverse() {
        DFS dfs = new DFS();
        dfs.setVertex(new String[]{"A","B","C","D"});
        dfs.setGraph(new int[][]{{0,1,0,1},{1,0,1,0},{0,1,0,0},{1,0,0,0}});
        List<String> actual = dfs.DFSTraverse(0);
        assertEquals("ABCD",actual.stream().collect(joining()));
    }
}