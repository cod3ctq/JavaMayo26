import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas {
    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {

        Cuenta cuenta = this.buscarCuenta(numTarjeta, nip);
        Object[] datos = new Object[2];

        //Si la cuenta existe..
        //Verificar si alcanza
        //Validad que si retiro, quede por encima del minimo

        //Si la cuenta no existe
        if (!(cuenta != null)) {
            System.out.println("La cuenta no existe");
        } else // si existe
        {          //Si el saldo que me da es menor al monto, entonces
            if (cuenta.getSaldo() < monto) {
                System.out.println("Saldo insuficiente");
                //Si El saldo menos el monto < constante
            } else if ((cuenta.getSaldo() - monto) < Constantes.SALDO_MIN) {//validar que si retiro quede por encima del minimo
                System.out.println("Retiro no disponible");
            } else {
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                Ticket t = new Ticket(this.getDireccion(), folioOperacion++,
                        LocalDateTime.now(), monto, "Retiro",
                        "*******" + cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;

            }

        }
        return datos;

    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
