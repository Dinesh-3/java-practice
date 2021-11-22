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
        try {
            return true;
        }finally {
            System.out.println("cleaning.. ");
            return false;
        }
    }
}
