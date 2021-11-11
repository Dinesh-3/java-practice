package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPractice {
    public static void main(String[] args) throws Exception {

        checkBlockOrder();
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

    }

    private static void checkBlockOrder() throws Exception {
        try {
            System.out.println("TRY BLOCK");
            throw new Exception("Try Thrown exception");
        }catch (Exception e){
            System.out.println("CATCH BLOCK");
//            throw new Exception("Catch Thrown exception");
        }finally {
            System.out.println("FINALLY BLOCK");
        }
    }

    private static boolean isValid() {
        try {
            return true;
        }finally {
            System.out.println("cleaning.. ");
            return false;
        }
    }
}
