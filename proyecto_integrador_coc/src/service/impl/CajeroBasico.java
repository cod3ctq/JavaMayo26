package service.impl;

import constants.Constantes;
import dto.CuentaDTO;
import exception.*;
import models.Atm;
import models.Ticket;
import service.IOperacionesBasicas;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas { // Hereda de 1 e implementa de 1

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardlessWithdrawalException, WithdrawalAlreadyProcessedException {
        Ticket ticket = null; // Definimos variable a delolver
        Scanner scan = new Scanner(System.in);
        System.out.print("Captura la referencia: ");
        String ref = scan.nextLine();

        // Validar que exista la referencia en el mapa cacheRetiroSinTar
        String llave = "";
        boolean existe = false;
        for (String key : cacheRetiroSinTar.keySet()) { // Iteramos las llaves del mapa con ciclo forEach
            if (key.contains(ref)) { // Si en las llaves existe la referencia
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
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0]) - cacheRetiroSinTar.get(llave); // Definimos el nuevo saldo
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0], nuevoSaldo); // Con split() creamos un array y obtenemos el índice [0]
            cacheRetirosCobrados.add(ref); // Si existe y no se ha cobrado, añadimos la referencia al conjunto de los retiros ya cobrados
            System.out.println("Imprimir ticket?");
            System.out.println("1 (SI), 2 (NO)");
            int seleccion = Integer.parseInt(scan.nextLine());
            if (seleccion != 1) {
                System.out.println("Operación finalizada");
            } else {
                // Patrón de diseño Builder: Esto va a construir ahora al ticket, agregando sólo los elementos que tengamos a la mano, ya sean todos o sólo algunos
                // Ahora en realidad se está llamando a métodos para crear el ticket, no a un constructor como tal
                ticket = Ticket.builder().direccion(this.getDireccion())
                        .folio(folioOperacion++)
                        .fecha(LocalDateTime.now())
                        .monto(cacheRetiroSinTar.get(llave))
                        .tipoOperacion("RETIRO")
                        .cuenta(llave.split(":")[0]).build();
            }
        }
        return ticket;
    }

    // Metodo que devolverá un array de tipo Object, puede devolver distintos tipos de datos
    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) throws MaxDailyWithdrawalsExceedException,
            InvalidQuantityException, InsufficientBalanceException, MinimumAllowedException { // Este metodo propagará 4 excepciones que se crearon dentro
        Object[] datos = new Object[2]; // Definimos array de 2 posiciones que es el que devolverá este metodo
        try {
            // Colocar aquí el código que procesa el retiro, asumiendo que ya no necesito validar la existencia de la cuenta
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip); // Almacenamos la cuenta de la que vamos a retirar con el metodo buscarCuenta()
            // Validar que todavía tenga margen de retiro (límite diario 12,000), para esto usamos un Mapa de Listas definido en la Clase models.Atm
            // Buscar si ya existe un retiro del día de hoy y de cuánto fue
            // FALTA ---------- VALIDAR QUE EL MARGEN DISPONIBLE PARA RETIRAR SEA MENOR O IGUAL MONTO A RETIRAR ----------
            if (Atm.getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now()) && // Si existe un registro en el Mapa con esta llave...
                    Atm.getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) { // Y el valor es >= al maximo de retiro
                throw new MaxDailyWithdrawalsExceedException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED); // Lanzamos excepción
            } else if (! (monto % 100 == 0) || monto <= 0) { // Si el monto a retirar NO es múltiplo de 100, o es menor o igual a 0
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY); // Lanzamos excepción
            } else if (monto > cuenta.getSaldo()) { // Si el monto a retirar es mayor que el saldo de la cuenta
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE); // Lanzamos excepción
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) { // Si el saldo menos el monto a retirar es menor al saldo mínimo permitido de la cuenta
                throw new MinimumAllowedException(Constantes.MINIMUM_ALLOWED); // Lanzamos excepción
            } else { // Si pasó todas las validaciones entonces sí podemos retirar
                int index = this.getCacheCuentas().indexOf(cuenta); // Obtengo el índice del Objeto en la Lista
                double nuevoSaldo = cuenta.getSaldo() - monto; // Calculamos el nuevo saldo después del retiro
                cuenta.setSaldo(nuevoSaldo); // Asignamos el nuevo saldo a la cuenta
                this.getCacheCuentas().set(index, cuenta); // Reemplazamos el Objeto con el saldo actualizado en la posición del Objeto original
                // Validar si es el primer retiro de esa cuenta en el día o si ya existen más retiros de esa cuenta en el día
                if (Atm.getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) { // "Si el Mapa contiene la llave con un retiro el día de hoy"
                    Double acumulado = Atm.getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()); // Obtenemos cuánto se ha retirado el día de hoy
                    Atm.cacheRetirosDiarios.put(cuenta.getNumCuenta() + LocalDate.now(), acumulado + monto); // Luego sumamos lo acumulado en retiros más el monto
                } else { // "Si no se ha retirado nada de la cuenta en el día"
                    Atm.getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto); // Guardamos el primer registro en la llave del día de hoy
                }
                // Actualizar el saldo de la cuenta en la db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(), nuevoSaldo); // Llamamos a este metodo para actualizar el saldo de la cuenta en la db
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto); // Llamamos a metodo para registrar el movimiento en la db

                // Patrón de diseño Builder: Esto va a construir ahora al ticket, agregando sólo los elementos que tengamos a la mano, ya sean todos o sólo algunos
                // Ahora en realidad se está llamando a métodos para crear el ticket, no a un constructor como tal
                Ticket t = Ticket.builder().direccion(this.getDireccion())
                        .folio(folioOperacion++)
                        .fecha(LocalDateTime.now())
                        .monto(monto)
                        .tipoOperacion("RETIRO")
                        .cuenta("********" + cuenta.getNumCuenta().substring(8)).build();

                datos[0] = monto; // Asignamos el monto a depositar al array en la posición 0
                datos[1] = t; // Asignamos el Objeto de tipo models.Ticket al array en la posición 1
            }
        } catch (AccountNotFoundException ex) { // Excepción que podría arrojar ya que se tiene que verificar que exista la cuenta
            System.out.println(ex.getMessage()); // Imprimimos el mensaje de la excepción creada
        }
        return datos; // Retornamos el array con el monto a retirar y el Objeto de tipo models.Ticket
    }

    @Override
    public Ticket pagarServicio(String numTarteja, String convenio, String referencia) {
        // Clases nuevas: dao.ServiciosDAO, inyectar desde Clase models.Atm
        Ticket ticket = null;
        boolean ok = this.getServiciosDAO().pagarServicio(numTarteja, convenio, referencia);
        if (ok) {
            // Patrón de diseño Builder: Esto va a construir ahora al ticket, agregando sólo los elementos que tengamos a la mano, ya sean todos o sólo algunos
            // Ahora en realidad se está llamando a métodos para crear el ticket, no a un constructor como tal
            ticket = Ticket.builder().direccion(this.getDireccion())
                    .folio(folioOperacion++)
                    .fecha(LocalDateTime.now())
                    .tipoOperacion("PAGO SERVICIO").build();
        }
        return ticket;
    }
}