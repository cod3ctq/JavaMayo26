import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Practicaja extends ATM implements IOperacionesbásicas, IOperacionesAvanzadas{
    @Override
    public void cobrarRetiroSinTarjeta() {


    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip){

        Ticket ticket = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (monto > COnstantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(COnstantes.MAX_QUANTITY_DESPOSIT);
            } else if (( cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
                throw new OverMaximumDepositException(COnstantes.OVER_MAXIMUN);
            }else {
                //calcular el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Caclulo el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);

                //Actualiza el saldo en la bd
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registar el movimiento
                getMovimientodao().resgistrarMovimiento(cuenta.getCuentaId(), "DEPOSITO", monto);

                ticket = new Ticket(this.getDirecciones(),
                        folioOperaciones++,
                        LocalDate.now(),
                        monto,
                        "DEPOSITO",
                        "*******"+cuenta.getNumCuenta().substring(8));

            }
        }catch (AccountNotFoundException ex){
            ex.printStackTrace();
        }
        return ticket;
    }



    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServcicio(String convenio, String referencia) {
        return null;




    }
}
