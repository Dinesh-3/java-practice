package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class ConcurrencyMain {
    public static void main(String[] args) {
        DownloadStatus downloadStatus = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            DownloadFileTask downloadFileTask = new DownloadFileTask();
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();
            downloadFileTask.run();
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
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        int totalBytes = downloadStatus.getTotalBytes();
        System.out.println("totalBytes = " + totalBytes);
        System.out.println("duration = " + duration / 1000);

//        List<Integer> totalFiles = new Concu

    }
}
