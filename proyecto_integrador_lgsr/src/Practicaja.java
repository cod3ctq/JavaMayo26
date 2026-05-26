import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends Atm implements iOperacionesBasicas, iOperacionesAvanzadas {


    @Override
    public Ticket cobrarRetiroSinTarjeta() throws WithdrawalAlreadyDoneException, InvalidCardNumberException {
        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();
        System.out.println("CAPTURA LA CLAVE");
        String clave = scan.nextLine();
        //validar que exista la referencia
        //buscar que exista la referencia
        boolean existe = false;
        String llave="";
        for(String key:cacheRst.keySet()){
            if(key.contains(ref)){
                existe = true;
                llave = key;//Extrae la ref:clave para usarla despues
                break;
            }
        }

        //la referencia existe, ahora ver si ya fue cobrada
        if(!existe){
            throw new InvalidCardNumberException(Constantes.INVALID_CARDLESS_WITHDRAWAL);
        }else if(cacheRetirosCobrados.contains(ref)){//si ya fue cobrado
            throw new WithdrawalAlreadyDoneException(Constantes.CARDLESS_WITHDRAWAL_ALREADY_DONE);

        }else{

            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0])- cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);
            cacheRetirosCobrados.add(ref);//anade el retiro al conjunto de los ya cobrados

            System.out.println("IMPRIMIR TICKET ??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion= scan.nextInt();

            if(seleccion!=1){
                System.out.println("Operacion finalizada");
            }else{
                ticket= new Ticket(this.getDireccion(),
                        folioOperacion++,
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
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if(monto<=0){
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            }else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) {
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            } else if (cuenta.getSaldo() + monto > cuenta.getSaldoMax()) { //falta cambiar
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);

            } else {
                //deposito
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Calcula el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //Altera el saldo en el objeto del cache
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el nuevo saldo, en el lugar del original
                this.getCacheCuentas().set(index,cuenta);

                //actualizar saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"DEPOSITO", monto);

                ticket = new Ticket(this.getDireccion(), folioOperacion++, LocalDateTime.now(), monto, "DEPOSITO", "*******" + cuenta.getNumCuenta().substring(8));
            }

        } catch (Exception ex) {
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
