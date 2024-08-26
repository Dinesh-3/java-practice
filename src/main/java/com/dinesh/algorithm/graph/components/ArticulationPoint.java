package com.dinesh.algorithm.graph.components;

import java.util.ArrayList;

/**
 *
 * Articulation Point
 * https://www.geeksforgeeks.org/problems/articulation-point-1
 *
 * https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/
 * https://www.youtube.com/watch?v=j1QDfU21iZk
 *
 */
public class ArticulationPoint {
    class Node {
        int time;
        int low;
        boolean isPoint;
        boolean visited;
    }

    private int time = 1;

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Node[] nodes = new Node[V];

        for(int i = 0; i < V; i++)
            nodes[i] = new Node();

        dfs(0, -1, adj, nodes);

        ArrayList<Integer> points = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            Node node = nodes[i];
            if(node.isPoint)
                points.add(i);
        }

        if(points.isEmpty())
            points.add(-1);

        return points;

    }

    private void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, Node[] nodes) {
        Node item = nodes[node];
        item.time = item.low = time++;

        item.visited = true;

        int child = 0;
        for(int ad: adj.get(node)) {
            Node adNode = nodes[ad];
            if(ad == parent)
                continue;
            if(nodes[ad].visited)
                item.low = Math.min(adNode.time, item.low);
            else {
                dfs(ad, node, adj, nodes);
                item.low = Math.min(adNode.low, item.low);

                if(item.time <= adNode.low && parent != -1)
                    item.isPoint = true;
                child++;
            }
        }

        if(child > 1 && parent == -1)
            item.isPoint = true;

    }

}
