package com.dinesh.thread;

public class DeadlockExample {

    static class Resource {
        private final String name;

        public Resource(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Thread1 extends Thread {
        private final Resource resourceA;
        private final Resource resourceB;

        public Thread1(Resource resourceA, Resource resourceB) {
            this.resourceA = resourceA;
            this.resourceB = resourceB;
        }

        public void run() {
            synchronized (resourceA) {
                System.out.println("Thread 1: Locked " + resourceA.getName());

                // Simulating some work with sleep
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resourceB) {
                    System.out.println("Thread 1: Locked " + resourceB.getName());
                }
            }
        }
    }

    static class Thread2 extends Thread {
        private final Resource resourceA;
        private final Resource resourceB;

        public Thread2(Resource resourceA, Resource resourceB) {
            this.resourceA = resourceA;
            this.resourceB = resourceB;
        }

        public void run() {
            synchronized (resourceB) {
                System.out.println("Thread 2: Locked " + resourceB.getName());

                // Simulating some work with sleep
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resourceA) {
                    System.out.println("Thread 2: Locked " + resourceA.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Resource resourceA = new Resource("ResourceA");
        Resource resourceB = new Resource("ResourceB");

        Thread1 t1 = new Thread1(resourceA, resourceB);
        Thread2 t2 = new Thread2(resourceA, resourceB);

        t1.start();
        t2.start();
    }
}

