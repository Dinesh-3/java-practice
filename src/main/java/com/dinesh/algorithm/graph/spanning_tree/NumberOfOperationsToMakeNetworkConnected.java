package com.dinesh.algorithm.graph.spanning_tree;

/**
 *
 * 1319. Number of Operations to Make Network Connected
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 *
 * 1319. Number of Operations to Make Network Connected
 * https://www.youtube.com/watch?v=FYrl7iz9_ZU
 *
 */
public class NumberOfOperationsToMakeNetworkConnected {
    private class DisjointSet {
        int[] size;
        int[] parent;

        public DisjointSet(int v) {
            this.size = new int[v];
            int[] initParent = new int[v];
            for(int i = 0; i < v; i++)
                initParent[i] = i;
            this.parent = initParent;
        }

        public boolean isConnected(int u, int v) {
            int uParent = getParent(u);
            int vParent = getParent(v);

            return uParent == vParent;
        }

        private int getParent(int v) {
            if(parent[v] == v)
                return v;
            int root = getParent(parent[v]);
            parent[v] = root;
            return root;
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

        public int getComponentsCount() {
            int count = 0;
            for(int i = 0; i < parent.length; i++)
                if(i == parent[i])
                    count++;
            return count;
        }

    }

    public int makeConnected(int n, int[][] connections) {
        int extraConnections = 0;
        DisjointSet set = new DisjointSet(n);
        for(int[] edge: connections) {
            if(set.isConnected(edge[0], edge[1])) {
                extraConnections++;
                continue;
            }
            set.unionBySize(edge[0], edge[1]);
        }

        int componentsCount = set.getComponentsCount();

        if(extraConnections >= (componentsCount - 1) )
            return componentsCount - 1;
        return -1;
    }

}
