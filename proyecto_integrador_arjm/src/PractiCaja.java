import java.time.LocalDate;

public class PractiCaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{

    @Override
    public void cobrarRetiroSinTarjeta(){

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Ticket ticket = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) {
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);

            } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
                throw  new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else {
                //Calcula el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //calcula el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo(nuevoSaldo);
                //reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);
                //Actualiza el saldo en la bd
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo );
                //registrar el movimiento
                getMovimientodao().registrarMovimineto(cuenta.getCuentaId(),"DEPOSITO", monto);




                ticket = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDate.now(),
                        monto,
                        "Deposito", "********" +
                        cuenta.getNumCuenta().substring(8));
            }
        }catch (AccountNotFoundException ex){
            ex.printStackTrace();
        }


        return ticket;
    }

    @Override
    public Object[] retiro(String numTarjeta,double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
