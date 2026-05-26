import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas{

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumber, WithdrawalAlreadyReceived{

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA: ");
        String ref = scan.nextLine();

        boolean existe = false;
        String llave = "";
        for(String key:cacheRst.keySet()){
            if(key.contains(ref)){
                existe = true;
                llave=key;
                break;
            }
        }

        //---la ref existe, ahora, lanzar mensaje,
        if (!existe){
            throw new InvalidCardNumber(Constantes.INVALID_CARD_NUM);
        } else if(cacheRetirosCobrados.contains(ref)){    //validar si ya fue cobrado con el set cacheRetirosCobrados
            throw new WithdrawalAlreadyReceived(Constantes.WITHDRAWAL_ALREADY_RECEIVED);
        } else {

            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0])-cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);

            cacheRetirosCobrados.add(ref);//añade el retiro al set cacheRetirosCobrados

            System.out.println("IMPRIMIR TICKEY ??");
            System.out.println("Presiona 1 (si), 2 (no)");
            int seleccion = scan.nextInt();

            if(seleccion != 1){
                System.out.println("Operacion finalizada");
            }
            else {
                ticket = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(),
                        cacheRst.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);
            }

        }

        //validar que exista la referencia
        //validar si ya fue cobrada
        //si lanzar mensaje
        //no proceder al cobro
        //registrar el cobro
        return ticket;
    }

    /*
    * Vamos a retirar, modificando el saldo de la cuenta, retornando un ticket y va a incrementar el contador folioOperacion.
    * Vamos a retornar un array de tipo Object, que son el monto y un ticket
    */
    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException,
            InvalidQuantityException,
            InsufficentBalanceException,
            UnderMinimumException{

        Object[] datos = new Object[2];

        try{

            //Validar que todavia tenga margen de retiro
            //buscar si existe ya algun retiro hecho por mi, el dia de hoy y de cuanto fue
            //retiradoHoy = getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());

            //**************Validar que margen disponible sea menor igual al monto a retirar*******************
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);

            if(getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO){//Si el monto retirado supera el maximo
                //System.out.println("Retiro no disponible, se ha superado la cantidad diaria permitida");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if(!(monto % 100 == 0) || monto <= 0){
                //System.out.println("Cantidad debe ser multiplo de 100");
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            }else if(cuenta.getSaldo() < monto){
                //System.out.println("Saldo insuficiente");
                throw new InsufficentBalanceException(Constantes.INSUFFICENT_BALANCE);
            }else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){//Validar que si retiro, quede por encima del minimo
                //System.out.println("Retiro no disponible. Excede el minimo permitido");
                throw new UnderMinimumException(Constantes.UNDER_MINIMUM);
            }else {
                //Calcular el indice del objeto antes de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //Remplazael objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //Determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), acumulado + monto);
                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
                }

                //Actualiza el saldo de la cuenta
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);

                //Registra el movimiento
                getMovimientodao().registrarMoviento(cuenta.getCuentaId(), "RETIRO", monto);

                Ticket t = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(), monto,
                        "RETIRO",
                        "************" + cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;

                //Colocar aqui todo el codigo que porcesso el retiro,
                // asumiendo que ya no necesito validar la existencia de la cuenta
            }
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        return datos;
    }





    @Override
    public Ticket pagaServicio(String convenio, String referencia) {
        return null;
    }
}
