import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends ATM implements IOperacionesbásicas, IOperacionesAvanzadas{
    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumberException, WithdrawalAlreadyReceivedException{


        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();
        System.out.println("CAPTURA LA CLAVE");
        String clave = scan.nextLine();


        //Buscar que exista la referencia
        boolean existe = false;
        String llave = "";
        for (String key:cacheRST.keySet()){
            if(key.contains(ref) && key.contains(clave)){
                existe = true;
                llave = key;  //Extrae la key(numCuenta, ref: clave) para usarla despues
                break;
            }
        }



        //--- La ref no existe, lanzar mensaje
        if (!existe){
            throw new InvalidCardNumberException(COnstantes.INVALID_CARD_NUMBER);
        }else if (cacheRetirosCobrados.contains(ref)){   //Si ya fue cobrado
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
    public Ticket depositar(String numTarjeta, double monto, String nip){

        Ticket ticket = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (monto<=0){
                throw new InvalidQunatityException(COnstantes.ONLY_POSITIVE);
            }else if (monto > COnstantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(COnstantes.MAX_QUANTITY_DESPOSIT);
            } else if (( cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
                throw new OverMaximumDepositException(COnstantes.OVER_MAXIMUN);
            }else {
                //calcular el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Caclulo el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);

                //Actualiza el saldo en la bd
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registar el movimiento
                getMovimientodao().resgistrarMovimiento(cuenta.getCuentaId(), "DEPOSITO", monto);

                ticket = new Ticket(this.getDirecciones(),
                        folioOperaciones++,
                        LocalDate.now(),
                        monto,
                        "DEPOSITO",
                        "*******"+cuenta.getNumCuenta().substring(8));

            }
        }catch (AccountNotFoundException ex){
            ex.printStackTrace();
        }
        return ticket;
    }



    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServcicio(String convenio, String referencia) {
        return null;




    }
}
