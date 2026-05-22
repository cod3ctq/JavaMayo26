import java.time.LocalDateTime;

public class PractiCaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Ticket ticket = null;
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);

            if (monto > Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if ((cuenta.getSaldo() + monto) > Constantes.SALDO_MAX){
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else {
                //calcula el indice del objeto origal dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //altera el saldo en el objeto del cache
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                cuenta.setSaldo(nuevoSaldo);

                this.getCacheCuentas().set(index, cuenta);

                //Actualiza el saldo de la cuenta
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);

                //Registra el movimiento
                getMovimientodao().registrarMoviento(cuenta.getCuentaId(), "DEPOSITO", monto);

                //deposito
                //cuenta.setSaldo(cuenta.getSaldo() + monto);
                ticket = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(), monto,
                        "DEPOSITO",
                        "************"+cuenta.getNumCuenta().substring(8));
            }

        }catch(AccountNotFoundException ex){
            ex.printStackTrace();
        }

        return ticket;
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagaServicio(String convenio, String referencia) {
        return null;
    }
}
