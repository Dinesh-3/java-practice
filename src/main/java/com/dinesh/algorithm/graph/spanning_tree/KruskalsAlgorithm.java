package com.dinesh.algorithm.graph.spanning_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Kruskal's Algorithm - Minimum Spanning Tree : G-47
 * https://www.youtube.com/watch?v=DMnDM_sxVig
 *
 * https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/
 *
 * https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
 *
 */
public class KruskalsAlgorithm {

    static class DisjointSet {
        int[] size;
        int[] parent;
        public DisjointSet(int v) {
            this.size = new int[v+1];
            int[] parents = new int[v+1];
            for(int i = 0; i <= v;i++)
                parents[i] = i;
            this.parent = parents;
        }

        public boolean isConnected(int u, int v) {
            int uParent = getParent(u);
            int vParent = getParent(v);

            return uParent == vParent;
        }

        private int getParent(int v) {
            if(parent[v] == v)
                return v;
            int superParent = getParent(parent[v]);
            parent[v] = superParent;
            return superParent;
        }

        public void unionBySize(int u, int v) {
            int uParent = getParent(u);
            int vParent = getParent(v);

            if(size[uParent] > size[vParent]) {
                parent[vParent] = uParent;
                size[uParent] += size[vParent];
            } else {
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
            }
        }

    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            for(int[] node: adj.get(i)) {
                edges.add(new int[] { i, node[0], node[1] });
            }
        }

        edges.sort(Comparator.comparingInt(edge -> edge[2]));

        int sum = 0;

        DisjointSet set = new DisjointSet(V);
        for(int[] edge: edges) {
            if(set.isConnected(edge[0], edge[1]))
                continue;
            sum += edge[2];
            set.unionBySize(edge[0], edge[1]);
        }

        return sum;
    }

}
