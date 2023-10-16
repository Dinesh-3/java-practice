package thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
  private boolean isDone;
  private AtomicInteger totalBytes = new AtomicInteger();
//  private LongAdder totalBytes = new LongAdder();
  private int totalFiles;

  public int getTotalBytes() {
    return totalBytes.get();
  }

  public void incrementTotalBytes() {
    totalBytes.incrementAndGet();
  }

  public void incrementTotalFiles() {
    totalFiles++;
  }

  public int getTotalFiles() {
    return totalFiles;
  }

  public boolean isDone() {
    return isDone;
  }

  public void done() {
    isDone = true;
  }
}
