import java.time.LocalDate;

public class CajeroBasico extends ATM implements IOperacionesbásicas{



    @Override
    public void cobrarRetiroSinTarjeta() {


    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {

        Cuenta cuenta = this.buscarCuenta(numTarjeta, nip);
        Object[] datos = new Object[2];
        //Si la cuenta existe.....
        if (!(cuenta!=null)){
            System.out.println("La cuenta no existe !. No es posible retirar");
        } else {
            //Verificar si me alcanza
            if (cuenta.getSaldo() < monto){
                System.out.println("Saldo insuficiente");
            } else if ((cuenta.getSaldo()- monto) < COnstantes.SALDO_MIN) { //Validar que si retiro, quede por encima del minimo
                System.out.println("Retiro no disponible. Excede el minimo permitido");
            }else {
                //Retirar
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                Ticket t = new Ticket(this.getDirecciones(),
                        folioOperaciones++,
                        LocalDate.now(),
                        monto,"RETIRO",
                        "*******"+cuenta.getNumCuenta().substring(7));
                datos[0] = monto;
                datos[1] = t;
            }

        }
        return datos;
    }

    @Override
    public Ticket pagarServcicio(String convenio, String referencia) {
        return null;
    }
}
