package com.dinesh.algorithm.graph.spanning_tree;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 827. Making A Large Island
 * https://leetcode.com/problems/making-a-large-island
 *
 * Making a Large Island
 * https://www.youtube.com/watch?v=lgiz0Oup6gM
 *
 */
public class MakingLargeIsland {
    public class DisjointSet {
        int[] size;
        int[] parent;

        public DisjointSet(int len) {
            int[] initSize = new int[len];
            int[] init = new int[len];
            for(int i = 0; i < len; i++) {
                init[i] = i;
                initSize[i] = 1;
            }
            this.parent = init;
            this.size = initSize;
        }

        public int getParent(int k) {
            if(parent[k] == k)
                return k;
            int root = getParent(parent[k]);
            parent[k] = root;
            return root;
        }

        public void unionBySize(int u, int v) {
            int parentU = getParent(u);
            int parentV = getParent(v);
            if(parentU == parentV)
                return;
            if(size[parentU] > size[parentV]) {
                parent[parentV] = parentU;
                size[parentU] += size[parentV];
            } else {
                parent[parentU] = parentV;
                size[parentV] += size[parentU];
            }
        }

        public int getSize(int parent) {
            return size[parent];
        }

    }
    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DisjointSet set = new DisjointSet(row*col);

        int[][] paths = { {1,0}, {0,1}, {-1,0}, {0,-1} };

        int numberOfOnes = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    numberOfOnes++;
                    for(int[] path: paths) {
                        int rowIndex = i + path[0];
                        int colIndex = j + path[1];
                        if(rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col
                                && grid[rowIndex][colIndex] == 1
                        ) {
                            set.unionBySize(i*col + j, rowIndex*col + colIndex);
                        }
                    }
                }
            }
        }

        if(numberOfOnes == row*col)
            return numberOfOnes;

        int max = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 0) {

                    Set<Integer> parents = new HashSet<>();

                    for(int[] path: paths) {
                        int rowIndex = i + path[0];
                        int colIndex = j + path[1];
                        if(rowIndex >= 0 && rowIndex < row && colIndex >= 0 && colIndex < col
                                && grid[rowIndex][colIndex] == 1
                        ) {
                            parents.add(set.getParent(rowIndex*col + colIndex));
                        }
                    }

                    int total = 1;
                    for(int parent: parents)
                        total += set.getSize(parent);
                    max = Math.max(total, max);
                }
            }
        }

        return max;

    }

}
