import java.time.LocalDate;

public class CajeroBasico extends Atm implements IOperacionesBasicas{



    @Override
    public void cobrarRetiroSinTarjeta(){
    }

    @Override
    public Object[] retiro(String numTarjeta,double monto, String nip) {

        Cuenta cuenta = this.buscarCuenta(numTarjeta,nip);
        Object[] datos = new Object[2];
        //Si la cuenta existe.....
        if ( ! (cuenta!=null)){
            System.out.println("La cuenta no existe !. No es posible retirar");
        }else {
            //Verificar si tengo dinero suficiente
            if (cuenta.getSaldo() < monto){
                System.out.println("Saldo insuficiente");
            } else if ((cuenta.getSaldo() - monto) < Constantes.SALDO_MIN) {
                System.out.println("Retriro no disponible. Excede el minimo permitido"); //Validar si retiro quede por encima del minimo
            }else { //Retirar
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                Ticket t = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDate.now(),
                        monto,
                        "Retiro","********" +
                        cuenta.getNumCuenta().substring(8));

                datos[0] = monto;
                datos[1] = t;
            }
        }
        //Si no, Lanzar mensaje
        return datos;
    }
    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
