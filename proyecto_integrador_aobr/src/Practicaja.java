import java.time.LocalDate;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{
    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {
        Ticket ticket = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);
            if(monto>Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if((cuenta.getSaldo()+monto)>cuenta.getSaldoMax()){
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else{
                //CALCULO EL INDICE DEL OBJETO DENTRO DE LA LISTA
                int index = this.getCacheCuentas().indexOf(cuenta);

                //retirar
                double nuevoSaldo = cuenta.getSaldo() + monto;

                cuenta.setSaldo(nuevoSaldo);
                this.getCacheCuentas().set(index,cuenta);

                //Actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);


                //Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"DEPOSITO", monto);

                ticket = new Ticket(this.getDireccion(),folioOperacion++, LocalDate.now(),monto,"DEPOSITO", "*******"+cuenta.getNumCuenta().substring(8));


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
