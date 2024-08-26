package com.dinesh.algorithm.graph.components;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 1192. Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/
 *
 * https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/
 * https://www.youtube.com/watch?v=qrAub5z8FeA
 *
 *
 */
public class BridgesInGraph {
    class Node {
        int timer;
        int low;
        boolean visited;
    }

    class Timer {
        int time;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Node[] nodes = new Node[n];

        for(int i = 0; i < n; i++)
            nodes[i] = new Node();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(List<Integer> edge: connections) {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }

        Timer timer = new Timer();
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, timer, nodes, adjList, res);

        return res;
    }

    private void dfs(int node, int parent, Timer timer, Node[] nodes, List<List<Integer>> adjList, List<List<Integer>> res) {
        nodes[node].visited = true;
        nodes[node].timer = timer.time;
        nodes[node].low = timer.time;
        timer.time += 1;
        for(int adj: adjList.get(node)) {
            if(adj == parent)
                continue;
            if(nodes[adj].visited) {
                nodes[node].low = Math.min(nodes[node].low, nodes[adj].low);
            } else {
                dfs(adj, node, timer, nodes, adjList, res);
                nodes[node].low = Math.min(nodes[node].low, nodes[adj].low);
                if(nodes[node].timer < nodes[adj].low)
                    res.add(List.of(node, adj));
            }
        }
    }

}
