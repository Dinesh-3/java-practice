package com.dinesh.algorithm.graph.spanning_tree;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Most Stones Removed with Same Row or Column
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column
 *
 * https://takeuforward.org/data-structure/most-stones-removed-with-same-row-or-column-dsu-g-53/
 *  https://www.youtube.com/watch?v=OwMNX8SPavM
 *
 */
public class MostStonesRemovedWithSameRowOrColumn {
    private class DisjointSet {
        int[] size;
        int[] parent;

        public DisjointSet(int n) {
            this.size = new int[n+1];
            int[] initParent = new int[n+1];
            for(int i = 0; i <= n; i++)
                initParent[i] = i;
            this.parent = initParent;
        }

        public boolean isConnected(int u, int v) {
            int uParent = getParent(u);
            int vParent = getParent(v);

            return uParent == vParent;
        }

        public int getParent(int v) {
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
    }

    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxColumn = 0;

        for(int[] point: stones) {
            maxRow = Math.max(maxRow, point[0]);
            maxColumn = Math.max(maxColumn, point[1]);
        }

        DisjointSet set = new DisjointSet(maxRow + maxColumn + 1);

        Set<Integer> places = new HashSet<>();
        for(int[] edge: stones) {
            int colNode = maxRow + edge[1] + 1;
            set.unionBySize(edge[0], colNode);
            places.add(edge[0]);
            places.add(colNode);
        }

        int rootParents = 0;

        for(int node: places)
            if(node == set.getParent(node))
                rootParents++;

        return stones.length - rootParents;
    }

}
