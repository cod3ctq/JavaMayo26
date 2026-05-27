package exception;

public class InvalidWithdrawalWithoutCardException extends RuntimeException {
    public InvalidWithdrawalWithoutCardException(String message) {
        super(message);
    }
}
