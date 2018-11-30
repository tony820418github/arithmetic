package com.sh.zfc.graph.bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KosarajuSCCTest {
    @Test
    public void scc() {
        Digraph.GraphVertex[] vertices = new Digraph.GraphVertex[6];
        vertices[0] = new Digraph.GraphVertex("A" , Arrays.asList(1));
        vertices[1] = new Digraph.GraphVertex("B" , Arrays.asList(2));
        vertices[2] = new Digraph.GraphVertex("C" ,Arrays.asList(0,3,4));
        vertices[3] = new Digraph.GraphVertex("D" ,Arrays.asList(5));
        vertices[4] = new Digraph.GraphVertex("E" ,Arrays.asList(2));
        vertices[5] = new Digraph.GraphVertex("F" ,Arrays.asList(3));

        Digraph<String> di = new Digraph<>(vertices);
        KosarajuSCC scc = new KosarajuSCC(di);
        scc.scc(di);
        List<List<Integer>> result =  scc.sccLists;
        //Actual   :[[1, 4, 2, 0], [5, 3]]
        List<List<Integer>> expect =  Arrays.asList(Arrays.asList(1,4,2,0),Arrays.asList(5,3));
        assertEquals(expect,result);
    }
}