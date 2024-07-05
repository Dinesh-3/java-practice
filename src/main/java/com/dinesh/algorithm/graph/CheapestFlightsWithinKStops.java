package com.dinesh.algorithm.graph;

import java.util.*;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops kStops = new CheapestFlightsWithinKStops();
        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        kStops.findCheapestPrice(n, flights, src, dst, k);
    }
    class Pair {
        int node;
        int dis;
        int level;
        public Pair(int node, int dis, int level) {
            this.node = node;
            this.dis = dis;
            this.level = level;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : flights) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2], 0));
        }

        Integer[] distances = new Integer[n];
        distances[src] = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0, 0));

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            if(pair.level > k)
                continue;
            for(var ad: adj.get(pair.node)) {

                if(distances[ad.node] == null || distances[ad.node] > pair.dis + ad.dis )
                {
                    distances[ad.node] = pair.dis + ad.dis;
                    queue.add(new Pair(ad.node, pair.dis + ad.dis, pair.level + 1));
                }
            }
        }

        return distances[dst] == null ? -1 : distances[dst];

    }

}
