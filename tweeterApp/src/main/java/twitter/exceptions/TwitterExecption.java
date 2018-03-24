package twitter.exceptions;

public class TwitterExecption extends Exception {

    public TwitterExecption(String message) {
        super(message);
    }

    public TwitterExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
