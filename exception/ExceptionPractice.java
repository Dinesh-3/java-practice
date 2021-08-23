package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPractice {
    public static void main(String[] args) {
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
//        Option 2
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
}
