package io;

import java.io.*;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * STREAM -> sequence of data
 * Types:
 *  1. Char Stream
 *  2. Byte Stream
 */
public class Main {
    public static void main(String[] args) throws IOException{
        try {
//            System.out.println(10>>2);
//            Serialization.main();

            var file = new File("/home/dinesh/Downloads/Java Practice/io/sdfsdf.csv");

//            boolean isFileDeleted = file.delete();// To delete file
//            if(isFileDeleted) System.out.println( " Deleted Successfully");
//            else System.out.println("Unable to delete.File Doesn't exist !");
            // FILE LOCATION API
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            String parent = file.getParent(); // Returns Parent Folder

            URI uri = file.toURI();
            System.out.println("uri = " + uri);

            boolean isDirectory = file.isDirectory();
            boolean isFile = file.isFile();

            System.out.println("name = " + name);
            System.out.println("absolutePath = " + absolutePath);
            System.out.println("parent Folder Path = " + parent);
            System.out.println("isDirectory = " + isDirectory);
            System.out.println("isFile = " + isFile);
            System.out.println("file.lastModified() = " + file.lastModified());
            // FILE PERMISSIONS
            // To get User privileges of the file
            boolean canExecute = file.canExecute();
            boolean canRead = file.canRead();
            boolean canWrite = file.canWrite();
            System.out.println("canRead = " + canRead);
            System.out.println("canWrite = " + canWrite);
            System.out.println("canExecute = " + canExecute);

            file.setExecutable(true); // Set File Executable
            file.setReadable(true);
            file.setWritable(true,true);
//            file.setReadOnly();
            System.out.println("file.canExecute() = " + file.canExecute());

            boolean isFileCreated = file.createNewFile();
            if(isFileCreated) System.out.println("File Created: "+name);
            else System.out.println("File Already Exist: " + name);

            boolean isFileExists = file.exists();
            System.out.println("isFileExists = " + isFileExists);

            System.out.println("file size in bytes file.length() = " + file.length());

//            GET SIZE
            /* 🔥 DIFFERENCE GET USABLE SPACE AND GET FREE SPACE 🔥
            Note very importantly that getUsableSpace is not equal to getFreeSpace.
            On Linux file systems for example, partitions very often 
            have a number of reserved blocks.
            These are included in the value returned by getFreeSpace()
            but not in the value from getUsableSpace().
            So if you are interested in how much space you have to write files in, use getUsableSpace -
            NOT getFreeSpace()
             */
            double freeSpace = file.getFreeSpace() / (1024.0 * 1024 * 1024);
            double totalSpace = file.getTotalSpace() / (1024.0 * 1024 * 1024);
            double usableSpace = file.getUsableSpace() / (1024.0 * 1024 * 1024);
            System.out.printf("Free Space %.3f GB\n", freeSpace);
            System.out.printf("Total Space %.3f GB\n", totalSpace);
            System.out.printf("Usable Space %.3f GB\n", usableSpace);

            boolean mkdir = file.mkdir(); // To create directory
            String[] listFiles = file.list();

//            writeFile("customer.csv");

//            readFile();
            bufferWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bufferWriter() throws IOException {
        /**
         * Writes text to a character-output stream, buffering characters
         * to provide for the efficient writing of single characters, arrays, and strings.
         */
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/dinesh/Downloads/Java Practice/io/buffer.txt"));
        writer.write("Hello World\n");
        writer.write("From JAVA\n");
        writer.close();
    }

    private static void writeFile( String file) throws IOException {
        Scanner scanner = new Scanner(file);

        List<Customer> customers = new ArrayList<>();

        scanner.nextLine();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (scanner.hasNext()) {
//                Pattern compile = Pattern.compile("(\"[^\",]+),([^\"]+\")");

            String[] userDetails = scanner.nextLine()
                    .replaceAll("(\"[^\",]+),([^\"]+\")", "$1$2")
                    .replaceAll("\"", "")
                    .split(",");
//                System.out.println(userDetails[6]);
            LocalDate date = LocalDate.parse(userDetails[6], dateFormat);

            var customer = new Customer(userDetails[1], userDetails[2], userDetails[3], userDetails[4], Byte.parseByte(userDetails[5]), date, Integer.parseInt(userDetails[7]));
            customers.add(customer);
        }
        FileWriter fileWriter = new FileWriter("./" + file);

        for(var customer: customers)
            fileWriter.append(customer.toString());
        //            for (var customer: customers) {
//                System.out.println("customer = " + customer);
//            }

    }

    private static void readFile() {
        var file = new File("/home/dinesh/Downloads/Java Practice/io/IOPractise.java");
        try {
            System.out.println("INSIDE JAVA READ");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
                System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
