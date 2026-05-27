package exception;

public class WithdrawalAlreadyReceivedException extends RuntimeException {
    public WithdrawalAlreadyReceivedException(String message) {
        super(message);
    }
}
