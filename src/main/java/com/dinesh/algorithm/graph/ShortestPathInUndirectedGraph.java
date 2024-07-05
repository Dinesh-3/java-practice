package com.dinesh.algorithm.graph;

import java.util.*;

/**
 * Dijra's Shortest Path Algorithm
 */
public class ShortestPathInUndirectedGraph {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        int[] paths = new int[n];

        Arrays.fill(paths, -1);

        List<List<Integer>> adList = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adList.get(edge[0]).add(edge[1]);
            adList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        paths[src] = 0;

        while(!queue.isEmpty()) {
            int edge = queue.remove();

            for(int ad: adList.get(edge)) {
                if(paths[ad] == -1 || paths[ad] > paths[edge] + 1) {
                    paths[ad] = paths[edge] + 1;
                    queue.add(ad);
                }
            }
        }

        return paths;
    }

}
