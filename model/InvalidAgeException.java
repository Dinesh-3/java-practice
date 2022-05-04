package model;

public class InvalidAgeException extends Exception{ // Checked exception
    public InvalidAgeException(String message) {
        super(message);
        super.getCause();
        getCause(); // super keyword optional for fields and methods
    }
}
