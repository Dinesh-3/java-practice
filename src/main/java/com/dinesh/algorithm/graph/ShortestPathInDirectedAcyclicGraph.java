package com.dinesh.algorithm.graph;

import java.util.*;

public class ShortestPathInDirectedAcyclicGraph {
    class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public int[] shortestPath(int N,int M, int[][] edges) {
        List<List<Node>> adj = new ArrayList<>();

        for(int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for(int[] edge: edges)
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));

        Set<Integer> visited = new HashSet<>();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            if(visited.contains(i))
                continue;
            dfs(i, adj, visited, stack);
        }

        int[] dis = new int[N];
        Arrays.fill(dis, (int)(1e9));
        dis[0] = 0;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(Node ad: adj.get(node)) {

                int newDistance = dis[node] + ad.weight;
                if(newDistance < 0)
                    continue;
                if(dis[ad.node] > newDistance)
                    dis[ad.node] = newDistance;
            }
        }

        for(int i = 0; i < dis.length; i++) {
            if(dis[i] == (int)(1e9))
                dis[i] = -1;
        }

        return dis;

    }

    private void dfs(int node, List<List<Node>> adj, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);

        for(Node adNode: adj.get(node))
            if(!visited.contains(adNode.node))
                dfs(adNode.node, adj, visited, stack);

        stack.push(node);

    }

}
