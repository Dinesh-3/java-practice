package thread;

public class DownloadFileTask implements Runnable {

  private DownloadStatus status;

  public DownloadFileTask() {
    this.status = new DownloadStatus();
  }

  @Override
  public void run() {
    System.out.println("Downloading a file: " + Thread.currentThread().getName());

    for (var i = 0; i < 100_000_000; i++) {
//      if (Thread.currentThread().isInterrupted()) return;
      status.incrementTotalBytes();
    }

//    status.done();

    System.out.println("Download complete: " + Thread.currentThread().getName());
  }

}
