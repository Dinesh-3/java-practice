package thread;

public class ThreadSignaling {
    public static void main(String[] args) {
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
}
