package com.dinesh.algorithm.graph;

import java.util.*;

/**
 * 841. Keys and Rooms
 *
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces
 *
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        new NumberOfProvinces().findCircleNum();
    }

    public int findCircleNum() {
        int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < isConnected.length; i++) {
            adjacencyList.put(i, new ArrayList<>());
            for(int j = 0; j < isConnected[i].length; j++) {
                if(isConnected[i][j] == 1)
                    adjacencyList.get(i).add(j);
            }
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(var key: adjacencyList.keySet()) {
            if(!visited.contains(key))
                count++;
            Stack<Integer> stack = new Stack<>();
            stack.push(key);

            while(!stack.isEmpty()) {
                Integer node = stack.pop();
                visited.add(node);
                for(var connected: adjacencyList.get(node)) {
                    if(!visited.contains(connected))
                        stack.push(connected);
                }
            }

        }

        return count;
    }

    public int findCircleNum(int[][] isConnected) {

        int count = 0;

        List<List<Integer>> adList = new ArrayList<>();

        for(int i = 0; i < isConnected.length; i++) {
            adList.add(new ArrayList<>());
            for(int j = 0; j < isConnected[0].length; j++) {
                if(isConnected[i][j] == 1)
                    adList.get(i).add(j);
            }
        }

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < adList.size(); i++) {
            if(visited.contains(i))
                continue;
            count++;
            dfs(i, adList, visited);
        }

        return count;

    }

    private void dfs(int i, List<List<Integer>> adList, Set<Integer> visited) {
        visited.add(i);
        for(var it: adList.get(i))
            if(!visited.contains(it))
                dfs(it, adList, visited);
    }

}
