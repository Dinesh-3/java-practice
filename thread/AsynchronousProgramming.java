package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Asynchronous Programming Using CompletableFuture class
 */
public class AsynchronousProgramming {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " Started..");
        CompletableFuture.runAsync(() -> System.out.println("Async without return any value Thread: " + Thread.currentThread().getName()));
        CompletableFuture<String> sent = CompletableFuture.supplyAsync(sendEmail()); // Program terminates but code still executed
//        while (!sent.isDone()){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Not Done");
//        }
        sent.thenApplyAsync(sendSms())
//      .thenAccept(result -> System.out.println(result)) // with result
        .thenRun(() -> System.out.println("mailSend Then Thread: "+ Thread.currentThread().getName())) // without result
//        .thenRunAsync(() -> System.out.println("mailSend Then Thread: "+ Thread.currentThread().getName()));
//        .thenAcceptAsync()
//                .get() // Blocks Main thread
        ;
        combine();
        System.out.println(Thread.currentThread().getName() + " Ended..");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Supplier<String> sendEmail() {
       return () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Asynchronous non blocking execution in Thread: " + Thread.currentThread().getName());
            System.out.println("Email Sent Successfully");
            return "Thread: " + Thread.currentThread().getName() + " TASK: SEND_EMAIL";
        };
    }

    private static Function<String, String> sendSms() {
        return (result) -> {
            try {
                System.out.println("Result of First Async: " + result);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SMS Message Sent Successfully");
            return "Thread: " + Thread.currentThread().getName() + " TASK: SEND_SMS";
        };
    }

    private static void handlingExceptions() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(" Getting Fruit Name From API");
            return "APPLE";
        });

        try {
            future
                    .exceptionally((e) -> {
                        System.out.println("Exception Thrown = " + e.getCause().getMessage());
//                        throw new NoSuchElementException(); // If exception thrown exceptionally value is returned
                        return "DEFAULT";
                    })
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void combine() {
        /**
         * Combining two Completable feature results
         */
        System.out.println("--- Combine Completable Future Start ---");
        double PI = 3.14;
        final var task1 = CompletableFuture.supplyAsync(() -> "Task 1 Result PI = "+ PI);
        var task2 = CompletableFuture.supplyAsync(() -> "Task 2 Result");
        var task3 = CompletableFuture.supplyAsync(() -> "Task 3 Result");

        task1.thenCombine(task2, (result1, result2) -> result1 + " " + result2)
                .thenAccept(result -> System.out.println("result = " + result));
        System.out.println("--- Combine Completable Future BEFORE allOf(task1, task2, task3) ---");
        // all method
        CompletableFuture<Void> all = CompletableFuture.allOf(task1, task2, task3);
        all.thenRun(() -> {
            try {
                String result1 = task1.get();
                String result2 = task2.get();
                String result3 = task3.get();
                System.out.printf("ALL %s, %s, %s\n", result1, result2, result3);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        System.out.println("--- Combine Completable Future After ALL ---");
        CompletableFuture<Integer> getWeatherSlow = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 10;
        });

        CompletableFuture<Integer> getWeatherFast = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture.anyOf(getWeatherSlow, getWeatherFast) // return value from first completed task
                .thenAccept(result -> System.out.println("result = " + result));

        try {
            getWeatherSlow
                    .orTimeout(1, TimeUnit.SECONDS) // throw error if given task is not done with given time
                    .get();
            /**
             * if the task take more than the given time it returns default value
             */
            getWeatherSlow
                    .completeOnTimeout(1,1, TimeUnit.SECONDS)
                    .get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
