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

public class CajeroBasico extends Atm implements IOperacionesBasicas {

    @Override
    public void cobrarRetirosSinTarjeta() {

    }


    @Override
    public Object[] retirar(String numTarjeta, double monto, String nip)
    throws MaxDailyWithdrawalsExceededException, InvalidQuantityException, InsufficientBalanceException,
            UnderMinimunException{
        //Double retiradoHoy;
        Object[] datos = new Object[2];
        try{
            CuentaDTO cuenta = this.buscarCuenta(numTarjeta, nip);
            //colocar aqui todo el codigo que procesa el retiro,
            //asumiemndo que ya no necesito Validar la existencia de la cuenta
            //Buscar si existe ya algun retiro registrado, obtiene cuanto se ha retirado en este dia, si no que nulo
            //********************* Validar que margen disponible sea< MONTO A RETIRAR.
            if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now()) &&
                    getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now())>= Constantes.MAX_RETIRO_DIARIO){ //si el monton retirado supera el maximo.
                //Registro el retiro y guardo el monto que acabo de retirar
                getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(), monto);
               // System.out.println("Retiro no disponible, se ha superado, la cantidad diaria de retiro permitida");
                throw new MaxDailyWithdrawalsExceededException(Constantes.MAX_DAILY_WITHDRAWAL_EXCEEDED);
            }else if(! (monto%100==0) ){//cantidad multiplo de 100
               throw new InvalidQuantityException(Constantes.INVALID_QUANTITY);
               // System.out.println("cantidad invalida, debe ser multiplo de 100");
            } else if (cuenta.getSaldo()<monto){//Verificar si me alcanza
//                System.out.println("Saldo insuficiente");
                throw new InsufficientBalanceException(Constantes.INSUFFICENT_BALANCE);
            } else if ( (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()) { //Validar que si retiro, quede por encima del minimo
//                System.out.println("Retiro no disponible. Excede el minimo permitido");
                throw new UnderMinimunException(Constantes.UNDER_MINIMUN);
            }else { //retirar

                //calculo el indice del objeto original  dentro de la lista
                int index = this.getCacheCuentas().indexOf(cuenta);
                //retirar
                double nuevoSaldo = cuenta.getSaldo()-monto;
                cuenta.setSaldo((nuevoSaldo));
                //repmlazo el objeto con el saldo actualizado en la posicion donde estaba en un inicio
                this.getCacheCuentas().set(index, cuenta);

                //determinar si es su primer retiro o si ya existe registro de retiros de esta cuenta en este dia.
                if (getCacheRetirosDiarios().containsKey(cuenta.getNumCuenta()+LocalDate.now())){

                    double acomulado =getCacheRetirosDiarios().get(cuenta.getNumCuenta()+LocalDate.now());

                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),acomulado+monto);

                } else {
                    getCacheRetirosDiarios().put(cuenta.getNumCuenta()+LocalDate.now(),monto);

                    //Acuatlizar el saldo de la cuenta en db
                    getCuentadao().actualizarSaldoCuenta(cuenta.getNumCuenta(),nuevoSaldo);

                    //registrar el movimiento
                    getMovimientodao().registrarMocimiento(cuenta.getCuentaId(),"RETIRO",monto);
                }


                Ticket t = new Ticket(this.getDireccion(),
                        folioOperacion++,
                        LocalDateTime.now(),
                        monto, "RETIRO",
                        "*******"+cuenta.getNumCuenta().substring(8));
                datos[0] = monto;
                datos[1] = t;
            }
        } catch (AccountNotFoundException ex){

            System.out.println(ex.getMessage());//imprime solo el mensaje de la excepcion

        }

        return datos;
    }

    @Override
    public Ticket pagarServicio(String convenio, String referencia) {
        return null;
    }

    @Override
    public void cobrarRetiroSinTarjeta() {

    }
}
