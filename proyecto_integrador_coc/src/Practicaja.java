import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{ // Hereda de 1 e implementa de 2

    @Override
    public void cobrarRetiroSinTarjeta() {
    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {
        Ticket ticket = null;
        Cuenta cuenta = buscarCuenta(numTarjeta, nip);
        if (! (cuenta != null)) { // Si la cuenta NO existe...
            System.out.println("La cuenta no existe, no es posible depositar"); // Lanzamos mensaje
        } else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) { // Si el monto a depositar es mayor a la cantidad máxima permitida
            System.out.println("Monto máximo superado, deposite en ventanilla"); // Lanzamos mensaje
        } else if ((monto + cuenta.getSaldo()) > Constantes.SALDO_MAX) { // Si el monto a depositar más el saldo son mayores al saldo máximo permitido
            System.out.println("Depósito no disponible, saldo máximo superado"); // Lanzamos mensaje
        } else {
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            ticket = new Ticket(this.getDireccion(), // Creamos Objeto de tipo Ticket
                    folioOperacion++,
                    LocalDateTime.now(),
                    monto,
                    "DEPOSITO",
                    "********" + cuenta.getNumCuenta().substring(8)); // Aquí termina la creación del Ticket
        }
        return ticket; // Retornamos el Objeto de tipo Ticket
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}