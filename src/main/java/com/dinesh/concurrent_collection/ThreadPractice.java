package com.dinesh.concurrent_collection;

public class ThreadPractice {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");

        t1.start();
        t2.start();

        Thread runnableThread = new Thread(new MyRunnable(), "MyRunnable Thread");
        runnableThread.start();

        try {
            System.out.println("===Waiting for threads to finish===");
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("===All threads have finished===");
    }

}
