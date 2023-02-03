package exceptions;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException() {
        super("Invalid operation status code requested!");
    }

    public InvalidRequestException(String message) {
        super(message);
    }
}
