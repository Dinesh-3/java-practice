package com.dinesh.thread;

public class ThreadWaitNotifyNotifyAll {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    static class SharedResource {
        private int value = 0;
        private boolean available = false;

        public synchronized void produce(int newValue) {
            while (available) {
                try {
                    wait(); // Wait until the value is consumed
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            value = newValue;
            available = true;
            System.out.println("Produced: " + value);
            notify(); // Notify the consumer that a new value is available
        }

        public synchronized void consume() {
            while (!available) {
                try {
                    wait(); // Wait until a new value is produced
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            available = false;
            System.out.println("Consumed: " + value);
            notify(); // Notify the producer that the value is consumed
        }
    }

    static class Producer implements Runnable {
        private SharedResource resource;

        public Producer(SharedResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                resource.produce(i);
                try {
                    Thread.sleep(100); // Simulate time taken to produce a value
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private SharedResource resource;

        public Consumer(SharedResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                resource.consume();
                try {
                    Thread.sleep(150); // Simulate time taken to consume a value
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
