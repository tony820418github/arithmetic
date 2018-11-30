package com.sh.zfc.graph.bfs;
/*
*
* */
import javax.xml.soap.Node;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BFS {
    /**
     * 生成广度优先算法数
     */
    public Node createBFSTree(){
        return null;
    }

    /**
    * 计算两点之间的一条最短路径,邻接矩阵法表示图
    * */
//    public List<Point> shortestPath(Point start , Point end, int[][] map){
//        return null;
//    }

    /**
     * 广度优先遍历图，邻接矩阵实现
     * {0101
     *  1010
     *  0100
     *  1000}
     * */
    public List<Integer> BFSTraverse(int[][] graph){
        int vertexNum = graph.length;
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> visiting = new ArrayDeque<>();
        visiting.add(0);
        while (visiting.size() >0) {
            Integer vertex = visiting.poll();
            visited.add(vertex);
            for (int i = 0; i < vertexNum; i++) {
                if (graph[vertex][i] ==1 && !visited.contains(i)) {
                    visiting.add(i);
                }
            }
        }
        return visited;
    }
    /**
     * 广度优先遍历图，邻接表实现
     * 假设数结点存储的是字符串。
     * */
    public List<VerText> BFSTraverseTable(VerText[] graph){
        int vertexNum = graph.length;
        List<VerText> visited = new ArrayList<>();
        Queue<VerText> visiting = new ArrayDeque<>();
        visiting.add(graph[0]);
        while (visiting.size() >0) {
            VerText vertex = visiting.poll();
            visited.add(vertex);
            LinkNode linknode = vertex.getFirstChild();
            while (linknode != null){
                if (!visited.contains(graph[linknode.getIndex()])) {
                    visiting.add(graph[linknode.getIndex()]);
                    linknode = linknode.getNext();
                }
            }
        }

        return visited;
    }

    /**
      邻接表的vertex结点
     */
    public static class VerText{
        public String data;
        LinkNode firstChild;

        public VerText(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public LinkNode getFirstChild() {
            return firstChild;
        }

        public void setFirstChild(LinkNode firstChild) {
            this.firstChild = firstChild;
        }
    }
    /**
     *  邻接表的连接接点
     */
    public static  class LinkNode{
        public int index;
        LinkNode next;

        public LinkNode(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }

}
