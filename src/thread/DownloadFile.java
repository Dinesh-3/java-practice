package thread;

public class DownloadFile {
    public boolean downloadFile() {
        for (int i = 0; i <= 1_000_000; i++) {
            System.out.println("Downloading bytes = " + i + Thread.currentThread().getName());
        }
        return true;
    }
}
