package thread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Thread.currentThread() = " + Thread.currentThread().getName());
        System.out.println("Thread.activeCount() = " + Thread.activeCount());
        System.out.println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors());
        System.out.println("true = " + true);
        DownloadFile downloadFile = new DownloadFile();
//        downloadFile.downloadFile();
    }
}
