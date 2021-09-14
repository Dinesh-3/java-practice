package io;

import java.io.*;
import java.time.LocalDate;

public class Serialization {
    public static void main() throws IOException, ClassNotFoundException {
        Customer dinesh = new Customer("Dinesh", "I", "Male", "India", (byte) 21, LocalDate.now(), 1212);
        File file = new File("dinesh.txt");
        serialize(dinesh, file);

        Customer dineshOuted = deSerialize(file);
        String country = dineshOuted.getCountry();
        System.out.println("country = " + country);
        System.out.println("dineshOuted = " + dineshOuted);
        dineshOuted.setLastName("-I");
        serialize(dineshOuted, file);

        Customer againDeSerialize = deSerialize(file);
        System.out.println("country = " + againDeSerialize);
    }

    //        DESERIALIZATION
    private static Customer deSerialize(File file) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Customer dineshOuted = (Customer) objectInputStream.readObject();
        return dineshOuted;
    }

    //        SERIALIZATION
    private static void serialize(Customer dinesh, File file) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dinesh); // 2GB Limit for Linux more than that throw error
    }

}

