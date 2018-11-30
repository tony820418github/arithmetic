package com.sh.zfc.graph.bfs;

import java.util.List;
import java.util.Stack;

/*
  拓扑排序的两种实现
  一种是Kahn算法，一种是DFS算法
 */
public class TopSort {

    // visited数组，DFS实现需要用到
    private boolean[] visited;
    // 使用栈来保存最后的结果，因为会先收集没有出度的点，所以需要倒序，使用stack结构
    private Stack<Integer> reversePost;

    //初始化类
    public TopSort(Digraph di) {
        this.visited = new boolean[di.getVertexNum()];
        this.reversePost = new Stack<Integer>();
    }

    /*
      使用DFS对图进行拓扑排序
      时间复杂度 O(V+E)
     */
    public void topSortByDFS(Digraph di){
        //依次查找所有的
        for (int i = 0; i < di.getVertexNum(); i++) {
            if (!visited[i]) {
                dfs(di, i);//依次处理没有处理过的点
            }
        }
    }
    public void dfs(Digraph di, int v) {
        visited[v] = true;
        //递归处理所有的子结点（后续结点）
        List<Integer> edges = di.getEdge(v);
            for (Integer w : edges) {
                if (!visited[w]) {
                    dfs(di, w);
                }
            }
        //后续结点都处理完了，把当前结点入stack
        reversePost.push(v);
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
