package exceptions;

public class AccountMustBeDifferentException extends RuntimeException {
    public AccountMustBeDifferentException() {
        super("Destiny Account can't be the same as origin");
    }
}
