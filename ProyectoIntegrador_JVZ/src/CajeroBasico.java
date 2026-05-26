import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends ATM implements IOperacionesbásicas{



    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumberException, WithdrawalAlreadyReceivedException{

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();


        //Buscar que exista la referencia
        boolean existe = false;
        String llave = "";
        for (String key:cacheRST.keySet()){
            if(key.contains(ref)){
                existe = true;
                llave = key;  //Extrae la key(num_cuenta, ref: clave) para usarla despues
                break;
            }
        }



        //--- La ref no existe, lanzar mensaje
        if (!existe){
            System.out.println("Retiro sin tarjeta invalido");
            throw new InvalidCardNumberException(COnstantes.INVALID_CARD_NUMBER);
        }else if (cacheRetirosCobrados.contains(ref)){   //Si ya fue cobrado
            System.out.println("Retiro sin tarjeta ya cobrado");
            throw new WithdrawalAlreadyReceivedException(COnstantes.WITHDRAWAL_AlREADY_RECEIVED);
        }else {
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0]) - cacheRST.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);
            cacheRetirosCobrados.add(ref); // añade el retiro al conjunto de los ya cobrados.
            System.out.println("IMPRIMIR TICKET ??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion = scan.nextInt();

            if (seleccion!=1){
                System.out.println("Operacion finalizada");
            }else {
                ticket = new  Ticket(this.getDirecciones(),
                        folioOperaciones++,
                        LocalDate.now(),
                        cacheRST.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);

            }

        }
        return ticket;

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQunatityException,
            InsufficentBalanceException, UnderMinimunException{
        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (getCacheRetiroDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetiroDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=COnstantes.MAX_RETIRO_DIARIO){  //Si el monto retirado supera el maximo
                throw new MaxDailyWithdrawalsExceededException(COnstantes.MAX_DAILYWITHDRAWAL_EXCEEDED);
            }else if (!(monto%100==0) || monto<=0 ){ // Validar que cantidad sea multiplo de 100
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
