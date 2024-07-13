package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 *                                      Throwable
 *                      Error                       Exception ( CheckedException and UncheckedException )
 *              OutOfMemoryError            ArrayIndexOutOfBoundException
 *              StackOverflowError          NullPointerException
 *              VirtualMachineError
 *
 *  CheckedException -> IOException, ClassNotFoundException
 *  UncheckedException -> ArrayIndexOutOfBoundException, NullPointerException
 *
 *  Interview Quesitons:
 *
 *  1. When an exception is thrown by main method. Java runtime terminates the program
 *      and prints the exception stack trace in the system console
 *  2. What is meant by unreachable catch block error
 *      It will happen , when there is multiple catch blocks, super class first and cub class later ( generic once above and more specific one below )
 *
 */
public class ExceptionPractice {
    public static void main(String[] args) throws Exception {

        try {
//            throw new StackOverflowError("Overlow"); // Program terminates
        }finally {
            System.out.println("sdsd");
        }

        if(true)
            throw new IllegalAccessException("Illegal Statement");

        if(true)
            throw new IllegalAccessException("Illegal Statement");

//        throw new IllegalAccessException("Illegal Statement"); // Unreachable Statement compile time error
//        throw new IllegalAccessException("Illegal Statement"); // Unreachable Statement compile time error

        System.out.println("Continuing my work = " );

        /**
         * What is Multi catch block
         *
         * Introduced in Java 7
         * Catch block with multiple exceptions. Class must be in same level of inheritance
         *
         */
        try {
            int[] arr = { 3 };
            System.out.println(arr[3]);
        }catch (IndexOutOfBoundsException | NullPointerException  e) { // Types in multi-catch must be disjoint: 'java.lang.ArrayIndexOutOfBoundsException' is a subclass of 'java.lang.Exception'
            System.out.println(e);
        }

        try{
            checkBlockOrder();
        } finally { // try needs catch or finally

        }
        System.out.println("isValid(); = " + isValid()); // returns false
//        Option 1
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }finally {
            if(fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println("e.getMessage() = " + e.getMessage());
                }
            }
        }
//        Option 2 Classes that are implementing AutoClosable
        try(
                FileReader fileReader1 = new FileReader("file.txt")
        ) {
            int read = fileReader1.read();
        }
        catch (FileNotFoundException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        catch ( IOException e) {
            e.printStackTrace();
        }

//        fileReader1 // We can't access try with resource fields

    }

    private static void checkBlockOrder() throws Exception {
        try {
            try {
                System.out.println("TRY BLOCK"); // Step 1
                throw new Exception("Try Thrown exception");
            }catch (Exception e){
                System.out.println("CATCH BLOCK"); // Step 2
                throw new Exception("Catch Thrown exception"); // Step 5
            }
            finally {
                System.out.println("FINALLY BLOCK LEVEL 2"); // step 3
//                System.exit(0); // step 4 // it will stop the process so catch throwned not executed
            }
        }catch (Exception e){
            System.out.println("e = " + e);
        }finally {
            System.out.println("FINALLY BLOCK LEVEL 1");
        }
    }

    private static boolean isValid() {
        // Always returns false
        try {
            return true;
        }finally {
            System.out.println("cleaning.. ");
            return false;
        }
    }
}
