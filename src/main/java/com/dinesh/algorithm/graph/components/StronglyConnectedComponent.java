package com.dinesh.algorithm.graph.components;

import java.util.*;

/**
 *
 * Strongly Connected Components (Kosaraju's Algo)
 * https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo
 *
 * https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/
 * https://www.youtube.com/watch?v=R6uoSjZ2imo
 *
 */
public class StronglyConnectedComponent {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // topo sort
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++) {
            if(!visited.contains(i))
                topoSort(i, adj, stack, visited);
        }


        // reverse the edges
        List<List<Integer>> reversed = new ArrayList<>();
        for(int i = 0; i < V; i++)
            reversed.add(new ArrayList<>());

        for(int i = 0; i < V; i++) {
            for(int ad: adj.get(i))
                reversed.get(ad).add(i);
        }


        // count scc
        visited.clear();
        int count = 0;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(visited.contains(node))
                continue;

            // dfs

            Stack<Integer> path = new Stack<>();
            path.push(node);

            while(!path.isEmpty()) {
                int ed = path.pop();
                visited.add(ed);
                for(int ad: reversed.get(ed))
                    if(!visited.contains(ad))
                        path.push(ad);
            }

            dfs(node, visited, reversed);

            count++;
        }

        return count;


    }

    private void dfs(int node, Set<Integer> visited, List<List<Integer>> adj) {
        visited.add(node);
        for(int ad: adj.get(node))
            if(!visited.contains(ad))
                dfs(ad, visited, adj);
    }

    private void topoSort(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, Set<Integer> visited) {
        visited.add(node);
        for(int ad: adj.get(node))
            if(!visited.contains(ad))
                topoSort(ad, adj, stack, visited);
        stack.push(node);
    }

}
