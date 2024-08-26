package com.dinesh.algorithm.graph.spanning_tree;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * https://takeuforward.org/data-structure/prims-algorithm-minimum-spanning-tree-c-and-java-g-45/
 * https://www.youtube.com/watch?v=mJcZjjKzeqk
 *
 * Minimum Spanning Tree
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree
 *
 */
public class MinimumSpanningTree {
    static class Pair {
        int weight;
        int parent;
        int node;
        public Pair(int weight, int parent, int node) {
            this.weight = weight;
            this.parent = parent;
            this.node = node;
        }
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        int[] visited = new int[V];

        int sum = 0;

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        queue.add(new Pair(0, 0, 0));

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();

            if(visited[pair.node] == 1)
                continue;

            visited[pair.node] = 1;

            sum += pair.weight;

            for(int[] node: adj.get(pair.node)) {
                if(visited[node[0]] == 1)
                    continue;
                queue.add(new Pair(node[1], pair.node, node[0]));
            }

        }

        return sum;

    }
}
