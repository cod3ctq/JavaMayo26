import java.time.LocalDateTime;

public class Practicaja extends Atm implements iOperacionesBasicas, iOperacionesAvanzadas {
    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {
        Ticket ticket = null;
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) {
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            } else if (cuenta.getSaldo() + monto > cuenta.getSaldoMax()) { //falta cambiar
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);

            } else {
                //deposito
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Calcula el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //Altera el saldo en el objeto del cache
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el nuevo saldo, en el lugar del original
                this.getCacheCuentas().set(index,cuenta);

                //actualizar saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"DEPOSITO", monto);

                ticket = new Ticket(this.getDireccion(), folioOperacion++, LocalDateTime.now(), monto, "DEPOSITO", "*******" + cuenta.getNumCuenta().substring(8));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
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
