package com.dinesh.algorithm.graph;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumImportance {

    public static void main(String[] args) {
        MaximumImportance importance = new MaximumImportance();
        int n = 5;
        int[][] roads = {{0, 1}, {1, 2}, {2, 3}, {0, 2}, {1, 3}, {2, 4}};
        importance.maximumImportance(n, roads);
    }

    public long maximumImportance(int n, int[][] roads) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }

        SortedMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < adj.size(); i++)
            map.put(adj.get(i).size(), i);

        Map<Integer, Integer> weigths = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>(map.values());
        for (int i = 0; i < integers.size(); i++) {
            weigths.put(integers.get(i), i + 1);
        }

        int sum = 0;

        for (int[] road : roads) {
            sum += weigths.get(road[0]);
            sum += weigths.get(road[1]);
        }

        return sum;

    }
}
