package com.dinesh.algorithm.graph;

import java.util.HashSet;
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


}
