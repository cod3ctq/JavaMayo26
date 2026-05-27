import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;
import service.impl.CajeroBasico;
import service.impl.ModuloAtencion;
import service.impl.PractiCaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

//        models.Atm uno = new models.Atm("Av juarez 23", "EGC023");
//        uno.consultarSaldo("5478123498761234","4821");

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("AV HIDALOG");
        cb.setFolio("KS-344");

        PractiCaja pc = new PractiCaja();
        pc.setDireccion("AV HIDALGO");
        pc.setFolio("SO-428");


        //No es posible acceder a un miembro privado aunque haya sido heredado
        //solo se hereda lo que es publico y protected, lo privado no se hereda
        //cb.cargarCuentas();

        imprimeLogo();

//       // ciclo  temporal solo para probar el metodo que lee las cuentas desde la base de datos
//        for (dto.CuentaDTO dto : cb.getCacheCuentas()){
//            System.out.println(dto);
//        }

     //ciclo temporal para ver que retiros sin tarjeta existen duplicados
        cb.generarRetirosSinTarjeta();//invoca al metodo que genera los retiros
//        for (String ret : cb.getCacheRst().keySet()){
//            System.out.println(ret + " - " + cb.getCacheRst().get(ret));
//        }
//        Scanner scan = new Scanner(System.in);
//        int c = 1;
//        while (c>0){
//            models.Ticket rstc = pc.cobrarRetiroSinTarjeta();
//            System.out.println(rstc);
//            System.out.println("CONTINUAR ??");
//            System.out.println(" 1-Si, 0-N0");
//            c = scan.nextInt();
//        }

//        models.Ticket ti = cb.pagarServicio("5578123412340003","IZZI003","IZZI-770002");
//        System.out.println(ti);



        ModuloAtencion ma = new ModuloAtencion();
//        ma.registrarAbono(6,10000,1);
        try{
            ReporteMovsDTO reporte = ma.generarReporteMovsPorCliente("ESTEBAN MARIN RUIZ", "01/01/2018", "01/01/2022");
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
//        entity.Cliente nuevo = new entity.Cliente("sara", "torres", "Galicia", "Direccion de Sara","0494949",
//                "IOEIKFF","FSDFSEF", new Date(1980,04,12),"1","sara@gmail.com");
//
//        ma.registrarCliente(nuevo);


//
//       System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//       cb.consultarSaldo("5578123412340004","4567");
//
//        Object[] resultados = cb.retiro("5578123412340004", 5000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((models.Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados2 = cb.retiro("5578123412340004", 2800,"4567");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((models.Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//
//        Object[] resultados3 = cb.retiro("5578123412340004", 4000,"4567");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((models.Ticket) resultados3[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retiro("V", 100,"4567");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((models.Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//
//        models.Ticket t1 = pc.depositar("5578123412340004",15000,"4567");
//        System.out.println("---Deposito : "+t1);
//        pc.consultarSaldo("5578123412340004","4567");
//
//
    }
    static void imprimeLogo() throws Exception{
        String rutaImagen = "C:\\Users\\RENE PC\\Desktop\\4913963235904523300.jpg";
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