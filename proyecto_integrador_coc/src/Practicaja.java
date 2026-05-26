import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas{ // Hereda de 1 e implementa de 2

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardlessWithdrawalException, WithdrawalAlreadyProcessedException {
        Ticket ticket = null; // Definimos variable a delolver
        Scanner scan = new Scanner(System.in);
        System.out.print("Captura la referencia: ");
        String ref = scan.nextLine();
        System.out.print("Captura la clave: ");
        String clave = scan.nextLine();

        // Validar que exista la referencia en el mapa cacheRetiroSinTar
        String llave = "";
        boolean existe = false;
        for (String key : cacheRetiroSinTar.keySet()) { // Iteramos las llaves del mapa con ciclo forEach
            if (key.contains(ref) && key.contains(clave)) { // Si en las llaves existe la referencia y la clave
                existe = true; // Cambiamos la variable existe a true
                llave = key; // Extrae la key (numCuenta:ref:clave) para usarla después
                break;
            }
        }
        if (! existe) { // Si la referencia no existe
            throw new InvalidCardlessWithdrawalException(Constantes.INVALID_CARDLESS_WITHDRAWAL); // Lanzamos excepción
        } else if (cacheRetirosCobrados.contains(ref)) { // Si el caché de retiros cobrados contiene la referencia, o sea que ya fue cobrado
            throw new WithdrawalAlreadyProcessedException(Constantes.CARDLESS_WITHDRAWAL_PROCESSED); // Lanzamos excepción
        } else { // Existe la referencia y no se ha cobrado
            cacheRetirosCobrados.add(ref); // Si existe y no se ha cobrado, añadimos la referencia al conjunto de los retiros ya cobrados
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0]) - cacheRetiroSinTar.get(llave); // Definimos el nuevo saldo
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0], nuevoSaldo); // Con split() creamos un array y obtenemos el índice [0]
            System.out.println("Imprimir ticket?");
            System.out.println("1 (SI), 2 (NO)");
            int seleccion = Integer.parseInt(scan.nextLine());
            if (seleccion != 1) {
                System.out.println("Operación finalizada");
            } else {
                ticket = new Ticket(this.getDireccion(), // Si lo desea, creamos Objeto de tipo ticket para devolverlo
                        folioOperacion++,
                        LocalDateTime.now(),
                        cacheRetiroSinTar.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);
            }
        }
        return ticket;
    }

    @Override
    public Ticket depositar(String numTarjeta, double monto, String nip) { // Metodo que devolverá un Objeto de tipo Ticket
        Ticket ticket = null; // Definimos variable que devolveremos
        try {
            CuentaDTO cuenta = buscarCuenta(numTarjeta, nip); // Buscamos la cuenta con el número de tarjeta y el nip
            if (monto <= 0) {
                throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
            } else if (monto > Constantes.CANTIDAD_MAX_DEPOSITO) { // Si el monto a depositar es mayor a la cantidad máxima permitida
                throw new MaximumDepositQuantityExceededException(Constantes.MAX_QUANTITY_DEPOSIT); // Lanzamos excepción
            } else if ((monto + cuenta.getSaldo()) > cuenta.getSaldoMax()) { // Si el monto a depositar más el saldo son mayores al saldo máximo permitido de la cuenta
                throw new OverMaximumDepositException(Constantes.OVER_MAXIMUM); // Lanzamos mensaje
            } else { // Si pasó todas las validaciones entonces sí podemos depositar
                int index = this.getCacheCuentas().indexOf(cuenta); // Obtengo el índice del Objeto en la Lista
                double nuevoSaldo = cuenta.getSaldo() + monto; // Calculamos el nuevo saldo después del depósito
                cuenta.setSaldo(nuevoSaldo); // Asignamos el nuevo saldo a la cuenta
                this.getCacheCuentas().set(index, cuenta); // Reemplazamos el Objeto con el saldo actualizado en la posición del Objeto original
                // Actualizar el saldo de la cuenta en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo); // Llamamos a este metodo para actualizar el saldo de la cuenta en la db
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "DEPÓSITO", monto); // Llamamos a metodo para registrar el movimiento en la db
                ticket = new Ticket(this.getDireccion(), // Creamos Objeto de tipo Ticket
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "DEPOSITO",
                        "********" + cuenta.getNumCuenta().substring(8)); // Aquí termina la creación del Ticket
            }
        } catch (AccountNotFoundException ex) { // Excepción que podría arrojar ya que se tiene que verificar que exista la cuenta
            ex.printStackTrace();
        }
        return ticket; // Retornamos el Objeto de tipo Ticket
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