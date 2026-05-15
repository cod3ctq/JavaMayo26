import java.time.LocalDateTime;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Cuenta cuenta = this.buscarCuenta(numTarjeta, nip);
        Ticket ticket  = null;

        if (!(cuenta != null)){
            System.out.println("la cuenta no existe! no es posible depositar");
        }else if(monto>Constantes.CANTIDAD_MAX_DEPOSITO){
            System.out.println("Monto maximo superado. Deposite en ventanilla");
        }else if((cuenta.getSaldo()+monto)>Constantes.SALDO_MAX){
            System.out.println("Deposito no disponible, saldo maximo superado");
        }else{
            cuenta.setSaldo(cuenta.getSaldo()+monto);
            ticket = new Ticket(this.getDireccion(), folioOperacion++,
                    LocalDateTime.now(), monto, "Deposito",
                    "*******" + cuenta.getNumCuenta().substring(8));

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
