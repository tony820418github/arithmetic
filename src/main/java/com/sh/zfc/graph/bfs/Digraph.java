package com.sh.zfc.graph.bfs;

import java.util.ArrayList;
import java.util.List;
/*
图对象 ，链接表法
 */
public class Digraph<T> {

     GraphVertex<T>[] di;
     int vertexNum;

    public GraphVertex<T>[] getVertexs() {
        return di;
    }

    public Digraph(GraphVertex<T>[] di) {
        this.di = di;
        vertexNum = di.length;
    }

    public int getVertexNum(){
        return vertexNum;
    }

    public List<Integer> getEdge(int v){
        return di[v].edge;
    }

    public T getVertexData(int v){
        return (T) di[v].date;
    }

    public Digraph<T> reverseGraph(){
        GraphVertex<T>[] newDi = new GraphVertex[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            newDi[i] = new GraphVertex<>(di[i].date);
        }

        for (int i = 0; i < vertexNum; i++) {
            for (Integer nextVertex:di[i].edge) {
                newDi[nextVertex].edge.add(i);
            }
        }
        return new Digraph<>(newDi);
    }


    public static class GraphVertex<T>{
        T date;//数据
        List<Integer> edge;//相邻结点的下标list

        public GraphVertex(T date) {
            this.date = date;
            edge = new ArrayList<>();
        }

        public GraphVertex(T date, List<Integer> edge) {
            this.date = date;
            this.edge = edge;
        }
    }

}
