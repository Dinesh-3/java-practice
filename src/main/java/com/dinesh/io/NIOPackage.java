package com.dinesh.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class NIOPackage {
    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("example.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * Write File
         *
         */

        List<String> lines = Arrays.asList("Hello, World!", "Welcome to file I/O in Java.");
        try {
            Files.write(Paths.get("example.txt"), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("source.txt");
        Path target = Paths.get("target.txt");
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         *
         * Moving / Renaming a File
         *
         */
        try {
            Files.move(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Path path = Paths.get("example.txt");
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
