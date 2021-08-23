//public class UserException extends Exception{
public class UserException extends RuntimeException {
    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
