package com.dinesh.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        Runnable task = example::interruptableLock;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();

        try {
            // Delay the second thread slightly so the first one acquires the lock first
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        // Interrupt the second thread while it's waiting for the lock
        t2.interrupt();
    }

    private final Lock lock = new ReentrantLock();

    public void interruptableLock() {
        try {
            // Try to acquire the lock in an interruptible manner
            lock.lockInterruptibly();
            try {
                // Critical section
                System.out.println(Thread.currentThread().getName() + " acquired the lock");
                // Simulate some work
                Thread.sleep(2000);
            } finally {
                lock.unlock();  // Always unlock in a finally block
                System.out.println(Thread.currentThread().getName() + " released the lock");
            }
        } catch (InterruptedException e) {
            // Handle the interrupt
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock");
        }
    }


}
