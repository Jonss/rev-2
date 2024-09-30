package exceptions;

public class AmountMustBePositiveException extends RuntimeException {
    public AmountMustBePositiveException() {
        super("Amount must be positive");
    }
}
