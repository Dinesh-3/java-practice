package com.dinesh.datastructure.queue;

public class QueueMain {
    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        queue.enqueue(10);
        queue.enqueue(30);
        queue.enqueue(20);
        queue.enqueue(40);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        PriorityQueue priority = new PriorityQueue(8);
        priority.insert(30);
        priority.insert(80);
        priority.insert(10);
        priority.insert(60);
        priority.insert(20);

        System.out.println(priority.remove());

        int val = -82_345_823;
        System.out.println( val % 500);

    }
}
