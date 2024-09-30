package exceptions;

public class BalanceMustBeEqualOrAboveAmountException extends RuntimeException {
    public BalanceMustBeEqualOrAboveAmountException() {
        super("Balance must be equal or above amount sent");
    }
}
