package com.dinesh.algorithm.graph.shortest_path;

import java.util.*;

public class DijkstraAlgorithmGetShortestPath {
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        int[][][] arr = {{{1, 9}, {2, 1}, {3, 1}}, {{3, 3}}, {{3,2}}};
        int S = 0;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                adj.get(i).add(new ArrayList<>(List.of(arr[i][j][0], arr[i][j][1])));
            }
        }

        dijkstra(V, adj, S);
    }

    static class Pair {
        int dis;
        int node;
        public Pair(int dis, int node) {
            this.dis = dis;
            this.node = node;
        }
    }


    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        int size = V;

        int[] parents = new int[size];
        int[] distances = new int[size];
        Arrays.fill(distances, -1);

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.dis));
        queue.add(new Pair(0, S));

        distances[S] = 0;
        parents[S] = S;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            int node = pair.node;

            for(var ad: adj.get(node)) {
                int newDistance = pair.dis + ad.get(1);
                if(distances[ad.get(0)] == -1 || distances[ad.get(0)] > newDistance) {
                    distances[ad.get(0)] = newDistance;
                    parents[ad.get(0)] = node;
                    queue.add(new Pair(newDistance, ad.get(0)));
                }
            }
        }

        int node = size - 1;

        List<Integer> result = new ArrayList<>();

        while(node != parents[node]) {
            result.add(distances[node]);
            node = parents[node];
        }
        result.add(distances[S]);

        int[] arr = new int[result.size()];

        int j = 0;
        for(int i = arr.length - 1; i >= 0; i--)
            arr[j++] = result.get(i);

        return new int[]{ 1, 2, 3, 4, 4, };

    }

}
