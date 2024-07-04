package exceptions;

public class CustomUncheckedException extends RuntimeException{
    public CustomUncheckedException(String errorMessage) {
        super(errorMessage);
    }

    public CustomUncheckedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
