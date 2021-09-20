package thread;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Asynchronous Programming Using CompletableFuture class
 */
public class AsynchronousProgramming {
    public static void main(String[] args) {
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
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Supplier<String> sendEmail() {
       return () -> {
            try {
                Thread.sleep(3000);
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
}
