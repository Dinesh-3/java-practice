package com.dinesh.algorithm.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 785. Is Graph Bipartite?
 * https://leetcode.com/problems/is-graph-bipartite
 *
 * https://www.youtube.com/watch?v=KG5YFfR0j8A
 *
 */
public class GraphBipartite {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int m = graph[0].length;

        Set<Integer> visited = new HashSet<>();
        int[] result = new int[n];

        for(int i = 0; i < n; i++) {
            if(visited.contains(i))
                continue;
            boolean flag = dfs(i, -1, graph, visited, result);
            if(!flag)
                return false;
        }

        return true;

    }

    private boolean dfs(int i, int flag,int[][] graph, Set<Integer> visited, int[] result) {
        visited.add(i);
        result[i] = flag;

        for(var it: graph[i]) {
            if(visited.contains(it)) {
                if(result[it] == flag)
                    return false;
            } else {
                if(!dfs(it, flag == 1 ? -1 : 1, graph, visited, result))
                    return false;
            }
        }

        return true;

    }

    public boolean isBipartiteBFS(int[][] graph) {
        Integer[] colors = new Integer[graph.length];

        for(int i = 0; i < graph.length; i++) {
            if(colors[i] != null)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;

            while(!queue.isEmpty()) {
                int node = queue.remove();
                for(int ad: graph[node]) {
                    if(colors[ad] == null) {
                        colors[ad] = colors[node] == 0 ? 1: 0;
                        queue.add(ad);
                    } else if (colors[ad] == colors[node])
                        return false;

                }
            }
        }

        return true;

    }

}
