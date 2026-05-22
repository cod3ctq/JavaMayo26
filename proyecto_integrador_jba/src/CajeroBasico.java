import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas{
    @Override
    public void cobrarRetirosSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficentBalanceExeption, UnderMinimumException{
        //Double retiradoHoy;
        Object[] datos = new Object[2];
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //colocar aqui todo el codigo que procesa el retiro,
            //asumiemndo que ya no necesito Validar la existencia de la cuenta
            //Buscar si existe ya algun retiro registrado, obtiene cuanto se ha retirado en este dia, si no que nulo
            //********************* Validar que margen disponible sea< MONTO A RETIRAR.
            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>= Constantes.MAX_RETIRO_DIARIO){ //si el monton retirado supera el maximo.
                //Registro el retiro y guardo el monto que acabo de retirar
                getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(), monto);
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if(! (monto%100==0) ){//cantidad multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo()<monto){//Verificar si me alcanza
                throw new InsufficentBalanceExeption(Constantes.INSUFFICENT_BALANCE);
            } else if ( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) { //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimumException(Constantes.UNDER_MINIMUM);
            }else {
                //calcular el indice del objeto dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo( nuevoSaldo);
                //reemplazar el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);

                //determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia.

                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){

                    double acomulado =getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());

                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),acomulado+monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);

                }
                //actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //registrar el movimiento
                getMovimientodao().registraMovimiento(cuenta.getCuentaId(), "RETIRO", monto);

                Ticket t = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto, "RETIRO",
                        "*******"+cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }
        } catch (AccountNotFoundException ex){

            System.out.println(ex.getMessage());//imprime solo el mensaje de la excepcion

        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
