package com.dinesh.thread;

import java.util.LinkedList;

class SharedQueue {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int CAPACITY = 5;

    // Producer will add numbers to the list
    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            // If the list is full, wait for the consumer to consume
            while (list.size() == CAPACITY) {
                System.out.println("Queue is full, producer waiting...");
                wait();  // releases the lock on the object
            }

            System.out.println("Produced: " + value);
            list.add(value++);
            // Notify the consumer that an item is produced
            notify();  // wakes up a waiting consumer
            Thread.sleep(1000);  // simulate delay in production
        }
    }

    // Consumer will consume numbers from the list
    public synchronized void consume() throws InterruptedException {
        while (true) {
            // If the list is empty, wait for the producer to produce
            while (list.isEmpty()) {
                System.out.println("Queue is empty, consumer waiting...");
                wait();  // releases the lock on the object
            }

            int value = list.removeFirst();
            System.out.println("Consumed: " + value);
            // Notify the producer that an item is consumed
            notify();  // wakes up a waiting producer
            Thread.sleep(1000);  // simulate delay in consumption
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        // Create producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedQueue.produce();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                sharedQueue.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start both threads
        producerThread.start();
        consumerThread.start();
    }
}
