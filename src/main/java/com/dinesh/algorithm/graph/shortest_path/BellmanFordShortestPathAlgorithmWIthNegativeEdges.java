package com.dinesh.algorithm.graph.shortest_path;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Distance from the Source (Bellman-Ford Algorithm)
 * https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm
 *
 * https://www.youtube.com/watch?v=0vVofAhAYjc
 *
 */
public class BellmanFordShortestPathAlgorithmWIthNegativeEdges {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distances = new int[V];
        Arrays.fill(distances, (int) 1e8);
        distances[S] = 0;

        for(int i = 0; i < V-1;i++) {
            for(ArrayList<Integer> edge: edges) {
                if(distances[edge.get(0)] != 1e8 && distances[edge.get(0)] + edge.get(2) < distances[edge.get(1)])
                    distances[edge.get(1)] = distances[edge.get(0)] + edge.get(2);
            }
        }

        for(ArrayList<Integer> edge: edges) {
            if(distances[edge.get(0)] != 1e8 && distances[edge.get(0)] + edge.get(2) < distances[edge.get(1)])
                return new int[]{ -1 };
        }

        return distances;

    }

}
