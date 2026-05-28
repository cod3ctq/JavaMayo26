import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas {

    @Override
    public Ticket cobrarRetiroSinTarjeta() {

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();

        //Buacar que exista la referencia
        boolean existe = false;
        String llave="";
        for(String key:cacheRst.keySet()){
            if (key.contains(ref)){
                existe = true;
                llave = key;//Extrae la ref: clave para usarla despues
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
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficientBalanceException, UnderMinimunException{
        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
            getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=Constantes.MAX_RETIRO_DIARIO)
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            else if ( ! (monto%100==0) || monto <= 0) {//Validar que cantidad sea multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto) {//Verificar si me alcanza
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE);
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {
                throw new UnderMinimunException(Constantes.UNDER_MINIMUN);

            } else {
                //Calculo el indice dle objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //Reemplazar el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index,cuenta);
                //Determinar si es un primer retiro o si ya erxiste registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(),
                            acumulado + monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
                }

                //Actualizar el saldo de la cuenta en data base
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registrar el movimiento
                getMovimientodao().registrarMovimientos(cuenta.getCuentaDTO(), "RETIRO", monto);

                Ticket t = new Ticket(
                        this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "Retiro",
                        "*******" + cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }

        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }
}