package com.sh.zfc.graph.bfs;
/*
  带权值图的一种表示方法：顶点与和边数组
 */
public class DigraphVEW {
    String[] vertex;//所有顶点的数组,存放顶点的名字
    int verNum;//顶点个数
    Edge[] edgds;//所有带权边的数组

    public DigraphVEW(String[] vertex,  Edge[] edgds) {
        this.vertex = vertex;
        this.verNum = vertex.length;
        this.edgds = edgds;
    }

    public String[] getVertex() {
        return vertex;
    }

    public void setVertex(String[] vertex) {
        this.vertex = vertex;
    }

    public int getVerNum() {
        return verNum;
    }

    public Edge[] getEdgds() {
        return edgds;
    }

    public void setEdgds(Edge[] edgds) {
        this.edgds = edgds;
    }

    public static class Edge{
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
