import javax.security.auth.login.AccountException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends Atm implements IOperacionesBasicas{


    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficentBalanceException,UnderMinimunException{

        Object[] datos = new Object[2];
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //*****************  VALIDAR QUE MARGEN DISPONIBLE SEA <= MONTO A RETIRAR
            if(   getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=Constantes.MAX_RETIRO_DIARIO)  { //Si el monto retirado supera el maximo
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if( ! (monto%100==0) ){ //validar que cantidad multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if(cuenta.getSaldo() <  monto){ //Verificar si me alcanza
                throw new InsufficentBalanceException(Constantes.INSUFFICENT_BALANCE);
            }else if( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){ //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimunException(Constantes.UNDER_MINIMUN);
            }else{

                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //reemplaza el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //Determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if(getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado =getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),
                            acumulado+monto);
                }else{
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
                }
                //Actualiza el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registra el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto);

                Ticket t = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "RETIRO",
                        "*******"+cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }
        }catch(AccountNotFoundException ex){
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion
        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
