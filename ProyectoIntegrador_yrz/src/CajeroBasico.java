//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//public class CajeroBasico extends Atm implements IOperacionesBasicas {
//    @Override
//    public void cobrarRetiroSinTarjeta() {
//
//    }
//
//    @Override
//    public Object[] retirar(String numTarjeta, double monto, String nip) {
//        Double retiradoHoy = 0.0;
//
//
//        //Si la cuenta existe..
//        //Verificar si alcanza
//
//        //Validad que si retiro, quede por encima del minimo
//        try {
//            //Colocar aqui todo el codigo que procesa el retiro,
//            //asumiendo que ya no necesito validar la existencia de la cuenta
//            Cuenta cuenta = this.buscarCuenta(numTarjeta, nip);
//            Object[] datos = new Object[2];
////si la cuenta NO existe ...
////        if( ! (cuenta!=null) ){
////
////            System.out.println("La cuenta no existe !. No es posible retirar");
////        }else
////        {
//            //validar que todavia tenga margen de retiro
//            //Si existe registro de retiro, obtiene cuanto se ha retirado en este dia, sino, se queda nulo
//            //*****************  VALIDAR QUE MARGEN DISPONIBLE SEA <= MONTO A RETIRAR
//            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now()) &&
//                    getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) { //Si el monto retirado supera el maximo
//                System.out.println("Retiro no disponible, se ha superado la cantidad diaria de retiro permitida");
//                throw new MaxDailyWithdrawalsExceededException();
//            } else if (!(monto % 100 == 0)) { //validar que cantidad multiplo de 100
//                System.out.println("Cantidad invalida, debe ser multiplo de 100");
//            } else if (cuenta.getSaldo() < monto) { //Verificar si me alcanza
//                System.out.println("Saldo insuficiente");
//            } else if ((cuenta.getSaldo() - monto) < Constantes.SALDO_MIN) { //Validar que si retiro, quede por encima del minimo
//                System.out.println("Retiro no disponible. Excede el minimo permitido");
//            } else {
//                //retirar
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//
//        }
//
//            cuenta.setSaldo(cuenta.getSaldo() - monto);
//            //Determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia
//            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
//                double acumulado = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
//                getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(),
//                        acumulado + monto);
//            } else {
//                getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), monto);
//            }
//            Ticket t = new Ticket(this.getDireccion(),
//                    folioOperacion++,
//                    LocalDateTime.now(),
//                    monto,
//                    "RETIRO",
//                    "*******" + cuenta.getNumCuenta().substring(8));
//            datos[0] = monto;
//            datos[1] = t;
//        }
//    }
//
//    @Override
//    public Ticket pagarServicio(String convenio, String referencia) {
//        return null;
//    }
//}
//
//    @Override
//    public Ticket pagarServicio(String convenio, String referencia) {
//        return null;
//    }
//          return datos;
////        //Si la cuenta no existe
////        if (!(cuenta != null)) {
////            System.out.println("La cuenta no existe");
////        } else // si existe
////        {          //Si el saldo que me da es menor al monto, entonces
////            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())) {
////                //Validar que todavia tenga margen de retiro
////                //buscar si existe ya algun retiro hecho porm i cuenta, el dia de hoy, y de cuanto fue
////                // sI EXISTE REGISTRO SE OBTIENE CUANDO
////
////                retiradoHoy = getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now());
////
//////*********** VALIDAR QUE MARGEN DISPONIBLE SEA MENOR AL MONTO A RETIRAR
////                if (retiradoHoy >= Constantes.MAX_RETIRO_DIARIO) {
////                    System.out.println("Retiro no disponible, se ha superado la cantidad diaria de retido permitido");
////                } else if (!(monto % 100 == 0)) {            // multiplo de 100
////                    System.out.println("Cantidad invalida, debe ser multiplo de 100");
////                }
////
////            }
////
////            if (cuenta.getSaldo() < monto) {
////                System.out.println("Saldo insuficiente");
////                //Si El saldo menos el monto < constante
////            } else if ((cuenta.getSaldo() - monto) < Constantes.SALDO_MIN) {//validar que si retiro quede por encima del minimo
////                System.out.println("Retiro no disponible");
////            } else {
////                cuenta.setSaldo(cuenta.getSaldo() - monto);
////                //Determinar si es su primer retiro o si ya existe registro de retiros d eesta cuenta antes
////
////                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta() + LocalDate.now())
////                        && getCacheRetirosDiarios().get(cuenta.getNumCuenta() + LocalDate.now()) >= Constantes.MAX_RETIRO_DIARIO) {
////                    //getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);
////                    System.out.println("Retiro no disponible. se ha superado la cantidad max. permitida");
////
////                } else {
////                    getCacheRetirosDiarios().put(cuenta.getNumCuenta() + LocalDate.now(), + monto);
////                }
////                Ticket t = new Ticket(this.getDireccion(), folioOperacion++,
////                        LocalDateTime.now(), monto, "Retiro",
////                        "*******" + cuenta.getNumCuenta().substring(8));
////                datos[0] = monto;
////                datos[1] = t;
////
////            }
////
////        }
////        return datos;
//
//}
//
//@Override
//public Ticket pagarServicio(String convenio, String referencia) {
//    return null;
//}
//}
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CajeroBasico extends Atm implements IOperacionesBasicas, IOperacionesAvanzadas {


    Scanner scan = new Scanner(System.in);
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
                getMovimientodao().registrarMocimiento(cuenta.getCuentaId(), "DEPOSITO", monto);


                ticket = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto,
                        "DEPOSITO",
                        "*******"+cuenta.getNumCuenta().substring(8));

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return ticket;
    }

    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip) {
        return new Object[0];
//        throws MaxDailyWithdrawalsExceededException,InvalidQuantityException,
//                InsufficientBalanceException {...}
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }

    @Override
    public Ticket cobrarRetiroSinTarjeta() {
        Ticket ticket = null;
        System.out.println("CAPTURA LA REFERENCIA: ");
        String ref = scan.nextLine();

        boolean existe = false;
        String llave = "";
        for(String key:cacheRst.keySet()){
            if(key.contains(ref)){
                existe = true;
                llave=key;
                break;
            }
        }

        //---la ref existe, ahora, lanzar mensaje,
        if (!existe){
throw new InvalidNumberReferenceException(Constantes.INVALID_NUMBER_REFERENCE);
        } else if(cacheRetirosCobrados.contains(ref)){    //validar si ya fue cobrado con el set cacheRetirosCobrados
throw new WhithdrawalAlreadyCollectedException(Constantes.WHITADRAWAL_ALREADY_COLLECTED);
        } else {

            double nuevoSaldo = getCuentadao().getSaldoCuenta(llave.split(":")[0])-cacheRst.get(llave);
            getCuentadao().actualizarSaldoCuenta(llave.split(":")[0],nuevoSaldo);

            cacheRetirosCobrados.add(ref);//añade el retiro al set cacheRetirosCobrados

            System.out.println("IMPRIMIR TICKEY ??");
            System.out.println("Presiona 1 (si), 2 (no)");
            int seleccion = scan.nextInt();

            if(seleccion != 1){
                System.out.println("Operacion finalizada");
            }
            else {
                ticket = new Ticket(this.getDireccion(),
                        ++folioOperacion,
                        LocalDateTime.now(),
                        cacheRst.get(llave),
                        "RETIRO",
                        llave.split(":")[0]);
            }

        }

        return ticket;
    }
}

