package com.dinesh.concurrent_collection;

class MyThread extends Thread {
    private String threadName;

    MyThread(String name) {
        threadName = name;
    }

    public void run() {
        try {
            System.out.println(threadName + " is running.");
            Thread.sleep(2000); // Simulates some work being done
            System.out.println(threadName + " has finished.");
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
    }
}
