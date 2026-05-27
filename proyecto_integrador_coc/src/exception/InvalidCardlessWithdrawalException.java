package exception;

public class InvalidCardlessWithdrawalException extends RuntimeException {
    public InvalidCardlessWithdrawalException(String message) {
        super(message);
    }
}