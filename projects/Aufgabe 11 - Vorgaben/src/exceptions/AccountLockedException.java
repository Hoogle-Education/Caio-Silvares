package exceptions;

public class AccountLockedException extends AccountException {

    public AccountLockedException(String message) {
        super(message);
    }

}
