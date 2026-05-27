package constants;

public class Constantes {

    public static final double SALDO_MIN = 1000;
    public static final double SALDO_MAX = 100000;
    public static final double CANTIDAD_MAX_DEPOSITO = 45000;
    public static final double MAX_RETIRO_DIARIO = 12000.0;

    public static final String ACCOUNT_NOT_FOUND = "NO EXISTE LA CUENTA! IMPOSIBLE CONTINUAR.";
    public static final String MAX_DAILY_WITHDRAWAL_EXCEEDED = "Retiro no disponible, se ha superdao la cantidad diariade retiro";
    public static final String INVALID_QUANTITY = "El monto a retirar debe ser multiplo de de 100";
    public static final String ONLY_POSITIVE = "Deben ser catidades positivas";
    public static final String INSUFFICENT_BALANCE = "Saldo insuficiente";
    public static final String UNDER_MINIMUM = "Retiro no disponible, Excede el minimo permitido";

    public static final String MAX_QUANTITY_DEPOSIT = "Monto maximo superado. Deposite en ventanilla";
    public static final String OVER_MAXIMUM = "Deposito no disponible, saldo maximo superado";

    public static final String INVALID_CARD_NUM = "Retiro invalido, numero de tarjeta no encontrado.";
    public static final String WITHDRAWAL_ALREADY_RECEIVED = "Retiro ya cobrado";
    public static final String CUSTOMER_MOVEMENTS_NOT_FOUND="No se encontraron movimientoS asociados al cliente";
}
