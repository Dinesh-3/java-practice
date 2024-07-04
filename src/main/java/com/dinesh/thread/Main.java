package thread;

/**
 * Concurrency issues:
 * 1. Race Condition
 * 2. Visibility Problem
 *
 * Thread safe: code which can safely be used or shared in concurrent or multi-threading environment,
 *              and they will behave as expected.
 *
 * Strategy to Resolve concurrency issues
 * 1. Confinement -> (don't share data, passing each data to particular thread and at last add all data)
 * 2. Immutability
 * 3. Synchronization
 * 4. Atomic objects
 * 5. Partition
 *
 * Thread Life Cycle:
 * 1. NEW – a newly created thread that has not yet started the execution
 * 2. RUNNABLE – either running or ready for execution, but it's waiting for resource allocation
 * 3. BLOCKED – waiting to acquire a monitor lock to enter or re-enter a synchronized block/method
 * 4. WAITING – waiting for some other thread to perform a particular action without any time limit
 * 5. TIMED_WAITING – waiting for some other thread to perform a specific action for a specified period
 * 6. TERMINATED – has completed its execution
 *
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        threadMethods();
//        threadSignaling();
//        daemonThread();
    }

    public static void threadMethods() {
        System.out.println("\n--- THREAD METHODS ---\n");
        // We can create a thread using a lambda expression
        var thread1 = new Thread(() -> System.out.println(String.format("Thread: %s is running... STATE: %s",Thread.currentThread().getName(), Thread.currentThread().getState())));

        Thread parentThread = new Thread(() -> { // Thread inside Thread
            System.out.println(String.format("Thread: %s is running...",Thread.currentThread().getName()));
            Thread childThread = new Thread(() -> {System.out.println(String.format("Thread: %s is running...",Thread.currentThread().getName()));}, "Child-Thread");
            childThread.start();
        }, "Parent-Thread");

        parentThread.start();

        // or using an instance of a class that implements the Runnable interface
        var status = new DownloadStatus();
        var thread2 = new Thread(new DownloadFileTask(), "Dinesh-Thread"); // Specifying thread name constructor

        thread1.setName("Dinesh-Thread"); // Set Thread Name
        System.out.println("thread1.getState() = " + thread1.getState());
        thread1.start();
        System.out.println("thread1.start() Executed ");
        //    thread1.stop();
//    thread1.setDaemon(true); // Low priority JVM doesn't wait for this thread to finish execution
        String thread1Name = thread1.getName();
        long thread1Id = thread1.getId();
        System.out.println("thread1Id = " + thread1Id);
        System.out.println("thread1.getPriority() = " + thread1.getPriority());
        thread1.interrupt();
        System.out.println("thread1.isAlive() = " + thread1.isAlive());
        System.out.println("thread1.isDaemon() = " + thread1.isDaemon());
        System.out.println("thread1.isInterrupted() = " + thread1.isInterrupted());
        /**
         * start creates a new thread while the run doesn't create any thread and
         * simply executes in the current Main thread like a normal method call.
         */
        thread1.run();
        System.out.println("thread1.getState() = " + thread1.getState());

        System.out.println("\n--- END ---\n");
    }

    public static void show() {
        // We can create a thread using a lambda expression
        var thread1 = new Thread(() -> System.out.println("a"));

        // or using an instance of a class that implements the Runnable interface
        var status = new DownloadStatus();
        var thread2 = new Thread(new DownloadFileTask());

        // Next we start a thread
        thread1.start();
//    thread1.stop();
        thread1.setName("Dinesh Thread");
        // We can wait for the completion of a thread
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // We can put a thread to sleep
        try {
            thread1.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // We can get the current thread
        var current = Thread.currentThread();
        System.out.println(current.getId());
        System.out.println(current.getName());
    }

    public static void threadSignaling() {
        System.out.println("\n*** THREAD SIGNALING ***\n");
        var status = new DownloadStatus();
        Thread thread1 = new Thread(new DownloadFileTask(status));

        // Wrong way
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Waiting for " + thread1.getName() + " to finish");
            int whileCount = 0;
            while (!status.isDone()){
                whileCount++;
            }
            System.out.println("Thread "+ Thread.currentThread().getName() + " started Processing");
            System.out.println("whileCount = " + whileCount);
        });

        // Wright way using wait and notify || Asynchronous Programming
        Thread thread3 = new Thread(() -> {
            System.out.println("Waiting for thread " + thread1.getName() + " to finish");
            int whileCount = 0;
            while (!status.isDone()){
                try {
                    whileCount++;
                    synchronized (status) {
                        status.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread "+ Thread.currentThread().getName() + " started Processing");
            System.out.println("whileCount = " + whileCount);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void daemonThread() {
        /*
            Daemon thread in java is a service provider thread that provides services
            to the user thread. Its life depend on the mercy of user threads i.e.
            when all the user threads dies, JVM terminates this thread automatically.

            There are many java daemon threads running automatically e.g. gc, finalizer etc.

            You can see all the detail by typing the jconsole in the command prompt.
            The jconsole tool provides information about the loaded
            classes, memory usage, running threads etc.
         */

        Thread thread = new Thread(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            System.out.println("ID: " + Thread.currentThread().getId());
        });
        thread.start();
//        thread.setDaemon(true);

//  thread.start();// Throws IllegalThreadStateException start method needTo called atOnce per instance
    }
}
