package twitter.exceptions;

public class TwitterAuthorizationException extends TwitterExecption {

    public TwitterAuthorizationException(String message) {
        super(message);
    }

    public TwitterAuthorizationException(String message, Throwable cause) {
        super(message, cause);
    }
}
