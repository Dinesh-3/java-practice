package com.dinesh.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class FileInputStreamExample {
    public static void main(String[] args) {
        String path = Paths.get("").toAbsolutePath() + "/src/main/java/com/dinesh/io/customer.csv";
        try (FileInputStream fis = new FileInputStream(path)) {
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String data = "Hello, World!";
        try (FileOutputStream fos = new FileOutputStream("example.txt")) {
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

