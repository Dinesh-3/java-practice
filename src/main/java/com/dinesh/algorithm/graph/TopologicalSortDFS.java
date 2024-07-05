package com.dinesh.algorithm.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Directed Acylic Graph
 *
 * https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 * https://www.youtube.com/watch?v=73sneFXuTEg
 *
 * https://www.geeksforgeeks.org/problems/topological-sort
 *
 */
public class TopologicalSortDFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        return topoSortDFS(V, adj);
    }

    static int[] topoSortDFS(int V, ArrayList<ArrayList<Integer>> adj)
    {

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++)
            if(!visited.contains(i))
                dfs(i, adj, stack, visited);

        int[] result = new int[stack.size()];

        int i = 0;
        while(!stack.isEmpty())
            result[i++] = stack.pop();

        return result;

    }

    private static void dfs(int vertice, ArrayList<ArrayList<Integer>> adj, Stack<Integer> topo, Set<Integer> visited) {
        visited.add(vertice);
        for(var it: adj.get(vertice)) {
            if(!visited.contains(it))
                dfs(it, adj, topo, visited);
        }

        topo.add(vertice);
    }

}
