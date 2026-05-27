package exception;

public class WithdrawalAlreadyReceived extends RuntimeException {
    public WithdrawalAlreadyReceived(String message) {
        super(message);
    }
}
