import java.time.LocalDate;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{
    @Override
    public Ticket cobrarRetiroSinTarjeta() throws CardlessWithdrawalAlreadyProcessedException, InvalidWithdrawalWithoutCardException{

        Ticket ticket = null;

        Scanner teclado = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA: ");
        String ref = teclado.nextLine();
        System.out.println("CAPTURA LA CLAVE:");
        String clave = teclado.nextLine();

        //buscar que exista la referencia
        boolean existe=false;
        String llave="";
        for (String key:cacheRst.keySet()){
            if(key.contains(ref) && key.contains(clave)){
                existe=true;
                llave=key; //extrae la key (numCuenta:ref:clave) para usarla despues
                break;
            }
        }

        //la ref no existe, lanzar mensaje
        if(!existe){
            throw new InvalidWithdrawalWithoutCardException(Constantes.INVALID_WITHDRAWAL_WITHOUT_CARD);
        }else if(cacheRetirosCobrados.contains(ref)){  //si ya fue cobrado
            throw new CardlessWithdrawalAlreadyProcessedException(Constantes.CARDLESS_WITHDRAWAL_ALREADY_PROCESSED);
        }else{


            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0])-cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);

            cacheRetirosCobrados.add(ref); //aniade el retiro al conjutno de los ya cobrados

            System.out.println("IMPRIMIR TICKET??");


            System.out.println("Presiona 1 - (Si), 2 (No)");
            int seleccion = teclado.nextInt();
            if(seleccion !=1){
                System.out.println("Operacion finalizada");
            }else{
                ticket = new Ticket(this.getDireccion(),folioOperacion++,LocalDate.now(),cacheRst.get(llave),"RETIRO",llave.split(":")[0]);
            }



        }


        //validar si ya fue cobrada
        //si-mandar mensaje
        //no-proceder al cobro
        //registrar el cobro

        return ticket;
    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {
        Ticket ticket = null;

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);
            if(monto <=0){
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            }else if(monto>Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if((cuenta.getSaldo()+monto)>cuenta.getSaldoMax()){
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else{
                //CALCULO EL INDICE DEL OBJETO DENTRO DE LA LISTA
                int index = this.getCacheCuentas().indexOf(cuenta);

                //retirar
                double nuevoSaldo = cuenta.getSaldo() + monto;

                cuenta.setSaldo(nuevoSaldo);
                this.getCacheCuentas().set(index,cuenta);

                //Actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);


                //Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"DEPOSITO", monto);

                ticket = new Ticket(this.getDireccion(),folioOperacion++, LocalDate.now(),monto,"DEPOSITO", "*******"+cuenta.getNumCuenta().substring(8));


            }

        }catch(AccountNotFoundException ex){
            ex.printStackTrace();
        }






        return ticket;
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
