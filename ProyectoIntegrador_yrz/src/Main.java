import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;
import service.impl.CajeroBasico;
import service.impl.ModuloAtencion;
import service.impl.Practicaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

//    models.Atm uno = new models.Atm("Av juarez 23", "e102");
//
//    uno.consultarSaldo("", "");
        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av hidalgo");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av hidalgo 121");
        pc.setFolio("JSJDO");

        //no es posible acceder a un miembro privado aunque haya sido heredado
        //solo se hereda lo public y protected
        //private se hereda
        //cb.cargarCuentas();


        imprimeLogo();
//
//        //ciclo temporal, solo para probar el metodo que lee las cuentas desde las database
//        for(dto.CuentaDTO dto : cb.getCacheCuentas()){
//            System.out.println(dto);
//        }

//        ciclo temporal,solo para ver que retiros sin tarjeta existe publicados
//        cb.gerarRetiroSinTarjeta();//invoca al metodo que genera los retiros
//
//        for (String ret:cb.getCacheRst().keySet()){
//            System.out.println(ret+" - "+cb.getCacheRst().get(ret));
//        }
//        Scanner scan = new Scanner(System.in);
//        int c=1;
//        while(c>0) {
//            models.Ticket rstc = pc.cobrarRetiroSinTarjeta();
//            System.out.println(rstc);
//            System.out.println("CONTINUAR ??");
//            System.out.println("1-Si, 0-no");
//            c = scan.nextInt();
//        }
//
//        }
//    models.Ticket ti=cb.pagarServicio("5578123412340003","SAT005","SAT-2026-0003");
//        System.out.println(">>>>>> SALDO INICIAL DE LA CUENTA >>>>>: ");
//        cb.consultarSaldo("5578123412340003","3456");
//        System.out.println(ti);

//        Object[] resultados = cb.retirar("5578123412340006",5000,"6789");
//        System.out.println("RETIRO 1 $$$ : "+(double)resultados[0]);
//        System.out.println((models.Ticket)resultados[1]);
//        cb.consultarSaldo("5578123412340006","6789");
//        cb.inspeccionarCacheRetirosDiario();

//
//       //System.out.println(cb.retirar("4532987612457789",500,"7750"));
//        Object[] resultados=cb.retirar("5478123498761234",5000,"4821");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((models.Ticket)resultados[1]);
//        Object[] resultados1=cb.retirar("5478123498761234",5000,"4821");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados[1]);
//        System.out.println((models.Ticket)resultados[1]);
//        Object[] resultados2=cb.retirar("5478123498761234",2000,"4821");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados[2]);
//        System.out.println((models.Ticket)resultados[1]);
//        Object[] resultados3=cb.retirar("5478123498761234",100,"4821");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados[3]);
//        System.out.println((models.Ticket)resultados[1]);
//
//        //Object[] resultados2=cb.retirar("4532987612457789",500,"7750");
//        // SI MANDAMOS A IMPRIMIR SOLAMENTE EL OBJETO NOS DARA LA DIRECCION DE MEMORIA DE ESE OBJETO
//
//    //ES NECESARIO CASTEAR LO QUE HAY DENTRO DEL OBJETO, PARA QUE ASI PODAMOS CONOCER LO QUE HAY DENTRO DEL OBJETO
//        //EL CASTEO TIPO DOUBLE QUEDARIA ASI PARA EL PRIMER ELEMENTO (POSICION 0)
//        double efectivo=(double) resultados[0];
//
//       //  casteo = una conversion directa
//
//       // EL CASTEO DEL 2DO ELEMENTO TIPO OBJECT SERIA UN ARRAY CON LA INFORMACIÓN DEL TICKET
//       //  YA LLEVA SU ARREGLO CON SUS ATRIBUTOS DEFINIDOS DEBIDO AL METODO TO STRING QUE VIVE DENTRO DE LA CLASE TICKET
//        models.Ticket ticket=(models.Ticket)resultados[1];
//        models.Ticket ticket1=(models.Ticket)resultados1[1];
//        models.Ticket ticket2=(models.Ticket)resultados2[1];
//        models.Ticket ticket3=(models.Ticket)resultados3[1];





//
//        System.out.println(ticket);
//        cb.consultarSaldo("5478123498761234","4821");
//        System.out.println(ticket1);
//        cb.consultarSaldo("5478123498761234","4821");
//        System.out.println(ticket2);
//        cb.consultarSaldo("5478123498761234","4821");
//        System.out.println(ticket3);
//        cb.consultarSaldo("5478123498761234","4821");
//
//        System.out.println(efectivo);
//
//          double efectivo1=(double) resultados2[0];

         //casteo = una conversion directa

      //  EL CASTEO DEL 2DO ELEMENTO TIPO OBJECT SERIA UN ARRAY CON LA INFORMACIÓN DEL TICKET
      //   YA LLEVA SU ARREGLO CON SUS ATRIBUTOS DEFINIDOS DEBIDO AL METODO TO STRING QUE VIVE DENTRO DE LA CLASE TICKET
