package com.sh.zfc.graph.bfs;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.*;

public class TopSortTest {

    @Test
    public void dfs() {
        Digraph.GraphVertex[] vertices = new Digraph.GraphVertex[4];
        vertices[0] = new Digraph.GraphVertex("A" , Arrays.asList(1,3));
        vertices[1] = new Digraph.GraphVertex("B" , Arrays.asList(2,3));
        vertices[2] = new Digraph.GraphVertex("C" );
        vertices[3] = new Digraph.GraphVertex("D" );


        Digraph<String> di = new Digraph<>(vertices);
        TopSort topsort = new TopSort(di);
        topsort.topSortByDFS(di);
        Stack<Integer> result =  topsort.getReversePost();
        Stack<Integer> expect =  new Stack<>();
        expect.push(2);
        expect.push(3);
        expect.push(1);
        expect.push(0);

        assertEquals(expect,result);
    }
}