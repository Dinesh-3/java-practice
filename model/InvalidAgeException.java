package model;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String message) {
        super(message);
        super.getCause();
        getCause(); // super keyword optional for fields and methods
    }
}
