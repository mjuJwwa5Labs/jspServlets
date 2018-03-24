package twitter.exceptions;

public class DatabaseException extends TwitterExecption {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
