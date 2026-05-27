package service.impl;

import constants.Constantes;
import dto.CuentaDTO;
import exception.*;
import models.Atm;
import models.Ticket;
import service.iOperacionesBasicas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements iOperacionesBasicas {

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumberException, WithdrawalAlreadyDoneException {

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();
        String clave = scan.nextLine();
        //validar que exista la referencia
        //buscar que exista la referencia
        boolean existe = false;
        String llave="";
        for(String key:cacheRst.keySet()){
            if(key.contains(ref) && key.contains(clave)){
                existe = true;
                llave = key;//Extrae la (numCuenta:ref:clave) para usarla despues
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
                return null;
            }else{
                ticket = Ticket.builder().direccion(this.getDireccion()).
                        folio(folioOperacion++).fecha(LocalDateTime.now()).
                        monto(cacheRst.get(llave)).tipoOperacion("RETIRO").
                        cuenta(llave.split(":")[0]).build();
            }


        }


        //Validar si ya fue cobrada
            //si - lanzar mensaje
            //no - proceder al cobro
            //registrar el cobro

        return ticket;
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
        throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficientBalanceException, UnderMinimumException {

        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //validar que todavia tenga margen de retiro
            //Si existe registro de retiro, obtiene cuanto se ha retirado en este dia
            //Si no, se queda nulo
            //retiradoHoy = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());

            //******************** VALIDAR QUE MARGEN DISPONIBLE SEA <= MONTO A RETIRAR
            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now()) &&//SI el monto retirado supera el maximo
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) {
                //System.out.println("Retiro no disponible, se ha superado la cantidad maxima permitida");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);

            } else if (!(monto % 100 == 0) || monto>=0) {//cantidad muitplo de 100
                //System.out.println("Cantidad invalida, debe ser multiplo de 100");
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto) {//Verificar si me alcanza
                //System.out.println("Saldo insuficiente");
                throw new InsufficientBalanceException(Constantes.INSUFFICIENT_BALANCE);
            } else if ((cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) {//Validar que si retiro,quede encima del minimo
                //System.out.println("Retiro no disponible. Excede el minimo permitido");
                throw new UnderMinimumException(Constantes.UNDER_MINIMUM);
            } else {

                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);

                //Retirar
                double nuevoSaldo = cuenta.getSaldo()- monto;
                cuenta.setSaldo(nuevoSaldo);
                //Actualizar el saldo del objeto guardado en el cache
                this.getCacheCuentas().set(index,cuenta);
                //determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
                    double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), acumulado + monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
                }
                //actualizar saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                // Registrar el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(),"RETIRO", monto);

                Ticket t = Ticket.builder().direccion(this.getDireccion()).
                        folio(folioOperacion++).fecha(LocalDateTime.now()).
                        monto(monto).tipoOperacion("RETIRO").
                        cuenta("*******" + cuenta.getNumCuenta().substring(8)).build();

                datos[0] = monto;
                datos[1] = t;
            }
            //colocar aqui todo el codigo que procesa el retiro asumiendo que ya no necesito validar la existencia
            //de la cuenta
        } catch (AccountNotFoundException ex) {
            System.out.println(ex.getMessage());//imprime el mensaje de la excepcion
        }
        //sino
        // Lanzar mensaje
        return datos;
    }

    @Override
    public Ticket pagarServicio(String numTarjeta, String convenio, String referencia) {
        //Clases nuevas: dao.ServiciosDAO, inyectar desde atm
        Ticket ticket = null;
        boolean ok = this.getServiciosDAO().pagarServicio(numTarjeta, convenio, referencia);
        if(ok){
            ticket = Ticket.builder().direccion(this.getDireccion()).
                    folio(folioOperacion++).fecha(LocalDateTime.now()).
                    tipoOperacion("PAGO SERVICIOS").build();
                    //Implementar aqui el patron builder....
        }
        return ticket;
    }
}
