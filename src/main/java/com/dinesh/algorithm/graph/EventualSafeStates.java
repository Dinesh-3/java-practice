package com.dinesh.algorithm.graph;

import java.util.*;

/**
 * 802. Find Eventual Safe States
 * https://leetcode.com/problems/find-eventual-safe-states
 *
 */
public class EventualSafeStates {

    public static void main(String[] args) {
        EventualSafeStates states = new EventualSafeStates();
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> nodes = states.eventualSafeNodes(graph);
        System.out.println("nodes = " + nodes);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int[] visited = new int[graph.length];
        int[] paths = new int[graph.length];

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == 1)
                continue;
            dfs(i, graph, paths, visited, result);
        }

        result.sort(Comparator.naturalOrder());
        return result;

    }

    private boolean dfs(int i, int[][] graph, int[] paths, int[] visited, List<Integer> result) {
        paths[i] = 1;
        for(var ed: graph[i]) {
            if(visited[ed] == 1)
                continue;
            else if(paths[ed] == 1)
                return true;
            else {
                if(dfs(ed, graph, paths, visited, result))
                    return true;
            }
        }

        visited[i] = 1;
        paths[i] = 0;
        result.add(i);
        return false;

    }
}
