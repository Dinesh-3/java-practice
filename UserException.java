//public class UserException extends Exception{ // checked exception
public class UserException extends RuntimeException { // unchecked exception
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
