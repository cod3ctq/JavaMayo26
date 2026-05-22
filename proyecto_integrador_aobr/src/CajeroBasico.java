import java.time.LocalDate;

public class CajeroBasico extends Atm implements IOperacionesBasicas{



    @Override
    public void cobrarRetiroSinTarjeta() {

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) throws MaxDailyWithdrawalsExceededException, InvalidQuantityException, InsufficientBalanceException, UnderMinimunException{




        Object[] datos= new Object[2];

        //si la cuente NO existe:

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);
            //COLOCAR AQUI TODO EL CODIGO QUE PROCESA EL RETIRO ASUMIENDO QUE YA NO NECESITO VALIDAR LA
            //EXISTENCIA DE LA CUENTA

            //VALIDAR QUE EL MARGEN DISPONIBLE SEA MENOR O IGUAL AL MONTO A RETIRAR
            if(getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) && getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=Constantes.MAX_RETIRO_DIARIO){
                //System.out.println("Retiro no disponible. Se ha superado la cantidad de retiro diario permitido");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWALS_EXCEEDED);
            }else if(!(monto%100==0)){
                //System.out.println("Cantidad invalida. Multiplos de 100");
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            }


            //cantidad multiplo de 100

            //Verificar si me alcanza
            else if(cuenta.getSaldo()<monto){
                //System.out.println("Saldo insuficiente");
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE);
            }else if((cuenta.getSaldo()-monto)<cuenta.getSaldoMin()){
                //Validar que si retiro, quede por encima del minimo
                //System.out.println("Retiro no disponible. Excede el minimo permitido");
                throw new UnderMinimunException(Constantes.UNDER_MINIMUN);
            } else{
                //CALCULO EL INDICE DEL OBJETO DENTRO DE LA LISTA
                int index = this.getCacheCuentas().indexOf(cuenta);


                //retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);


                //reemplaza el objeto con el saldo actualizado en la posicion en donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);

                //Determinar si es su primer retiro o si ya existe registro de esta cuenta en este dia

                if(getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),acumulado+monto);

                }else{
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
                }

                //Actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);


                //Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"RETIRO", monto);


                Ticket t = new Ticket(this.getDireccion(),folioOperacion++, LocalDate.now(),monto,"RETIRO", "*******"+cuenta.getNumCuenta().substring(8));
                datos[0]=monto;
                datos[1]=t;
            }
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());  //imprime solo el mensaje de la excepcion
        }
        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
