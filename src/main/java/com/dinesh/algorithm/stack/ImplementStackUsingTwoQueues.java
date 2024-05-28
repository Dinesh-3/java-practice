package com.dinesh.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/description/
 *
 * https://www.youtube.com/watch?v=jDZQKzEtbYQ
 * https://takeuforward.org/data-structure/implement-stack-using-single-queue/
 *
 * Implement Stack in Single Queue
 *
 * get queue size
 * step 1: in push method add item to the queue
 * step 2: get queue size and for size - q times remove item and add again to the queue
 * that's it while doing pop the first element in queue will contain last inserted item
 */
public class ImplementStackUsingTwoQueues {
    Queue<Integer> queueOne = new ArrayDeque<>();
    Queue<Integer> queueTwo = new ArrayDeque<>();

    public ImplementStackUsingTwoQueues() {

    }

    public void push(int x) {
        queueTwo.add(x);
        copyQueueOneToTwo();
        copyQueueTwoToOne();
    }

    private void copyQueueTwoToOne() {
        while (!queueTwo.isEmpty())
            queueOne.add(queueTwo.remove());
    }

    private void copyQueueOneToTwo() {
        while (!queueOne.isEmpty())
            queueTwo.add(queueOne.remove());
    }

    public int pop() {
        return queueOne.remove();
    }


    public int top() {
        return queueOne.element();
    }

    public boolean empty() {
        return queueOne.isEmpty();
    }
}
