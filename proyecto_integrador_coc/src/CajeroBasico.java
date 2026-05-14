import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas{ // Hereda de 1 e implementa de 1

    @Override
    public void cobrarRetiroSinTarjeta() {
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) { // Metodo que devolverá un array de tipo Object, puede devolver distintos tipos de datos
        Cuenta cuenta = buscarCuenta(numTarjeta, nip); // Almacenamos la cuenta de la que vamos a retirar con el metodo buscarCuenta()
        Object[] datos = new Object[2]; // Definimos array de 2 posiciones que es el que devolverá este metodo
        if (! (cuenta != null)) { // Si la cuenta NO existe...
            System.out.println("La cuenta no existe, no es posible retirar"); // Lanzamos mensaje
        } else { // Si sí existe...
            if (monto > cuenta.getSaldo()) { // Si el monto a retirar es mayor que el saldo de la cuenta
                System.out.println("Saldo insuficiente"); // Lanzamos mensaje
            } else if ((cuenta.getSaldo() - monto) < Constantes.SALDO_MIN) { // Si el saldo menos el monto a retirar es menor al saldo mínimo permitido
                System.out.println("Retiro no disponible, excede el mínimo permitido"); // Lanzamos mensaje
            } else { // Si pasó todas las validaciones entonces sí podemos retirar
                cuenta.setSaldo(cuenta.getSaldo() - monto); // Restamos el monto a retirar del saldo y asignamos ese nuevo saldo a la cuenta con setSaldo
                Ticket ticket = new Ticket(this.getDireccion(), // Creamos Objeto de tipo Ticket
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "RETIRO",
                        "********" + cuenta.getNumCuenta().substring(8)); // Aquí termina la creación del Ticket
                datos[0] = monto;
                datos[1] = ticket;
            }
        }
        return datos; // Retornamos el array con el monto a retirar y el Objeto de tipo Ticket
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}