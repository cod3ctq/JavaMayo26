package exception;

public class InsufficentBalanceExeption extends RuntimeException {
    public InsufficentBalanceExeption(String message) {
        super(message);
    }
}
