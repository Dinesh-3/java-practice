package com.dinesh.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Cycle Detection in Directed Graph (BFS)
 * https://www.youtube.com/watch?v=iTBaI90lpDQ
 *
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph
 *
 */
public class TopologicalSortBFSKahnsAlgorithm {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegrees = new int[V];

        for(int i = 0; i < adj.size(); i++)
            for(int node: adj.get(i))
                inDegrees[node]++;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegrees.length; i++)
            if(inDegrees[i] == 0)
                queue.add(i);

        int result = 0;
        int index = 0;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            result++;
            for(var ad: adj.get(node)) {
                inDegrees[ad]--;
                if(inDegrees[ad] == 0)
                    queue.add(ad);
            }
        }

        return result == V ? false : true;

    }

}
