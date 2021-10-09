package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Working with threads has lot issues and error-prone. So java 5 comes with high level abstraction on thread called ExecutiveFramework
 * Topics:
 *  1. Thread pool
 *  2. Executors
 *  3. Callable and Future and Interfaces
 *  4. Asynchronous Programming
 *  5. Completable Features
 */
public class ExecutiveFramework {
    public static void main(String[] args) {
        /**
         * Thread Pool:
         *  Thread pool list of worker threads . We can assign a bunch of works. This pool will execute all the operation in
         *  ascending order. Given Tasks are stored in a queue.
         *  We can specify how Many threads in a thread pool.
         * It will help in thread manipulation. It doesn't solve the concurrency issues
         * Executor:
         *  1. In Java the concept of thread pool is represented using ExecutorService interface, and it's implementation
         *  Interface: Executor
         *  Sub Interface: ExecutorService, ScheduledExecutorService
         *  Implementations: AbstractExecutorService, ForkJoinPool, ScheduledThreadPoolExecutor, ThreadPoolExecutor
         */

        ExecutorService executorService = Executors.newFixedThreadPool(5);// Contains static factory method's to create instance of executors
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);// Contains static factory method's to create instance of executors
        try {
            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                executorService.submit(() -> System.out.println("Task: " + finalI +" Thread: " + Thread.currentThread().getName()));
            }
            System.out.println();
            executorService2.submit(() -> System.out.println("executorService2 Thread = " + Thread.currentThread().getName()));
//        List<Runnable> tasks = new ArrayList<>();
//        tasks.add(() -> System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()));
//        tasks.add(() -> System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()));
//        tasks.add(() -> System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName()));
//        for(var task: tasks)
//            executorService.submit(task);

            // Callable Interface and Future
            Future<String> future = executorService.submit(() -> {
                LongTask.simulate();
                return Thread.currentThread().getName(); // Callable Interface returns Future
            });
            System.out.println("Other tasks running before get future in Thread: " + Thread.currentThread().getName());
            String result = future.get(); // Blocks the current Thread to wait for completion
            System.out.println("result = " + result);
            System.out.println("Other tasks running after get future in Thread: " + Thread.currentThread().getName());

        } catch (ExecutionException | InterruptedException e) {
            // ExecutionException is contains Exception that happen in assigned operation
            e.printStackTrace();
        } finally {
            executorService.shutdown(); // Will shut down after all worker threads finishes the given tasks
            executorService2.shutdownNow(); // It forces the executor to stop even task not finished their execution
//        executorService2.shutdown(); below code will throw because of shutdown the executor
        }



    }

    private static void compose() {
        CompletableFuture.supplyAsync(() -> "Email")
                .thenCompose(email -> CompletableFuture.supplyAsync(() -> "Print"))
                .thenAccept((result) -> System.out.println("result = " + result));
    }
}
