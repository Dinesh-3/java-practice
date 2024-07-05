package com.dinesh.algorithm.graph;

import java.util.*;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int[][] times = { {2,1,1}, {2,3,1}, {3,4,1} };
        int n = 4;
        int k = 2;

        NetworkDelayTime network = new NetworkDelayTime();
        network.networkDelayTime(times, n, k);
    }

    class Pair {
        int node;
        int dis;
        public Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        n = n + 1;
        Integer[] distances = new Integer[n];
        distances[k] = 0;

        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] time : times)
            adj.get(time[0]).add(new Pair(time[1], time[2]));

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.dis));
        queue.add(new Pair(k, 0));

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();

            for(var ad: adj.get(pair.node)) {
                int newDistance = pair.dis + ad.dis;
                if(distances[ad.node] == null || distances[ad.node] > newDistance) {
                    distances[ad.node] = newDistance;
                    queue.add(new Pair(ad.node, newDistance));
                }
            }
        }

        int max = 0;

        for(int i = 1; i < n; i++) {
            if(distances[i] == null)
                return -1;
            max = Math.max(distances[i], max);
        }

        return max;

    }

}
