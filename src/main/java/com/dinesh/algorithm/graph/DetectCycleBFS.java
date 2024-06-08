package com.dinesh.algorithm.graph;

import java.util.*;

public class DetectCycleBFS {

    class Pair {
        int data;
        int parent;

        public Pair(int data, int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Set<Integer> set = new HashSet<>();

        Queue<Pair> queue = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(set.contains(i))
                continue;

            queue.add(new Pair(i, -1));
            set.add(i);

            while(!queue.isEmpty()) {
                Pair vert = queue.remove();

                for(var it : adj.get(vert.data)) {
                    if(set.contains(it)) {
                        if(vert.parent != it)
                            return true;
                    } else {
                        queue.add(new Pair(it, vert.data));
                        set.add(it);
                    }
                }
            }

        }

        return false;
    }

}
