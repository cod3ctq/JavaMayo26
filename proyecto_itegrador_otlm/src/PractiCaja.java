import java.time.LocalDateTime;

public class PractiCaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{

    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {
        Ticket ticket = null;
        Cuenta cuenta = this.buscarCuenta(numTarjeta,nip);
        if(!(cuenta!=null)){
            System.out.println("La cuenta no existe! No posible retirar");
        }else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO){
            System.out.println("Monto maximo superado. Deposite en ventanilla");
        }else if ((cuenta.getSaldo() + monto) > Constantes.SALDO_MAX){
            System.out.println("Deposito no disponible, saldo maximo");
        }else {
            //deposito
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            ticket = new Ticket(this.getDireccion(),
                    ++folioOperacion,
                    LocalDateTime.now(), monto,
                    "DEPOSITO",
                    "************"+cuenta.getNumCuenta().substring(8));
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
