import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas{ // Hereda de 1 e implementa de 1

    @Override
    public void cobrarRetiroSinTarjeta() {
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) throws MaxDailyWithdrawalsExceedException, // Metodo que devolverá un array de tipo Object, puede devolver distintos tipos de datos
            InvalidQuantityException, InsufficientBalanceException, MinimumAllowedException { // Este metodo propagará 4 excepciones que se crearon dentro
        Object[] datos = new Object[2]; // Definimos array de 2 posiciones que es el que devolverá este metodo
        try {
            // Colocar aquí el código que procesa el retiro, asumiendo que ya no necesito validar la existencia de la cuenta
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip); // Almacenamos la cuenta de la que vamos a retirar con el metodo buscarCuenta()
            // Validar que todavía tenga margen de retiro (límite diario 12,000), para esto usamos un Mapa de Listas definido en la Clase Atm
            // Buscar si ya existe un retiro del día de hoy y de cuánto fue
            // FALTA ---------- VALIDAR QUE EL MARGEN DISPONIBLE PARA RETIRAR SEA MENOR O IGUAL MONTO A RETIRAR ----------
            if (Atm.getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now()) && // Si existe un registro en el Mapa con esta llave...
                    Atm.getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) { // Y el valor es >= al maximo de retiro
                throw new MaxDailyWithdrawalsExceedException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED); // Lanzamos excepción
            } else if (! (monto % 100 == 0)) { // Si el monto a retirar NO es múltiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY_EXCEPTION); // Lanzamos excepción
            } else if (monto > cuenta.getSaldo()) { // Si el monto a retirar es mayor que el saldo de la cuenta
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE); // Lanzamos excepción
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) { // Si el saldo menos el monto a retirar es menor al saldo mínimo permitido de la cuenta
                throw new MinimumAllowedException(Constantes.MINIMUM_ALLOWED); // Lanzamos excepción
            } else { // Si pasó todas las validaciones entonces sí podemos retirar
                int index = this.getCacheCuentas().indexOf(cuenta); // Obtengo el índice del Objeto en la Lista
                double nuevoSaldo = cuenta.getSaldo() - monto; // Calculamos el nuevo saldo después del retiro
                cuenta.setSaldo(nuevoSaldo); // Asignamos el nuevo saldo a la cuenta
                this.getCacheCuentas().set(index, cuenta); // Reemplazamos el Objeto con el saldo actualizado en la posición del Objeto original
                // Validar si es el primer retiro de esa cuenta en el día o si ya existen más retiros de esa cuenta en el día
                if (Atm.getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) { // "Si el Mapa contiene la llave con un retiro el día de hoy"
                    Double acumulado = Atm.getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()); // Obtenemos cuánto se ha retirado el día de hoy
                    Atm.cacheRetirosDiarios.put(cuenta.getNumCuenta() + LocalDate.now(), acumulado + monto); // Luego sumamos lo acumulado en retiros más el monto
                } else { // "Si no se ha retirado nada de la cuenta en el día"
                    Atm.getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto); // Guardamos el primer registro en la llave del día de hoy
                }
                // Actualizar el saldo de la cuenta en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo); // Llamamos a este metodo para actualizar el saldo de la cuenta en la db
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto); // Llamamos a metodo para registrar el movimiento en la db
                Ticket ticket = new Ticket (this.getDireccion(), // Creamos Objeto de tipo Ticket
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "RETIRO",
                        "********" + cuenta.getNumCuenta().substring(8)); // Aquí termina la creación del Ticket
                datos[0] = monto; // Asignamos el monto a depositar al array en la posición 0
                datos[1] = ticket; // Asignamos el Objeto de tipo Ticket al array en la posición 1
            }
        } catch (AccountNotFoundException ex) { // Excepción que podría arrojar ya que se tiene que verificar que exista la cuenta
            System.out.println(ex.getMessage()); // Imprimimos el mensaje de la excepción creada
        }
        return datos; // Retornamos el array con el monto a retirar y el Objeto de tipo Ticket
    }
    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}