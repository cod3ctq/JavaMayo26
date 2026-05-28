package exception;

public class WithdrawalAlreadyRecievedException extends RuntimeException {
    public WithdrawalAlreadyRecievedException(String message) {
        super(message);
    }
}
