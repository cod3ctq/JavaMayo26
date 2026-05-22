import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {

    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao= new MovimientoDAO();

    @Override
    public void cobrarRetirosSinTarjeta() {

    }

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Ticket ticket  = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if(monto>Constantes.CANTIDAD_MAX_DEPOSITO){
            throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
        }else if((cuenta.getSaldo()+monto)>Constantes.SALDO_MAX){
            throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
        }else{
                //calcula el indice del objeto original dentro de la lista
                int index= this.getCacheCuentas().indexOf(cuenta);
                //calcula el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo()+monto;
                //alera el saldo en el objeto del cache
            cuenta.setSaldo(cuenta.getSaldo()+monto);
            //remplaza el objeto con el nuevo saldo, en el lugar del objeto original
                this.getCacheCuentas().set(index,cuenta);

                //Acuatlizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);

                //registrar el movimiento
                getMovimientodao().registrarMocimiento(cuenta.getCuentaId(),"DEPOSITO",monto);


                ticket = new Ticket(this.getDireccion(),
                    folioOperacion++,
                    LocalDateTime.now(),
                    monto,
                    "DEPOSITO",
                    "*******" + cuenta.getNumCuenta().substring(8));

        }
        }catch(AccountNotFoundException ex){
            ex.printStackTrace();
        }

//        if (!(cuenta != null)){
//            System.out.println("la cuenta no existe! no es posible depositar");
//        }else

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
