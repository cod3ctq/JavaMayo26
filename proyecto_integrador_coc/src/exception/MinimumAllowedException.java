package exception;

public class MinimumAllowedException extends RuntimeException {
    public MinimumAllowedException(String message) {
        super(message);
    }
}