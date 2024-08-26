package com.dinesh.concurrent_collection;

class MyThread extends Thread {
    private String threadName;

    MyThread(String name) {
        super(name);
        threadName = name;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is running.");
            Thread.sleep(2000); // Simulates some work being done
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
