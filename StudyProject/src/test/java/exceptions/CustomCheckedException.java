package exceptions;

public class CustomCheckedException extends Exception {
    public CustomCheckedException(String errorMessage) {
        super(errorMessage);
    }

    public CustomCheckedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
