package com.dinesh.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Minimum Multiplications to reach End
 * https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end
 *
 * https://www.youtube.com/watch?v=_BvEJ3VIDWw
 *
 */
public class MinimumMultiplicationsToReachEnd {
    class Pair {
        int node;
        int dis;
        public Pair(int node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;
        Integer[] distances = new Integer[100000];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        distances[0] = 0;
        int mod = 100000;

        while(!queue.isEmpty()) {
            Pair pair = queue.remove();
            if(pair.node == end)
                return pair.dis;
            for(int num: arr) {
                int newNum = (pair.node * num) % mod;
                int newDis = pair.dis + 1;
                if(newNum == end)
                    return newDis;
                if(distances[newNum] == null || distances[newNum] > newDis) {
                    distances[newNum] = newDis;
                    queue.add(new Pair(newNum, newDis));
                }


            }
        }

        return -1;

    }
}
