import java.time.LocalDate;

public class CajeroBasico extends Atm implements IOperacionesBasicas{



    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {

        Cuenta cuenta = this.buscarCuenta(numTarjeta,nip);

        Object[] datos= new Object[2];

        //si la cuente NO existe:

        if(!(cuenta!=null)){
            System.out.println("Cuenta inexistente");
        }

        else{
            //Verificar si me alcanza
            if(cuenta.getSaldo()<monto){
                System.out.println("Saldo insuficiente");
            }else if((cuenta.getSaldo()-monto)<Constantes.SALDO_MIN){
                //Validar que si retiro, quede por encima del minimo
                System.out.println("Retiro no disponible. Excede el minimo permitido");
            } else{
                //retirar
                cuenta.setSaldo(cuenta.getSaldo()-monto);
                Ticket t = new Ticket(this.getDireccion(),folioOperacion++, LocalDate.now(),monto,"RETIRO", "*******"+cuenta.getNumCuenta().substring(8));
                datos[0]=monto;
                datos[1]=t;
            }


        }


        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
