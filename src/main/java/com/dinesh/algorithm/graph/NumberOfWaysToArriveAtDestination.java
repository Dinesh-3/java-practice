package com.dinesh.algorithm.graph;

import java.util.*;

/**
 * 1976. Number of Ways to Arrive at Destination
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
 *
 * https://www.youtube.com/watch?v=_-0mx0SmYxA
 *
 */
public class NumberOfWaysToArriveAtDestination {
    class Node {
        int node;
        long weight;
        public Node(int node, long weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<List<Node>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] road: roads) {
            adj.get(road[0]).add(new Node(road[1], road[2]));
            adj.get(road[1]).add(new Node(road[0], road[2]));

        }


        long[] distances = new long[n];
        Arrays.fill(distances, Long.MAX_VALUE);
        int[] ways = new int[n];

        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingLong(node -> node.weight));
        queue.add(new Node(0, 0));
        distances[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9 + 7);

        while(!queue.isEmpty()) {
            Node node = queue.remove();
            for(Node ad: adj.get(node.node)) {
                long newDistance = node.weight + ad.weight;
                if(distances[ad.node] > newDistance) {
                    distances[ad.node] = newDistance;
                    ways[ad.node] = ways[node.node] % mod;
                    queue.add(new Node(ad.node, newDistance));
                }
                else if(distances[ad.node] == newDistance) {
                    ways[ad.node] = (ways[ad.node] + ways[node.node]) % mod;
                }

            }
        }

        return ways[n-1] % mod;


    }
}
