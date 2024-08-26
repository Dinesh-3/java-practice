package com.dinesh.algorithm.greedy;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * Page Faults in LRU
 * https://www.geeksforgeeks.org/problems/page-faults-in-lru5603
 *
 */
public class PageFaultsInLRU {
    static int pageFaults(int N, int C, int pages[]){

        int fault = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int current : pages) {
            if (queue.contains(current)) {
                queue.remove(current);
                queue.add(current);
            } else {
                if (queue.size() == C)
                    queue.remove();
                queue.add(current);
                fault++;
            }
        }
        return fault;


    }

}
