package tricky;

import java.io.IOException;

public class WindowsSystem {
    public static void main(String[] args) throws IOException {
        String path = "dir";
        byte[] resultBytes = Runtime.getRuntime().exec(path).getInputStream().readAllBytes();
        String result = new String(resultBytes);
        System.out.println("result = " + result);
    }
}
