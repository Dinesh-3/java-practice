package io;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;

/**
 * transient is a variables modifier used in serialization. At the time of serialization, 
 * if we don’t want to save value of a particular variable in a file, then we use transient keyword. 
 * When JVM comes across transient keyword, it ignores original value of the variable 
 * and save default value of that variable data type.
 *
 * SerialID:
 *  1. Serial Id used for versioning.
 *      By default JVM creates serialId based on the hash of fullyQualifiedClassName implements extends names
 *      If any changes happen in the class we can't deserialize the object with updated class. In this case we
 *      need to add our own serialization like below
 *      @Serial
 *      private static final long serialVersionUID = -2856907389312536747L;
 *      With this eventhough we have done change in the class it will not throw InvalidClassException
 *      If we change the serialId then only it will through error because serial id mismatch
 *  1. One JVM implementation of serial id is different other JVMs So It will InvalidClassException
 *      So we need to add our own serial id as static field
 */
public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(Paths.get("").toAbsolutePath()+"/src/main/java/com/dinesh/io/dinesh.txt");
        System.out.println("file = " + file);
        file.createNewFile();

        Customer dinesh = new Customer("Dinesh", "I", "Male", "India", (byte) 21, LocalDate.now(), 1212);
        serialize(dinesh, file);
        Customer dineshOuted = deSerialize(file);
        System.out.println("dineshOuted = " + dineshOuted);
        dineshOuted.setLastName("-I");
        serialize(dineshOuted, file);

        Customer againDeSerialize = deSerialize(file);
        System.out.println("againDeSerialized Customer= " + againDeSerialize);

        Movie movie = new Movie("Ayan", "Ayan actor Surya", "Action", 14);
        File ayanFile = new File(Paths.get("").toAbsolutePath()+"/io/ayan.txt");

        FileOutputStream outputStream = new FileOutputStream(ayanFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(movie);

        FileInputStream inputStream = new FileInputStream(ayanFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object ayan = objectInputStream.readObject();
        System.out.println("movie = " + ayan);
    }

    //        DESERIALIZATION
    private static Customer deSerialize(File file) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Customer) objectInputStream.readObject();
    }

    //        SERIALIZATION
    private static void serialize(Customer dinesh, File file) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dinesh); // 2GB Limit for Linux more than that throw error
    }

}

