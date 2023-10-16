package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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

        // Creating Thread Manually All implements ExecutorService
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10, r -> new Thread(r));
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        ExecutorService executorService = Executors.newFixedThreadPool(5);// Contains static factory method's to create instance of executors
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);// Contains static factory method's to create instance of executors
//        Executors.newCachedThreadPool();
//        Executors.newWorkStealingPool();
        Executors.newSingleThreadExecutor();
        Executors.callable(() -> {
            System.out.printf("%s Thread is started: ", Thread.currentThread().getName());
        });
        Executors.privilegedCallable(() -> Thread.currentThread().getName());
//        Executors.unconfigurableExecutorService()
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
            AtomicInteger sampleNumber = new AtomicInteger(100);
            // Callable Interface and Future
            Future<String> future = executorService.submit(() -> {
                LongTask.simulate();
                sampleNumber.set(20);
                return Thread.currentThread().getName(); // Callable Interface returns Future
            });
            System.out.println("sampleNumber.get(); = " + sampleNumber.get());
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
//        executorService2.shutdown(); below code will throw because of already shutdown the executor in above
        }
        compose();

    }

    private static void compose() {
        System.out.println("Before Completable Future ");
        CompletableFuture.supplyAsync(() -> "Email")
                .thenCompose(email -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return CompletableFuture.supplyAsync(() -> "Print");
                })
//                .thenApply() // blocks current thread
                .thenApplyAsync((result) -> { // not blocks main thread
                    System.out.println("result = "  + result);
                    return result+" $";
                })
//                .thenRun() // blocks, with no param, no return
//                .thenAccept() // blocks, Consumer with 1 result param
//                .thenAcceptAsync() // non block

        ;
        System.out.println("After Completable Future ");

    }
}
