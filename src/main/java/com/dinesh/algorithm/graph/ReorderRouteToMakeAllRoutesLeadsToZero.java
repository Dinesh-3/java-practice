package com.dinesh.algorithm.graph;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class ReorderRouteToMakeAllRoutesLeadsToZero {
    public int minReorder(int n, int[][] connections) {
        Set<String> edges = new HashSet<>();
        for(var edge: connections)
            edges.add(edge[0] + "," + edge[1]);

        Map<Integer, List<Integer>> neighbours = new HashMap<>();

        for(var edge: connections) {
            var edge1 = neighbours.getOrDefault(edge[0], new ArrayList<>());
            edge1.add(edge[1]);

            var edge2 = neighbours.getOrDefault(edge[1], new ArrayList<>());
            edge1.add(edge[0]);

            neighbours.put(edge[0], edge1);
            neighbours.put(edge[1], edge2);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        int reorderCount = 0;
        Stack<Integer> dfs = new Stack<>();
        dfs.add(0);
        while (!dfs.isEmpty()) {
            Integer pop1 = dfs.pop();
            for (Integer neighbour : neighbours.get(pop1)) {
                if(visited.contains(neighbour))
                    continue;
                if(!edges.contains(neighbour + "," + pop1))
                    reorderCount++;
                visited.add(neighbour);
                dfs.add(neighbour);
            }
        }

        return reorderCount;
    }
}
