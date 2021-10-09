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
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        System.out.println("true = " + true);
        DownloadFile downloadFile = new DownloadFile();
//        downloadFile.downloadFile();
        daemonThread();

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
