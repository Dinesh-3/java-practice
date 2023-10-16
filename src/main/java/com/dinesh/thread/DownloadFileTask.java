package thread;

public class DownloadFileTask implements Runnable {

  private DownloadStatus status;

  public DownloadFileTask() {
    this.status = new DownloadStatus();
  }
  public DownloadFileTask(DownloadStatus status) {
//    this.status = new DownloadStatus();
    this.status = status;
  }

  @Override
  public void run() {
    System.out.println("Downloading a file Task started with Thread: " + Thread.currentThread().getName());

    for (var i = 0; i < 1_000_000; i++) {
      if (Thread.currentThread().isInterrupted()) {
        System.out.printf("%s Thread Interrupted stopping... ", Thread.currentThread().getName());
        return;
      };
      status.incrementTotalBytes();
    }

    status.done();
    synchronized (status) {
      status.notifyAll();
    }
    System.out.println("Downloading a file Task completed with Thread: " + Thread.currentThread().getName());
  }

}
