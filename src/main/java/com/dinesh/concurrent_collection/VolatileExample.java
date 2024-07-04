package com.dinesh.concurrent_collection;

public class VolatileExample {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Do some work
        }
        System.out.println("Thread stopped.");
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(example::run);
        t1.start();

        Thread.sleep(1000); // Let the thread run for a while

        example.stop(); // Request the thread to stop
        t1.join(); // Wait for the thread to finish
        System.out.println("Main thread finished.");
    }
}
