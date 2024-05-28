package com.dinesh.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapMain {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(3);
        maxHeap.add(18);
        maxHeap.add(9);
        maxHeap.add(13);

        int max = maxHeap.max();
        System.out.println("max = " + max);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        queue.add(3);
        queue.element();
        queue.remove();
    }
}
