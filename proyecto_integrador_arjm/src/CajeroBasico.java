import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas{

    @Override
    public Ticket cobrarRetiroSinTarjeta(){

        Ticket ticket = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();

        //Validar que exista la referencia
        boolean existe = false;
        String llave = "";
        for (String key:cacheRst.keySet()){
            if (key.contains(ref)){
                existe = true;
                llave = key; //Extrae la ref:clave para usarla despues
                break;
            }
        }
        //--La referencia no existe, lanzar mensaje---
        if (!existe){
            throw new InvalidCardNumberException(Constantes.INVALID_CARD_NUMBER);
        } else if (cacheRetirosCobrados.contains(ref)) { //si ya fue cobrado
            System.out.println("Retiro sin tarjeta ya cobrado");
            throw new WithdrawalAlreadyReceivedException(Constantes.WITHDRAWAL_ALREADY_RECEIVED);
        }else {
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0])- cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);
            cacheRetirosCobrados.add(ref); //añade el retiro al conjunto de los ya cobrados
            System.out.println("IMPRIMIR TICKET ?");
            System.out.println("presiona 1 (si), 2 (no)");
            int seleccion = scan.nextInt();

            if (seleccion!=1){
                System.out.println("Operacion finalizda");

            }else{
                ticket =  new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDate.now(),
                        cacheRst.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);
            }
        }
        return ticket;

    }

    @Override
    public Object[] retiro(String numTarjeta,double monto, String nip)
    throws MaxDailyWithdrawalsExceededException,InvalidQuantityException,InsufficentBalanceException,UnderMinimunException{


        Object[] datos = new Object[2];

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);
            if ( getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())&&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=Constantes.MAX_RETIRO_DIARIO)  {     //si se supera el limite diario
                        throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);

            }else if( ! (monto%100==0) || monto<=0   ){ //cantidad multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);

            }else if (cuenta.getSaldo() < monto){//Verificar si tengo dinero suficiente
                throw new InsufficentBalanceException(Constantes.INSUFFICENT_BALANCE);

            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
                throw new UnderMinimunException(Constantes.UNDER_MINIMUM);//Validar si retiro quede por encima del minimo

            }else {

                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);

                //Retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //reemplaza el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //determinar si es el primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta()+ LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+ LocalDate.now(),
                            acumulado+monto);

                }else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+ LocalDate.now(),monto);
                        }
                //actualiza el saldo de la cuenta en bd
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo );

                //registrar el movimiento
                getMovimientodao().registrarMovimineto(cuenta.getCuentaId(),"RETIRO", monto);

                Ticket t = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDate.now(),
                        monto,
                        "Retiro","********" +
                        cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }

        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage());//Imprime solo el mensaje de la excepcion
        }

        return datos;
    }
    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
