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

public class CajeroBasico extends Atm implements IOperacionesBasicas {

    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumberException, WithdrawalAlreadyReceivedException{

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();

        //buscar que exista la referencia
        boolean existe = false;
        String llave="";
        for(String key:cacheRst.keySet()){
            if (key.contains(ref)) {
                existe = true;
                llave = key; //Extrae la key(numCuenta:ref:clave) para usarla despues
                break;
            }
        }
        //-- la ref no existe, lanzar mensaje
        if(!existe){
            System.out.println("Retiro sin tarjeta invalido");
            throw new InvalidCardNumberException(Constantes.INVALID_CARD_NUMBER);
        }else if(cacheRetirosCobrados.contains(ref)) { //si ya fue cobrado ...
            System.out.println("Retiro sin tarjeta ya cobrado");
            throw new WithdrawalAlreadyReceivedException(Constantes.WITHDRAWAL_ALREADY_RECEIVED);
        }else{
            double nuevoSaldo = getCuentadao().getSaldoCuenta( llave.split(":")[0]) - cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);
            cacheRetirosCobrados.add(ref); //añade el retiro al cojunto de los ya cobrados
            System.out.println("IMPRIMIR TICKET ??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion = scan.nextInt();

            if(seleccion!=1){
                System.out.println("Operacion Finalizada");
            }else{
                //construye el objeto aplicando el patron builder: Encadena solo los datos que tengas asi sean todos o solo algunos
                ticket = Ticket.builder().direccion(this.getDireccion()).
                        folio(folioOperacion++).fecha(LocalDateTime.now()).
                        monto(cacheRst.get(llave)).tipoOperacion("RETIRO").
                        cuenta(llave.split(":")[0]).build();
            }
        }
        return ticket;
    }
    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQuantityException,
            InsufficentBalanceException,UnderMinimunException{
        Object[] datos = new Object[2];
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if(   getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=Constantes.MAX_RETIRO_DIARIO)  { //Si el monto retirado supera el maximo
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if( ! (monto%100==0) || monto<=0 ){ //validar que cantidad multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if(cuenta.getSaldo() <  monto){ //Verificar si me alcanza
                throw new InsufficentBalanceException(Constantes.INSUFFICENT_BALANCE);
            }else if( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()){ //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimunException(Constantes.UNDER_MINIMUN);
            }else{
                //calculo el indice del objeto original dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //reemplaza el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //Determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
                if(getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado =getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),
                            acumulado+monto);
                }else{
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
                }
                //Actualiza el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registra el movimiento
                getMovimientodao().registrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto);

                //Objeto construido con el patron builder
                Ticket t = Ticket.builder().direccion(this.getDireccion()).
                        folio(folioOperacion++).fecha(LocalDateTime.now()).
                        monto(monto).tipoOperacion("RETIRO").
                        cuenta("*******"+cuenta.getNumCuenta().substring(8)).build();
                datos[0] = monto;
                datos[1] = t;
            }
        }catch(AccountNotFoundException ex){
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion
        }
        return datos;
    }

    @Override
    public Ticket pagarServicio(String numTarjeta, String convenio, String referencia) {
        //Clases nuevas: dao.ServiciosDAO, inyectar desde models.Atm
        Ticket ticket = null;
        boolean ok = this.getServiciosDAO().pagarServicio(numTarjeta, convenio, referencia);
        if (ok) {
            //La construccion del objeto implementa el patron builder ....
            ticket =  Ticket.builder().direccion(this.getDireccion()).
                    folio(folioOperacion++).fecha(LocalDateTime.now()).tipoOperacion("PAGO SERVICIOS").build();
        }
        return ticket;
    }
}
