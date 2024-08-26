package com.dinesh.concurrent_collection;

import java.util.concurrent.TimeUnit;

/**
 *
 * The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads. Declaring a variable as volatile ensures that changes to the variable are immediately visible to all threads. It is used in multithreaded programming to prevent threads from caching variables and thereby reading stale values.
 *
 * Key Points of volatile Keyword
 * Visibility: When a variable is declared as volatile, it ensures that the value of the variable is always read from and written to the main memory, rather than from a thread's local cache. This guarantees visibility of changes across threads.
 *
 * Atomicity: volatile only ensures visibility but does not guarantee atomicity. For instance, compound actions like check-then-act or read-modify-write operations are not atomic with volatile.
 *
 * No Caching: The volatile keyword prevents caching variables in the CPU cache or registers, ensuring that every read of the variable is from the main memory.
 *
 */
public class VolatileExample {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            // Do some work
//            System.out.println("TimeUnit.MILLISECONDS = " + TimeUnit.MILLISECONDS);
        }
        System.out.println("Thread stopped.");
    }

    public void stop() {
        running = false;
    }

    public static void main(String[] args) throws InterruptedException {
//        volatileUseCase();
        mainVolatileTrustIssues();
    }

    private static void volatileUseCase() throws InterruptedException {
        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(example::run);
        t1.start();

        Thread.sleep(1000); // Let the thread run for a while

        example.stop(); // Request the thread to stop
        t1.join(); // Wait for the thread to finish
        System.out.println("Main thread finished.");
    }


    private static volatile int counter = 0;

    public static void mainVolatileTrustIssues() {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 100000; i++) {
                counter += i;
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter);
    }


}
