import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CajeroBasico extends ATM implements IOperacionesbásicas{



    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQunatityException,
            InsufficentBalanceException, UnderMinimunException{

        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //******** VALIDAR QUE MARGEN DISPONIBLE SEA <= MONTO A RETIRAR.
            if (getCacheRetiroDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetiroDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=COnstantes.MAX_RETIRO_DIARIO){  //Si el monto retirado supera el maximo
                throw new MaxDailyWithdrawalsExceededException(COnstantes.MAX_DAILYWITHDRAWAL_EXCEEDED);
            }else if (!(monto%100==0)){ // Validar que cantidad sea multiplo de 100
                throw new InvalidQunatityException(COnstantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto){ //Verificar si me alcanza
                throw new InsufficentBalanceException(COnstantes.INSUFFICENT_BALANCE);
            } else if ((cuenta.getSaldo()- monto) < cuenta.getSaldoMin()){ //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimunException(COnstantes.UNDERMINIMUN_EXCEPTION);
            }else {

                //Calculo el indice del objeto dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //Determinar si es su primer retiro o si ya existe registro de retiro de esta cuenta en este dia.
                if (getCacheRetiroDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado =  getCacheRetiroDiarios().get(cuenta.getNumCuenta()+LocalDate.now());
                    getCacheRetiroDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),
                            acumulado+monto);
                }else {
                    getCacheRetiroDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
                }
                //Actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registar el movimiento
                getMovimientodao().resgistrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto);


                Ticket t = new Ticket(this.getDirecciones(),
                        folioOperaciones++,
                        LocalDate.now(),
                        monto,"RETIRO",
                        "*******"+cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion

        }
        return datos;
    }
    @Override
    public Ticket pagarServcicio(String convenio, String referencia) {
        return null;
    }
}
