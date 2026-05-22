import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Ticket ticket = null;

        try {

            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);

            //Validar cantidad maxima permitida para deposito
            if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) {

                throw new MaxDailyWithdrawalsExceededException(
                        Constantes.MAX_QUANTITY_DEPOSIT
                );

            }
            //Validar que no exceda el saldo maximo permitido
            else if ((cuenta.getSaldo() + monto) > Constantes.SALDO_MAX) {

                throw new OverMaximumDepositException(
                        Constantes.OVER_MAXIMUM
                );

            }
            else {

                //Buscar el indice de la cuenta en cache
                int index = this.getCacheCuentas().indexOf(cuenta);

                //Calcular nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;

                //Actualizar saldo del objeto
                cuenta.setSaldo(nuevoSaldo);

                //Actualizar objeto dentro de cache
                this.getCacheCuentas().set(index, cuenta);

                //Actualizar saldo en base de datos
                getCuentaDao().actualizarSaldoCuenta(
                        cuenta.getNumCuenta(),
                        nuevoSaldo
                );

                //Registrar movimiento
                getMovimientoDao().registrarMovimientos(
                        cuenta.getCuentaDTO(),
                        "RETIRO",
                        monto
                );

                //Generar ticket
                ticket = new Ticket(
                        this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "Deposito",
                        "*******" + cuenta.getNumCuenta().substring(8)
                );
            }

        } catch (AccountNotFoundException ex) {

            System.out.println(ex.getMessage());

        } catch (MaxDailyWithdrawalsExceededException ex) {

            System.out.println(ex.getMessage());

        } catch (OverMaximumDepositException ex) {

            System.out.println(ex.getMessage());
        }

        return ticket;
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