import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas {

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficientBalanceException, UnderMinimunException{

        Object[] datos = new Object[2];

        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);

            if (cuenta == null) {
                System.out.println("La cuenta no existe. No es posible retirar");
                return datos;
            }

            Double retiradoHoy = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());

            if (retiradoHoy == null) {
                retiradoHoy = 0.0;
            }

            if ((retiradoHoy + monto) > Constantes.MAX_RETIRO_DIARIO) {
                System.out.println("Retiro no disponible, monto maximo permitido alcanzado");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);

            } else if ( ! (monto%100==0)) {
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto) {
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE);
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
                throw new UnderMinimunException(Constantes.UNDER_MIN);
            } else {
                //Calculo el indice dle objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //Reemplazar el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index,cuenta);
                //Determinar si es un primer retiro o si ya erxiste registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(),
                            acumulado + monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
                }

                //Actualizar el saldo de la cuenta en data base
                getCuentaDao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registrar el movimiento
                getMovimientoDao().registrarMovimientos(cuenta.getCuentaDTO(), "RETIRO", monto);

                Ticket t = new Ticket(
                        this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "Retiro",
                        "*******" + cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }

        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}