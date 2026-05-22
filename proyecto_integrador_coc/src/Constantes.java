public class Constantes {
    public static final double SALDO_MIN = 1000.00;
    public static final double SALDO_MAX = 100000.00;
    public static final double CANTIDAD_MAX_DEPOSITO = 45000.00;
    public static final double MAX_RETIRO_DIARIO = 12000.00;
    public static final String ACCOUNT_NOT_FOUND = "No existe la cuenta. Imposible continuar"; // Constante de excepción
    public static final String MAX_DAILY_WITHDRAWAL_EXCEEDED = "Retiro no disponible, se ha superado la cantidad de retiro diaria permitida"; // Constante de excepción
    public static final String INVALID_QUANTITY_EXCEPTION = "Monto inválido, debe ser múltiplo de $100"; // Constante de excepción
    public static final String INSUFFICIENT_BALANCE = "Saldo insuficiente"; // Constante de excepción
    public static final String MINIMUM_ALLOWED = "Retiro no disponible, excede el mínimo permitido en la cuenta"; // Constante de excepción
    public static final String MAX_QUANTITY_DEPOSIT = "Monto máximo de depósito superado, deposite en ventanilla"; // Constante de excepción
    public static final String OVER_MAXIMUM = "Depósito no disponible, saldo máximo superado"; // Constante de excepción
}