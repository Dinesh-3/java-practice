package com.dinesh.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimedLockExample {
    private final Lock lock = new ReentrantLock();

    public void performTask() {
        boolean acquired = false;
        try {
            // Try to acquire the lock within 1 second
            acquired = lock.tryLock(0, TimeUnit.SECONDS);
            if (acquired) {
                // Critical section
                System.out.println("Lock acquired, performing the task." + Thread.currentThread());
            } else {
                // Handle the case where the lock was not acquired
                System.out.println("Could not acquire lock, performing alternative actions." + Thread.currentThread());
            }
        } catch (InterruptedException e) {
            // Handle the interruption
            System.out.println("Thread was interrupted.");
        } finally {
            // Ensure the lock is released if it was acquired
            if (acquired) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        TimedLockExample example = new TimedLockExample();
        Runnable task = example::performTask;

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}

