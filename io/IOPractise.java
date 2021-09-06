package io;

import java.io.*;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class IOPractise {
    public static void main(String[] args) {
        try {
            var file = new File("/home/dinesh/Downloads/Java Practice/io/customer.csv");

//            boolean isFileDeleted = file.delete();// To delete file
//            if(isFileDeleted) System.out.println( " Deleted Successfully");

//            for (int i = 0; i < 1_000_000_000; i++) {
//                System.out.println("LOOPED: "+ i);
//            }
            
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

//            boolean isFileCreated = file.createNewFile();
//            if(isFileCreated) System.out.println("File Created: "+name);
//            else System.out.println("File Already Exist: " + name);

            boolean isFileExists = file.exists();
            System.out.println("isFileExists = " + isFileExists);

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

//            for (var customer: customers) {
//                System.out.println("customer = " + customer);
//            }
            writeFile("customer.csv", customers);

            Serialization.main();
            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String fileName, List<Customer> customers) throws IOException {
        FileWriter fileWriter = new FileWriter("./" + fileName);

        for(var customer: customers)
            fileWriter.append(customer.toString());

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
