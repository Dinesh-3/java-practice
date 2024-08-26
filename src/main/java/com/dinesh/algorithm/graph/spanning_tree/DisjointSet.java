package com.dinesh.algorithm.graph.spanning_tree;

import java.util.Arrays;

/**
 *
 * Disjoint Set [Union by Rank]
 * https://www.youtube.com/watch?v=aBxjDBC4M1U
 *
 * https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
 *
 * Time complexity ( 4 Alpha )
 *
 */
public class DisjointSet {

    private int[] size;
    private int[] rank;
    private int[] parent;

    public DisjointSet(int nodes) {
        this.size = new int[nodes+1];
        Arrays.fill(this.size, 1);
        this.rank = new int[nodes+1];
        int[] parent = new int[nodes+1];
        for (int i = 0; i <= nodes; i++)
            parent[i] = i;
        this.parent = parent;
    }

    public int findParent(int x) {
        if(parent[x] == x)
            return x;
        int par = findParent(parent[x]);
        parent[x] = par;
        return par;
    }

    public void unionBySize(int x, int z) {
        int xParent = findParent(x);
        int zParent = findParent(z);
        if(xParent == zParent)
            return;

        if(size[xParent] > size[zParent]) {
            parent[zParent] = xParent;
            size[xParent] = size[xParent] + size[zParent];
        } else {
            parent[xParent] = zParent;
            size[zParent] = size[zParent] + size[xParent];
        }
    }

    public void unionByRank(int x, int z) {
        int xParent = findParent(x);
        int zParent = findParent(z);

        if(xParent == zParent)
            return;

        if(rank[xParent] > rank[zParent]) {
            parent[zParent] = xParent;
        } else if (rank[zParent] > rank[xParent]) {
            parent[xParent] = zParent;
        } else {
            parent[xParent] = zParent;
            rank[zParent]++;
        }
    }


    public boolean isConnected(int nodeOne, int nodeTwo) {
        return findParent(nodeOne) == findParent(nodeTwo);
    }
}
