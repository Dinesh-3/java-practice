package com.dinesh.algorithm.graph.spanning_tree;

public class SpanningTreeMain {
    public static void main(String[] args) {

        DisjointSet disjointSet = new DisjointSet(7);

        int[][] edges = { {1,2}, {2,3}, {4,5}, {6,7}, {5,6} };
        int[][] edges2 = { {3,7} };

        for(int[] edge: edges)
            disjointSet.unionByRank(edge[0], edge[1]);

        int parentOfX = disjointSet.findParent(5);
        int parentOfY = disjointSet.findParent(5);

        if(parentOfX == parentOfY)
            System.out.println("Same");
        else
            System.out.println("Not Same");

    }
}
