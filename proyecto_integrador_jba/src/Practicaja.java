import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{


    @Override
    public Ticket cobrarRetirosSinTarjeta() throws InvalidNumberReferenceException, WithDrawalAlreadyCollectedException {

        Ticket  ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();
        System.out.println("CAPTURA LA CLAVE");
        String clave= scan.nextLine();

        //busca la existencia de la referencia
        boolean existe = false;
        String llave="";
        for (String key:cacheRst.keySet()){
            if (key.contains(ref) && key.contains(clave)){
                existe = true;
                llave = key; //extrae la key(numCuenta:ref:clave)  para usarla despues
                break;
            }
        }

        //-- la referencia no existe, lanzar mensaje
        if (!existe){
            //System.out.println("Retiro sin tarjeta invalido");
            throw new InvalidNumberReferenceException(Constantes.INVALID_NUMBER_REFERENCE);
        } else if (cacheRetirosCobrados.contains(ref)){ //validar si ya fue cobrado
            //System.out.println("Retiro sin tarjeta ya cobrado");
            throw new WithDrawalAlreadyCollectedException(Constantes.WITHADRAWAL_ALREADY_COLLECTED);
        }else {
            double nuevoSaldo= getCuentadao().getSaldoCuenta(llave.split(":")[0]) -cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0], nuevoSaldo );

            cacheRetirosCobrados.add(ref); //añade el retiro al conjunto de los ya cobrados
            System.out.println("IMPRIMIR TICKET ??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion = scan.nextInt();

            if (seleccion != 1) {
                System.out.println("operacion finalizada");

            } else {

                return new Ticket(this.getDireccion(),
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

        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (monto<=0){
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            } else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) {
                throw  new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
                throw  new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            }else{
                //Calculo en indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //calculo el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo( nuevoSaldo);
                //reemplaza el objeto con el nuevo saldo, en lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);
                //actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //registrar el movimiento
                getMovimientodao().registraMovimiento(cuenta.getCuentaId(), "DEPOSITO", monto);


                ticket = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
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
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}
