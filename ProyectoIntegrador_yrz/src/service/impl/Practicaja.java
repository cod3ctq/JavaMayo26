package service.impl;

import constants.Constantes;
import dto.CuentaDTO;
import exception.InvalidNumberReferenceException;
import exception.InvalidQuantityException;
import exception.MaximumDepositQuantityExceededException;
import exception.OverMaximumDepositException;
import models.Atm;
import models.Ticket;
import service.IOperacionesAvanzadas;
import service.IOperacionesBasicas;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Practicaja extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {

//    private dao.CuentaDAO cuentadao = new dao.CuentaDAO();
//    private dao.MovimientoDAO movimientodao= new dao.MovimientoDAO();
//
//    @Override
//    public models.Ticket cobrarRetirosSinTarjeta() {
//    return null;
//    }
//
//    @Override
//    public void cobrarRetiroSinTarjeta() {
//
//    }
//
//
//    @Override
//    public models.Ticket depositar(String numTarjeta, double monto, String nip) {
//        models.Ticket ticket  = null;
//
//        try{
//            dto.CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
//            if(monto<=0){
//                throw new exception.InvalidQuantityException(constants.Constantes.ONLY_POSITIVE);
//            }
//            if(monto>constants.Constantes.CANTIDAD_MAX_DEPOSITO){
//            throw new exception.MaximumDepositQuantityExceededException(constants.Constantes.MAX_QUANTITY_DEPOSIT);
//        }else if((cuenta.getSaldo()+monto)>cuenta.getSaldoMax()){
//            throw new exception.OverMaximumDepositException(constants.Constantes.OVER_MAXIMUM);
//        }else{
//                //calcula el indice del objeto original dentro de la lista
//                int index= this.getCacheCuentas().indexOf(cuenta);
//                //calcula el nuevo saldo
//                double nuevoSaldo = cuenta.getSaldo()+monto;
//                //alera el saldo en el objeto del cache
//            cuenta.setSaldo(cuenta.getSaldo()+monto);
//            //remplaza el objeto con el nuevo saldo, en el lugar del objeto original
//                this.getCacheCuentas().set(index,cuenta);
//
//                //Acuatlizar el saldo de la cuenta en db
//                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
//
//                //registrar el movimiento
//                getMovimientodao().registrarMocimiento(cuenta.getCuentaId(),"DEPOSITO",monto);
//
//
//                ticket = new models.Ticket(this.getDireccion(),
//                    folioOperacion++,
//                    LocalDateTime.now(),
//                    monto,
//                    "DEPOSITO",
//                    "*******" + cuenta.getNumCuenta().substring(8));
//
//        }
//        }catch(exception.AccountNotFoundException ex){
//            ex.printStackTrace();
//        }
//
//      if (!(cuenta != null)){
//            System.out.println("la cuenta no existe! no es posible depositar");
//        }else
//
//        return ticket;
//    }
//
//
//    @Override
//    public Object[] retirar(String numTarjeta, double monto, String nip) {
//        return new Object[0];
//    }
//
//    @Override
//    public models.Ticket pagarServicio(String convenio, String referencia) {
//        return null;
//    }
@Override
public Ticket cobrarRetiroSinTarjeta() throws InvalidNumberReferenceException {
    Ticket ticket = null;
    Scanner scan = new Scanner(System.in);
    System.out.println("Capture la referencia: ");
    String ref = scan.nextLine();
    System.out.println("capture la clave");
    String clave = scan.nextLine();
    boolean existe = false;
    String llave = "";
    for (String key : cacheRst.keySet()) {
        if (key.contains(ref) && (key.contains(clave))) {
            existe = true;
            llave = key;
            break;
        }
    }
    if (!existe){
        throw new InvalidNumberReferenceException(Constantes.INVALID_NUMBER_REFERENCE);
//            System.out.println("retiro sin tarjeta invalido");
    }else if(cacheRetirosCobrados.contains(ref)){
        throw new InvalidQuantityException(Constantes.ONLY_POSITIVE);
        //   System.out.println("Retiro sin tarjeta ya cobrado");
    }else{
        double nuevoSaldo=getCuentadao().getSaldoCuenta(llave.split(":")[0])-cacheRst.get(llave);

        System.out.println("nuevo saldo: "+nuevoSaldo);
        getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);

        cacheRetirosCobrados.add(ref);
        System.out.println("IMPRIMIR TICKET ??");
        System.out.println("presiona 1 (si), 2 (no)");
        int seleccion = scan.nextInt();

        if(seleccion!=1){
            System.out.println("operacion finalizada");
        }else{
            Ticket.builder().direccion(this.getDireccion()).
                    folio(folioOperacion++).fecha(LocalDateTime.now()).
                    monto(cacheRst.get(llave)).tipoOperacion("RETIRO").
                    cuenta(llave.split(":")[0]).build();
        }
    }
    return ticket;
}

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
            getMovimientodao().registrarMocimiento(cuenta.getCuentaId(), "DEPOSITO", monto);



            ticket = Ticket.builder().direccion(this.getDireccion()).
                    folio(folioOperacion++).fecha(LocalDateTime.now())
                    .monto(monto).tipoOperacion("DEPOSITO").
                    cuenta("*******"+cuenta.getNumCuenta().substring(8)).build();
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }


    return ticket;
}


//    @Override
//    public models.Ticket depositar(String numTarjeta, double monto, String nip) {
//        models.Ticket ticket = null;
//
//        try{
//            dto.CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
//            if (monto<=0){
//                throw new exception.InvalidQuantityException(constants.Constantes.ONLY_POSITIVE);
//            } else if (monto > constants.Constantes.CANTIDAD_MAX_DEPOSITO) {
//                throw  new exception.MaximumDepositQuantityExceededException(constants.Constantes.MAX_QUANTITY_DEPOSIT);
//            } else if ((cuenta.getSaldo() + monto) > cuenta.getSaldoMax()) {
//                throw  new exception.OverMaximumDepositException(constants.Constantes.OVER_MAXIMUM);
//            }else{
//                //Calculo en indice del objeto original dentro de la lista
//                int index = this.getCacheCuentas().indexOf(cuenta);
//                //calculo el nuevo saldo
//                double nuevoSaldo = cuenta.getSaldo() + monto;
//                //altera el saldo en el objeto del cache
//                cuenta.setSaldo( nuevoSaldo);
//                //reemplaza el objeto con el nuevo saldo, en lugar del objeto original
//                this.getCacheCuentas().set(index, cuenta);
//                //actualizar el saldo de la cuenta en db
//                getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);
//                //registrar el movimiento
//                getMovimientodao().registrarMocimiento(cuenta.getCuentaId(), "DEPOSITO", monto);
//
//
//                ticket = new models.Ticket(this.getDireccion(),
//                        folioOperacion++,
//                        LocalDateTime.now(),
//                        monto,
//                        "DEPOSITO",
//                        "*******"+cuenta.getNumCuenta().substring(8));
//
//            }
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        return ticket;
//    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
    }

    @Override
    public Ticket pagarServicio(String numTarjeta, String convenio, String referencia) {
        return null;
    }
}

