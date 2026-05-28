import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {

    @Override
    public Ticket cobrarRetiroSinTarjeta() {

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();
        System.out.println("CAPTURA LA CLAVE");
        String clave = scan.nextLine();

        //Buacar que exista la referencia
        boolean existe = false;
        String llave="";
        for(String key:cacheRst.keySet()){
            if (key.contains(ref) && key.contains(clave)){
                existe = true;
                llave = key;//Extrae la keyy(numCuenta:ref:clave) para usarla despues
                break;
            }
        }
        //Si la referencia no existe, lanzar mensaje
        if (!existe){
            System.out.println("Retiro sin tarjeta invalido");
        }else if (cacheRetirosCobrados.contains(ref)){ //Validar si ya fue cobrado
            System.out.println("Retiro sin tarjeta ya cobrado");
        }else{
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0]) - cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);

            cacheRetirosCobrados.add(ref);//Agrega el retiro al conjunto de los ya cobrados
            System.out.println("IMPRIMIR TICKET??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion = scan.nextInt();

            if (seleccion!=1){
                System.out.println("Operacion Finalizada");
            }else{
                ticket = new Ticket(this.getDireccion(),
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
    public Ticket depositar(String numTarjeta, double monto,String nip) {
        Ticket ticket = null;
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if(monto <=0){
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            }else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO){
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT);
            }else if(cuenta.getSaldo() + monto > cuenta.getSaldoMax()){//Falta Cambiar
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM);
            } else{
                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //calculo el nuevo saldo
                double nuevoSaldo = cuenta.getSaldo() + monto;
                //altera el saldo en el objeto del cache
                cuenta.setSaldo( nuevoSaldo );
                //reemplaza el objeto con el nuevo saldo en el lugar del objeto original
                this.getCacheCuentas().set(index, cuenta);
                //actualiza el saldo en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo);
                //Registra el movimiento
                getMovimientodao().registrarMovimientos(cuenta.getCuentaDTO(), "DEPOSITO", monto);//DTO es ID, te equivocaste
                //Generar ticket
                ticket = new Ticket(
                        this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "Deposito",
                        "*******" + cuenta.getNumCuenta().substring(8)
                );
            }

        } catch (AccountNotFoundException ex) {

            System.out.println(ex.getMessage());

        } catch (MaxDailyWithdrawalsExceededException ex) {

            System.out.println(ex.getMessage());

        } catch (OverMaximumDepositException ex) {

            System.out.println(ex.getMessage());
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