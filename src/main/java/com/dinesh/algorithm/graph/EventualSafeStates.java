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

    /**
     *
     * Intuition
     * Mark all visited paths as false and if you are visiting the same path again then there is a loop.
     * If there is a loop , just directly return false and don't mark it as safe node by marking true;
     */
    public List<Integer> eventualSafeNodesMap(int[][] graph) {
        Map<Integer, Boolean> map = new HashMap<>();

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < graph.length; i++)
            if(dfs(i, graph, map))
                safeNodes.add(i);

        return safeNodes;

    }

    private boolean dfs(int node, int[][] graph, Map<Integer, Boolean> map) {
        if(map.containsKey(node))
            return map.get(node);
        map.put(node, false);
        for(int ad: graph[node])
            if(!dfs(ad, graph, map))
                return false;

        map.put(node, true);
        return true;
    }

}
