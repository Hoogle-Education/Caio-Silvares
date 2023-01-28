package exceptions;

public class EmptyEntryException extends InvalidJournalEntryException {

    public EmptyEntryException(String message) {
        super(message);
    }

}
