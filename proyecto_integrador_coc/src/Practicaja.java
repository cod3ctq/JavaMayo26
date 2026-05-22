import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{ // Hereda de 1 e implementa de 2

    @Override
    public void cobrarRetiroSinTarjeta() {
    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) { // Metodo que devolverá un Objeto de tipo Ticket
        Ticket ticket = null; // Definimos variable que devolveremos
        try {
            CuentaDTO cuenta = buscarCuenta(numTarjeta, nip); // Buscamos la cuenta con el número de tarjeta y el nip
            if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) { // Si el monto a depositar es mayor a la cantidad máxima permitida
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT); // Lanzamos excepción
            } else if ((monto + cuenta.getSaldo()) > cuenta.getSaldoMax()) { // Si el monto a depositar más el saldo son mayores al saldo máximo permitido de la cuenta
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM); // Lanzamos mensaje
            } else { // Si pasó todas las validaciones entonces sí podemos depositar
                int index = this.getCacheCuentas().indexOf(cuenta); // Obtengo el índice del Objeto en la Lista
                double nuevoSaldo = cuenta.getSaldo() + monto; // Calculamos el nuevo saldo después del depósito
                cuenta.setSaldo(nuevoSaldo); // Asignamos el nuevo saldo a la cuenta
                this.getCacheCuentas().set(index, cuenta); // Reemplazamos el Objeto con el saldo actualizado en la posición del Objeto original
                // Actualizar el saldo de la cuenta en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo); // Llamamos a este metodo para actualizar el saldo de la cuenta en la db
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "DEPÓSITO", monto); // Llamamos a metodo para registrar el movimiento en la db
                ticket = new Ticket(this.getDireccion(), // Creamos Objeto de tipo Ticket
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "DEPOSITO",
                        "********" + cuenta.getNumCuenta().substring(8)); // Aquí termina la creación del Ticket
            }
        } catch (AccountNotFoundException ex) { // Excepción que podría arrojar ya que se tiene que verificar que exista la cuenta
            ex.printStackTrace();
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