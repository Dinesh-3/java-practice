package io;

import java.io.*;
import java.net.URI;
import java.nio.file.Paths;
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
            int[] nums = {23,23,232,35,45};
//            System.out.println(10>>2);
//            Serialization.main();

            System.out.println("Paths.get(\"\").toAbsolutePath() = " + Paths.get("").toAbsolutePath());
            var file = new File("/home/dinesh/Downloads/java_practice/io/sdfsdf.csv");

//            boolean isFileDeleted = file.delete();// To delete file
//            if(isFileDeleted) System.out.println( " Deleted Successfully");
//            else System.out.println("Unable to delete.File Doesn't exist !");

            System.out.println("file.getName() = " + file.getName());
            System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
            System.out.println("parent Folder Path file.getParent() = " + file.getParent());
            System.out.println("URI uri = file.toURI(); = " + file.toURI());
            System.out.println("file.isDirectory(); = " + file.isDirectory());
            System.out.println("file.isFile() = " + file.isFile());
            System.out.println("file.exists() = " + file.exists());
            System.out.println("file.lastModified() = " + file.lastModified());

            System.out.println("\n*** FILE PERMISSIONS ***\n");
            // To get model.User privileges of the file
            System.out.println("file.canRead() = " + file.canRead());
            System.out.println("file.canWrite(); = " + file.canWrite());
            System.out.println("file.canExecute() = " + file.canExecute());

            boolean isFileCreated = file.createNewFile();
            if(isFileCreated) System.out.println("File Created: "+file);
            else System.out.println("File Already Exist: " + file);

            System.out.println("file.setReadOnly(); = " + file.setReadOnly());
            System.out.println("file.setExecutable(true); = " + file.setExecutable(true));
            System.out.println("file.setReadable(true) = " + file.setReadable(true));
            System.out.println("file.setWritable(true,true) = " + file.setWritable(true, true));


            System.out.println("To create directory file.mkdir() = " + file.mkdir());
            System.out.println("String[] listFiles = file.list(); = " + file.list());

            System.out.println("file size in bytes file.length() = " + file.length());

            System.out.println("\n*** FILE / FOLDER SIZE ***\n");
            /** 🔥 DIFFERENCE GET USABLE SPACE AND GET FREE SPACE 🔥
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
        BufferedWriter writer = new BufferedWriter(new FileWriter(Paths.get("").toAbsolutePath() +"/io/buffer.txt"));
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
        var file = new File("/home/dinesh/Downloads/java_practice/io/IOPractise.java");
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
