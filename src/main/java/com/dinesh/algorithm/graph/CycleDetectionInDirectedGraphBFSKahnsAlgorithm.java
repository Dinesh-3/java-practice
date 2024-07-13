package com.dinesh.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Cycle Detection in Directed Graph (BFS)
 * https://www.youtube.com/watch?v=iTBaI90lpDQ
 *
 */
public class CycleDetectionInDirectedGraphBFSKahnsAlgorithm {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {

        return topoSortBFS(V, adj);

    }

    static int[] topoSortBFS(int V, ArrayList<ArrayList<Integer>> adj)
    {

        int[] inDegrees = new int[V];

        for(int i = 0; i < adj.size(); i++)
            for(int node: adj.get(i))
                inDegrees[node]++;

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegrees.length; i++)
            if(inDegrees[i] == 0)
                queue.add(i);

        int[] result = new int[V];
        int index = 0;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            result[index++] = node;
            for(var ad: adj.get(node)) {
                inDegrees[ad]--;
                if(inDegrees[ad] == 0)
                    queue.add(ad);
            }
        }

        return result;

    }
}
