package exception;

public class CustomerMovementsNotFoundException extends RuntimeException {
    public CustomerMovementsNotFoundException(String message) {
        super(message);
    }
}