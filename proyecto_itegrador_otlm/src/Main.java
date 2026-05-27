import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;
import service.impl.CajeroBasico;
import service.impl.ModuloAtencion;
import service.impl.PractiCaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        imprimeLogo();
        Scanner scan = new Scanner(System.in);

        //models.Atm uno = new models.Atm("Calle Ecatepec 15","HYTR048");

        //uno.consultarSaldo("4489761234509876","4472");

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Calle 1, numero 1");
        cb.setFolio("AA-00");

        PractiCaja pc = new PractiCaja();
        pc.setDireccion("Calle 2, num2");
        pc.setFolio("AA-01");

        //Ciclo temporal solo para probar el metodo que lee las cuentas desde la base datos
//        for(dto.CuentaDTO dto : cb.getCacheCuentas()){
//            System.out.println(dto);
//        }
//
         //ciclo temporal solo para ver que retiros sin tarjte existen publicados
//        cb.generarRetirosSinTarjeta();
//        for(String ret:cb.getCacheRst().keySet()){
//            System.out.println(ret+" - "+cb.getCacheRst().get(ret));//Modificar esto despues
//        }

//        int c = 1;
//        while(c>0){
//            models.Ticket rstc = pc.cobrarRetiroSinTarjeta();
//            System.out.println(rstc);
//            System.out.println("CONTINUAR ??");
//            System.out.println("1-Si, 0-No");
//            c = scan.nextInt();
//        }


//        models.Ticket ti = cb.pagarServicio("5578123412340003","TMX002","TMX-5512340001");
//        System.out.println(ti);



        ModuloAtencion ma = new ModuloAtencion();
//        ma.registrarAbono(6,10000, 1);

        try{
            ReporteMovsDTO reporte = ma.generarReporteMovsPorCliente("CARLOS RODRIGUEZ SANCHEZ", "01/01/2016", "01/01/2024");
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


//        ma.mostrarClientes();
//
//        entity.Cliente nuevo = new entity.Cliente("Sara", "Torres", "Galicia", "Direccion de Sara", "222145789", "LIJLJNLKJHKJB",
//                "SR1425367B6", new Date(1980,04,12),"1", "sara@gmail.com");
//        ma.registrarCliente(nuevo);

//        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5578123412340004","4567");
//
//        Object[] resultados = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((models.Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados2 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((models.Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((models.Ticket) resultados3[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((models.Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();

//        cb.consultarSaldo("5478123498761234","4821");
//
//        Object[] resultados = cb.retirar("5478123498761234",5000, "4821");
//        models.Ticket ticket = (models.Ticket) resultados[1];
//        System.out.println("RETIRO 1 : "+(double) resultados[0]);
//        cb.consultarSaldo("5478123498761234","4821");
//
//        Object[] resultados2 = cb.retirar("5478123498761234",5000, "4821");
//        Object[] resultados3 = cb.retirar("5478123498761234",2000, "4821");
//        Object[] resultados4 = cb.retirar("5478123498761234",100, "4821");
//
//
//
//        //El casteo lo convierte a un tipo especifico, en este caso double y ticket
//        double efectivo = (double) resultados[0];
//        models.Ticket ticket2 = (models.Ticket) resultados2[1];
//        models.Ticket ticket3 = (models.Ticket) resultados3[1];
//        models.Ticket ticket4 = (models.Ticket) resultados4[1];
//
//
//        System.out.println(efectivo);
//        System.out.println(ticket);
//        System.out.println(ticket2);
//        System.out.println(ticket3);
//        System.out.println(ticket4);
//
//        cb.consultarSaldo("5478123498761234","4821");

        //No es posible acceder a un miembro privado, aunque haya sido heredadp
        //Solo se hereda lo que es publico y privado, lo privado no se hereda
        //cb.cargarCuentas();

        //ticket generado por un deposito desde la practicaja
//        models.Ticket t1 = pc.depositar("5578123412340004",100,"4567");
//        System.out.println(">>>Deposito : "+t1);
        //Despues del desposito, debe reflejarse el nuevo saldo en la cuenta
//        pc.consultarSaldo("5578123412340004","4567");

    }

    static void imprimeLogo() throws Exception{
        String rutaImagen = "C:\\Users\\VIOM2\\Desktop\\photo_bbva.jpg";
        BufferedImage imagen = ImageIO.read(new File(rutaImagen));
        int anchoFinal = 80;
        int altoFinal = (imagen.getHeight() * 35) / imagen.getWidth();
        String caracteres = "@%#*+=-:. ";
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