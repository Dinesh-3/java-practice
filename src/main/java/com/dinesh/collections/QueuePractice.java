package com.dinesh.collections;

import java.util.*;

/**
 *  QUEUE
 *  FrontEnd -> Remove
 *  RearEnd (or) Last -> Add (Rear == Back)
 */
public class QueuePractice {
    public static void main(String[] args) {

        /**
         *   Deque -> Double Ended Queue Item can be added and removed from both end
         *   public interface Deque<E> extends Queue<E>
         *   Implementation: ArrayDeque -> Resizable Array, no capacity restrictions, Default Array Size = 16
         *
         *          We have alternative methods that don't
         *          throw an exception:
         *
         *          offer() similar to add()
         *          poll() similar to remove()
         *          peek() similar to element()
         */
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.remove(); // Removes first
        var front = queue.remove();
        List<Integer> room = new ArrayList<>();
        front = queue.element(); // Throws error if queue is Empty

        System.out.println(front);
        System.out.println(queue);

        /**
         * Priority Queue
         * Initial Capacity -> 11
         *  High priority elements served first irrespective of an insertion order
         *  Ascending Order
         */
        System.out.println("--- PRIORITY QUEUE ---");
        Queue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(4);
        integers.add(0);
        integers.add(2);
        integers.add(3);
        Integer peeked = integers.peek();

        Queue<Integer> minHeap = new PriorityQueue<>(); // ascending order || smallest element has high priority
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // descending order

        int n = 10;
        for (int i = 0; i < n; i++) {
            int number = (int) Math.round(Math.random()*n);
            minHeap.add(number);
            maxHeap.add(number);
        }

        System.out.println("minHeap = " + minHeap);
        System.out.println("maxHeap = " + maxHeap);

        System.out.println("integers = " + integers);
        System.out.println("integers.element() = " + integers.element());
        System.out.println("integers.remove() = " + integers.remove());
        System.out.println("integers.element() = " + integers.element());

    }
}