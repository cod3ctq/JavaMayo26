import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements iOperacionesBasicas {

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
        throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
                InsufficientBalanceException, UnderMinimumException{

        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //validar que todavia tenga margen de retiro
            //Si existe registro de retiro, obtiene cuanto se ha retirado en este dia
            //Si no, se queda nulo
            //retiradoHoy = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());

            //******************** VALIDAR QUE MARGEN DISPONIBLE SEA <= MONTO A RETIRAR
            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now()) &&//SI el monto retirado supera el maximo
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) {
                //System.out.println("Retiro no disponible, se ha superado la cantidad maxima permitida");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);

            } else if (!(monto % 100 == 0)) {//cantidad muitplo de 100
                //System.out.println("Cantidad invalida, debe ser multiplo de 100");
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto) {//Verificar si me alcanza
                //System.out.println("Saldo insuficiente");
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE);
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {//Validar que si retiro,quede encima del minimo
                //System.out.println("Retiro no disponible. Excede el minimo permitido");
                throw new UnderMinimumException(Constantes.UNDER_MINIMUM);
            } else {

                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);

                //Retirar
                double nuevoSaldo = cuenta.getSaldo()- monto;
                cuenta.setSaldo(nuevoSaldo);
                //Actualizar el saldo del objeto guardado en el cache
                this.getCacheCuentas().set(index,cuenta);
                //determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), acumulado + monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
                }
                //actualizar saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"RETIRO", monto);
                Ticket t = new Ticket(this.getDireccion(), folioOperacion++, LocalDateTime.now(), monto, "retiro", "*******" + cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }
            //colocar aqui todo el codigo que procesa el retiro asumiendo que ya no necesito validar la existencia
            //de la cuenta
        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());//imprime el mensaje de la excepcion
        }
        //sino
        // Lanzar mensaje
        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
