package thread;

import com.dinesh.io.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ConcurrencyMain {
    public static void main(String[] args) throws InterruptedException {
        DownloadStatus downloadStatus = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        List<Customer> customers = new ArrayList<>();
        while (true) {
            thread.DownloadFileTask downloadFileTask = new thread.DownloadFileTask();
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
//            customers.add(new Customer("Random", "Random", "sds", (byte)8, LocalDate.now(), (int) Math.random()));
//            customers.addAll(customers);
//            Thread.sleep(10);
            System.out.println("customers = " + customers);
//            downloadFileTask.run();
//            threads.add(thread);
        }
//        try {
//            for(var thread: threads)
//                thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        long endTime = System.currentTimeMillis();
//        long duration = (endTime - startTime);
//        int totalBytes = downloadStatus.getTotalBytes();
//        System.out.println("totalBytes = " + totalBytes);
//        System.out.println("duration = " + duration / 1000);

//        List<Integer> totalFiles = new Concu

    }
}
