import java.time.LocalDateTime;
import java.util.Scanner;

public class PractiCaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumber, WithdrawalAlreadyReceived{
        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA: ");
        String ref = scan.nextLine();
        System.out.println("CAPTURAR CLAVE: ");
        String clave = scan.nextLine();

        boolean existe = false;
        String llave = "";
        for(String key:cacheRst.keySet()){
            if(key.contains(ref) && key.contains(clave)){
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

            if (seleccion != 1) {
                System.out.println("Operacion finalizada");
            } else {
                ticket = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(),
                        cacheRst.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);
            }
        }
        return ticket;
    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) {

        Ticket ticket = null;
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta,nip);

            if(monto <= 0){
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            }
            else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()){
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else {
                //calcula el indice del objeto origal dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //altera el saldo en el objeto del cache
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //reemplaza el objeto con el nuevo saldo, en el lugar del objeto original
                cuenta.setSaldo(nuevoSaldo);

                this.getCacheCuentas().set(index, cuenta);

                //Actualiza el saldo de la cuenta
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);

                //Registra el movimiento
                getMovimientodao().registrarMoviento(cuenta.getCuentaId(), "DEPOSITO", monto);

                //deposito
                //cuenta.setSaldo(cuenta.getSaldo() + monto);
                ticket = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(), monto,
                        "DEPOSITO",
                        "************"+cuenta.getNumCuenta().substring(8));
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
    public Ticket pagaServicio(String convenio, String referencia) {
        return null;
    }
}
