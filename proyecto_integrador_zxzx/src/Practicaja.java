import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{




    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto,String nip) {
        Ticket ticket = null;
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if(monto > Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if( (cuenta.getSaldo()  + monto) > cuenta.getSaldoMax()){ //falta cambiar
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else{
                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //calculo el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo( nuevoSaldo );
                //reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);

                //actualiza el saldo en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registra el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "DEPOSITO", monto);

                ticket = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "DEPOSITO",
                        "*******"+cuenta.getNumCuenta().substring(8));
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
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
