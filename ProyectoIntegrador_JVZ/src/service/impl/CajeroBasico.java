package service.impl;

import constants.COnstantes;
import dto.CuentaDTO;
import exception.*;
import models.ATM;
import models.Ticket;
import service.IOperacionesbásicas;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class CajeroBasico extends ATM implements IOperacionesbásicas {



    @Override
    public Ticket cobrarRetiroSinTarjeta() throws InvalidCardNumberException, WithdrawalAlreadyReceivedException{

        Ticket ticket = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("CAPTURA LA REFERENCIA");
        String ref = scan.nextLine();


        //Buscar que exista la referencia
        boolean existe = false;
        String llave = "";
        for (String key:cacheRST.keySet()){
            if(key.contains(ref)){
                existe = true;
                llave = key;  //Extrae la key(num_cuenta, ref: clave) para usarla despues
                break;
            }
        }



        //--- La ref no existe, lanzar mensaje
        if (!existe){
            System.out.println("Retiro sin tarjeta invalido");
            throw new InvalidCardNumberException(COnstantes.INVALID_CARD_NUMBER);
        }else if (cacheRetirosCobrados.contains(ref)){   //Si ya fue cobrado
            System.out.println("Retiro sin tarjeta ya cobrado");
            throw new WithdrawalAlreadyReceivedException(COnstantes.WITHDRAWAL_AlREADY_RECEIVED);
        }else {
            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0]) - cacheRST.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);
            cacheRetirosCobrados.add(ref); // añade el retiro al conjunto de los ya cobrados.
            System.out.println("IMPRIMIR TICKET ??");
            System.out.println("Presiona 1 (SI), 2 (NO)");
            int seleccion = scan.nextInt();

            if (seleccion!=1){
                System.out.println("Operacion finalizada");
            }else {

                //Construye el objeto aplicando el patron builder: Encadena solo los datos que tengas, asi sean todos o solo algunos
                ticket = Ticket.builder().direccion(this.getDirecciones()).
                        folio(folioOperaciones++).fecha(LocalDate.now()).
                        monto(cacheRST.get(llave)).tipoOperacion("RETIRO").
                        cuenta(llave.split(":")[8]).build();

            }

        }
        return ticket;

    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
            throws MaxDailyWithdrawalsExceededException, InvalidQunatityException,
            InsufficentBalanceException, UnderMinimunException {
        Object[] datos = new Object[2];
        try {
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            if (getCacheRetiroDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetiroDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>=COnstantes.MAX_RETIRO_DIARIO){  //Si el monto retirado supera el maximo
                throw new MaxDailyWithdrawalsExceededException(COnstantes.MAX_DAILYWITHDRAWAL_EXCEEDED);
            }else if (!(monto%100==0) || monto<=0 ){ // Validar que cantidad sea multiplo de 100
                throw new InvalidQunatityException(COnstantes.INVALID_QUANTITY);
            } else if (cuenta.getSaldo() < monto){ //Verificar si me alcanza
                throw new InsufficentBalanceException(COnstantes.INSUFFICENT_BALANCE);
            } else if ((cuenta.getSaldo()- monto) < cuenta.getSaldoMin()){ //Validar que si retiro, quede por encima del minimo
                throw new UnderMinimunException(COnstantes.UNDERMINIMUN_EXCEPTION);
            }else {

                //Calculo el indice del objeto dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //Retirar
                double nuevoSaldo = cuenta.getSaldo() - monto;
                cuenta.setSaldo(nuevoSaldo);
                //Reemplaza el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);
                //Determinar si es su primer retiro o si ya existe registro de retiro de esta cuenta en este dia.
                if (getCacheRetiroDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){
                    double acumulado =  getCacheRetiroDiarios().get(cuenta.getNumCuenta()+LocalDate.now());
                    getCacheRetiroDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),
                            acumulado+monto);
                }else {
                    getCacheRetiroDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
                }
                //Actualizar el saldo de la cuenta en db
                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
                //Registar el movimiento
                getMovimientodao().resgistrarMovimiento(cuenta.getCuentaId(), "RETIRO", monto);


                Ticket t = Ticket.builder().direccion(this.getDirecciones()).
                        folio(folioOperaciones++).fecha(LocalDate.now()).
                        monto(monto).tipoOperacion("RETIRO").
                        cuenta("*******"+cuenta.getNumCuenta().substring(8)).build();

                datos[0] = monto;
                datos[1] = t;
            }
        }catch (AccountNotFoundException ex){
            System.out.println(ex.getMessage()); //Imprime solo el mensaje de la excepcion

        }
        return datos;
    }
    @Override
    public Ticket pagarServcicio(String numTarjeta,String convenio, String referencia) {
        //Clases nuevas: Servicios DAO, inyectar desde Atm
        Ticket ticket = null;
        boolean ok = this.getServiciosDAO().pagarServicios(numTarjeta, convenio, referencia);
        System.out.println("[[[[[[[[[[["+ok);

        if (ok){
            //La construccion del objeto implementa el patron builder .....
            ticket =  Ticket.builder().direccion(this.getDirecciones()).
                    folio(folioOperaciones++).fecha(LocalDate.now()).tipoOperacion("PAGO SERVICIOS").build();
            System.out.println("$$$$$$$$$$$ "+ticket);
            //Implementar aqui el patron builder .....

        }
        return ticket;



    }
}
