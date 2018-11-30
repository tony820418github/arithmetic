package com.sh.zfc.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
Kosaraju 算法实现最强连通算法
 */
public class KosarajuSCC {
    //返回的SCC的森林,每一个元素都是一个最强通子集
    public List<List<Integer>> sccLists;

    // visited数组，DFS实现需要用到
    private boolean[] visited;

    // 使用栈来保存topsort的结果，因为会先收集没有出度的点，所以需要倒序，使用stack结构
    private Stack<Integer> reversePost;

    public KosarajuSCC(Digraph di) {
        this.visited = new boolean[di.getVertexNum()];
        this.reversePost = new Stack<Integer>();
        sccLists = new ArrayList<List<Integer>>();
    }


    /*
    scc算法，输出结果在sccLists中
     */
    public void scc(Digraph di) {
        //先做topSort排序 ，得到排序后的结果，存在reversePost中
        topSortByDFS(di);
        //重置visited, 进行scc的DFS 过程
        Arrays.fill(visited, false);

        //转置DI
        Digraph diT = di.reverseGraph();

        //依次对topSort的结果进行scc 的DFS
        while (!reversePost.empty()) {
            Integer v = reversePost.pop();
            if (visited[v] == false) {
                List<Integer> sccList = new ArrayList<>();
                dfsForScc(diT, v , sccList);
                sccLists.add(sccList);
            }
        }
    }

    private void dfsForScc(Digraph di, Integer v , List sccList) {
        visited[v] = true;
        List<Integer> edges = di.getEdge(v);
        for (Integer w : edges) {
            if (!visited[w]) {
                dfsForScc(di, w , sccList);
            }
        }
        //后续结点都处理完了，把当前结点入stack
        sccList.add(v);
    }

    /*
  使用DFS对图进行拓扑排序
  时间复杂度 O(V+E)
 */
    public void topSortByDFS(Digraph di) {
        //依次查找所有的
        for (int i = 0; i < di.getVertexNum(); i++) {
            if (!visited[i]) {
                dfsForTopsort(di, i);//依次处理没有处理过的点
            }
        }
    }

    public void dfsForTopsort(Digraph di, int v) {
        visited[v] = true;
        //递归处理所有的子结点（后续结点）
        List<Integer> edges = di.getEdge(v);
        for (Integer w : edges) {
            if (!visited[w]) {
                dfsForTopsort(di, w);
            }
        }
        //后续结点都处理完了，把当前结点入stack
        reversePost.push(v);
    }

}
