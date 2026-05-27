package constants;

public class Constantes {
    public static final String ONLY_POSITIVE = "Monto inválido, debe ser positivo"; // Constante de excepción
    public static final double CANTIDAD_MAX_DEPOSITO = 45000.00;
    public static final double MAX_RETIRO_DIARIO = 12000.00;
    public static final String ACCOUNT_NOT_FOUND = "No existe la cuenta. Imposible continuar"; // Constante de excepción
    public static final String MAX_DAILY_WITHDRAWAL_EXCEEDED = "Retiro no disponible, se ha superado la cantidad de retiro diaria permitida"; // Constante de excepción
    public static final String INVALID_QUANTITY = "Monto inválido, debe ser múltiplo de $100"; // Constante de excepción
    public static final String INSUFFICIENT_BALANCE = "Saldo insuficiente"; // Constante de excepción
    public static final String MINIMUM_ALLOWED = "Retiro no disponible, excede el mínimo permitido en la cuenta"; // Constante de excepción
    public static final String MAX_QUANTITY_DEPOSIT = "Monto máximo de depósito superado, deposite en ventanilla"; // Constante de excepción
    public static final String OVER_MAXIMUM = "Depósito no disponible, saldo máximo superado"; // Constante de excepción
    public static final String INVALID_CARDLESS_WITHDRAWAL = "Retiro sin tarjeta inválido"; // Constante de excepción
    public static final String CARDLESS_WITHDRAWAL_PROCESSED = "Retiro sin tarjeta ya cobrado anteriormente"; // Constante de excepción
    public static final String CUSTOMER_MOVEMENTS_NOT_FOUND = "No se encontraron movimientos asociados al cliente"; // Constante de excepción
}