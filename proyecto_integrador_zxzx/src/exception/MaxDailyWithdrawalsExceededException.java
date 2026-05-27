package exception;

public class MaxDailyWithdrawalsExceededException extends RuntimeException {
    public MaxDailyWithdrawalsExceededException(String message) {
        super(message);
    }
}
