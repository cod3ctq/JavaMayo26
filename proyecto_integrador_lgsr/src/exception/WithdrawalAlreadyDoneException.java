package exception;

public class WithdrawalAlreadyDoneException extends RuntimeException {
    public WithdrawalAlreadyDoneException(String message) {
        super(message);
    }
}