//        models.Ticket ticket1=(models.Ticket)resultados2[1];
//
//        System.out.println(efectivo1);
//        System.out.println(ticket1);
//
//
//       models.Ticket t1=pc.depositar("5578123412340006",3500,"6789");
//       System.out.println(">>Deposito : "+t1);
//       pc.consultarSaldo("5578123412340006","6789");
//       System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5478123498761234", "4821");
//
//        Object[] resultados = cb.retirar("5478123498761234", 5000, "4821");
//        System.out.println("RETIRO 1 $$$ : " + (double) resultados[0]);
//        System.out.println((models.Ticket) resultados[1]);
//        cb.consultarSaldo("5478123498761234", "4821");
//        cb.inspeccionarCacheRetirosDiario();
//        Object[] resultados2 = cb.retirar("5478123498761234", 5000, "4821");
//        System.out.println("RETIRO 2 $$$ : " + (double) resultados2[0]);
//        System.out.println((models.Ticket) resultados2[1]);
//        cb.consultarSaldo("5478123498761234", "4821");
//        cb.inspeccionarCacheRetirosDiario();
//        Object[] resultados3 = cb.retirar("5478123498761234", 2000, "4821");
//        System.out.println("RETIRO 3 $$$ : " + (double) resultados3[0]);
//        System.out.println((models.Ticket) resultados3[1]);
//        cb.consultarSaldo("5478123498761234", "4821");
//        cb.inspeccionarCacheRetirosDiario();
//        Object[] resultados4 = cb.retirar("5478123498761234", 100, "4821");
//        System.out.println("RETIRO 4 $$$ : " + (double) resultados4[0]);
//        System.out.println((models.Ticket) resultados4[1]);
//        cb.consultarSaldo("5478123498761234", "4821");
//
        ModuloAtencion moduloAtencion = new ModuloAtencion();
//       moduloAtencion.registrarAbono(6,10000,1);
//       moduloAtencion.mostrarClientes();
        try{
            ReporteMovsDTO reporte = moduloAtencion.generarReporteMovsPorCliente("DIANA NAVARRO DIAZ", "01/01/2016", "01/01/2024");
            System.out.println("[>>>>>>>>REPORTE DE MOVIMIENTOS<<<<<<<<<]");
            System.out.println("TITULAR: "+reporte.getTitular());
            System.out.println("RFC: "+reporte.getRfc());
            for(String key:reporte.getMovsPorCuenta().keySet()){
                System.out.println("\t|-CUENTA: "+key.split(":")[0]);
                System.out.println("\t|-DESCRIPCION: "+key.split(":")[1]);
                System.out.println("\t-----------------------");
                //Imprime ahora los detalles de cada NUM_CUENTA+DESCRIPCION
                for(DetalleMovimientoDTO dto :reporte.getMovsPorCuenta().get(key) ){
                    System.out.println("\t    |-----TIPO: "+dto.getTipo());
                    System.out.println("\t    |-----FECHA: "+dto.getFecha());
                    System.out.println("\t    |-----MONTO: "+dto.getMonto());
                    System.out.println("\t    -----------------------");
                }

            }
            System.out.println("INGRESOS TOTALES :"+reporte.getIngresos());
            System.out.println("EGRESOS TOTALES: "+reporte.getEgresos());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
//        entity.Cliente nuevo=new entity.Cliente("Sara","Torres","Galicia","Direccion de sara","1234567890","IRUHSHDK29K","SR3939304K"
//                ,new Date(1990,8,20),"1","sara@gmail.com");
//
//        moduloAtencion.registrarCliente(nuevo);
    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\Yair\\Downloads\\Telegram Desktop\\photo_2026-05-14_08-21-53.jpg";
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        int anchoFinal = 80;
        int altoFinal = (imagen.getHeight() * 35) / imagen.getWidth();
        String caracteres = "@#S%?*+;:,. ";
        for (int y = 0; y < altoFinal; y++) {
            StringBuilder linea = new StringBuilder();
            for (int x = 0; x < anchoFinal; x++) {
                int pixelX = x * imagen.getWidth() / anchoFinal;
                int pixelY = y * imagen.getHeight() / altoFinal;
                int rgb = imagen.getRGB(pixelX, pixelY);
                int rojo = (rgb >> 16) & 0xff;
                int verde = (rgb >> 8) & 0xff;
                int azul = rgb & 0xff;
                int gris = (rojo + verde + azul) / 3;
                int indice = gris * (caracteres.length() - 1) / 255;
                linea.append(caracteres.charAt(indice));
            }
            System.out.println(linea);
        }
    }
}