package io;

import java.io.*;
import java.time.LocalDate;

public class Serialization {
    public static void main() throws IOException, ClassNotFoundException {
        Customer dinesh = new Customer("Dinesh", "I", "Male", "India", (byte) 21, LocalDate.now(), 1212);
        File file = new File("dinesh.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dinesh);

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Customer dineshOuted = (Customer) objectInputStream.readObject();
        System.out.println("dineshOuted = " + dineshOuted);
    }
}

