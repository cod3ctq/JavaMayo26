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
    public Ticket cobrarRetirosSinTarjeta() throws InvalidNumberReferenceException, WithDrawalAlreadyCollectedException{
        Ticket  ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();

        //busca la existencia de la referencia
        boolean existe = false;
        String llave="";
        for (String key:cacheRst.keySet()){
            if (key.contains(ref)){
                existe = true;
                llave = key; //extrae la ref:clave para usarla despues
                break;
            }
        }

        //-- la referencia no existe, lanzar mensaje
        if (!existe){
            throw new InvalidNumberReferenceException(Constantes.INVALID_NUMBER_REFERENCE);
            //System.out.println("Retiro sin tarjeta invalido");
        } else if (cacheRetirosCobrados.contains(ref)){ //validar si ya fue cobrado
            throw new WithDrawalAlreadyCollectedException(Constantes.WITHADRAWAL_ALREADY_COLLECTED);
            //System.out.println("Retiro sin tarjeta ya cobrado");
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
                //construye el objeto aplicando el patron Builder:
                //encadena solo los datos que tengas asi
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
            InsufficentBalanceExeption, UnderMinimumException{
        //Double retiradoHoy;
        Object[] datos = new Object[2];
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);

            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>= Constantes.MAX_RETIRO_DIARIO){ //si el monton retirado supera el maximo.
                //Registro el retiro y guardo el monto que acabo de retirar
                getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(), monto);
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if(! (monto%100==0) || monto<=0){//cantidad multiplo de 100
                throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo()<monto){//Verificar si me alcanza
                throw new InsufficentBalanceExeption(Constantes.INSUFFICENT_BALANCE);
            } else if ( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) { //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimumException(Constantes.UNDER_MINIMUM);
            }else {
                //calcular el indice del objeto dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo( nuevoSaldo);
                //reemplazar el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);

                //determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia.

                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){

                    double acomulado =getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());

                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),acomulado+monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);

                }
                //actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //registrar el movimiento
                getMovimientodao().registraMovimiento(cuenta.getCuentaId(), "RETIRO", monto);


                Ticket t = Ticket.builder().direccion(this.getDireccion()).
                        folio(folioOperacion++).fecha(LocalDateTime.now()).
                        monto(monto).tipoOperacion("RETIRO").
                        cuenta("********"+cuenta.getNumCuenta().substring(8)).build();
                datos[0] = monto;
                datos[1] = t;
            }
        } catch (AccountNotFoundException ex){

            System.out.println(ex.getMessage());//imprime solo el mensaje de la excepcion

        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String numTarjeta, String convenio, String referencia) {

        Ticket ticket = null;
        boolean ok= this.getServiciosDAO().pagarServicio(numTarjeta, convenio, referencia);

        if (ok){
            //LA CONSTRUCCION DEL OBJETO IMPLEMENTA EL PATRON Builder
            ticket = Ticket.builder().direccion(this.getDireccion()).
                    folio(folioOperacion++).fecha(LocalDateTime.now()).tipoOperacion("PAGO SERVICIOS").build();
        }


        return ticket;
    }
}
