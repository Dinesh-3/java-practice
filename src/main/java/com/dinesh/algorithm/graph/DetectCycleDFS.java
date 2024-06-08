package com.dinesh.algorithm.graph;

import java.util.*;

/**
 * Detect Cycle in an Undirected Graph (using DFS)
 * https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
 * https://www.youtube.com/watch?v=zQ3zgFypzX4
 */
public class DetectCycleDFS {
    class Pair {
        int data;
        int parent;

        public Pair(int data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < V; i++) {
            if(set.contains(i))
                continue;
            if(dfs(new Pair(i, -1), adj, set))
                return true;
        }

        return false;
    }

    private boolean dfs(Pair pair, ArrayList<ArrayList<Integer>> adj, Set<Integer> visited) {
        visited.add(pair.data);
        for (var it: adj.get(pair.data)) {
            if(visited.contains(it)) {
                if(pair.parent != it)
                    return true;
            } else {
                if(dfs(new Pair(it, pair.data), adj, visited))
                    return true;
            }
        }
        return false;
    }


}
