import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;
import service.impl.CajeroBasico;
import service.impl.ModuloAtencion;
import service.impl.Practicaja;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        models.Atm uno = new models.Atm("av juarez 23", "EG2305");
//
//        uno.consultarSaldo("458712369002","1934");
        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av Hidalgo #45");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av. hidalgo #45");
        pc.setFolio("SO-428");

        //No es posible acceder a un miembro privado aunque haya sido heredado
        //Solo se hereda lo que es publico y protegido, lo privado no se hereda
        //cb.cargarCuentas();
        imprimeLogo();
//      CICLO TEMPORAL SOLO PARA PROBAR EL METODO QUE LEE LAS CUENTAS DESDE LA BASE DE DATOS
//        for (dto.CuentaDTO dto : cb.getCacheCuentas()) {
//            System.out.println(dto);
//        }
//
        // otro ciclo temporal, solo para ver que retiros sin tarjeta existen publicados
        cb.generarRetiroSinTarjeta(); //invoca al metodo que genera los retiros
//        for(String ret : cb.getCacheRst().keySet()){
//            System.out.println(ret + " - "+cb.getCacheRst().get(ret));
//
//        }
//        Scanner scan = new Scanner(System.in);
//        int c = 1;
//        while(c>0) {
//            models.Ticket rstc = pc.cobrarRetiroSinTarjeta();
//            System.out.println(rstc);
//            System.out.println("CONTINUAR??");
//            System.out.println("1-SI, 0 - NO");
//            c = scan.nextInt();
//        }
//        models.Ticket ti = cb.pagarServicio("5578123412340006","IZZI003","IZZI-770002");
//        System.out.println(ti);
         ModuloAtencion ma= new ModuloAtencion();
         //ma.registrarAbono(6,10000,1);
        try{
            ReporteMovsDTO reporte = ma.generarReporteMovsPorCliente("CARLOS RODRIGUEZ SANCHEZ", "01/01/2018", "01/01/2022");
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


        //ma.mostrarClientes();
        //entity.Cliente nuevo = new entity.Cliente("Sara","Torres","Galicia","Direccion de sara","0987654321","IUEREHIU    DFS","SR43876837",
        // new Date(1980,04,12),"1","sara@gmailcrosoft.com");
        //ma.registrarCliente(nuevo);
//        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5578123412340004", "4567");
//        cb.inspeccionarCacheRetirosDiarios();
////
//        Object[] resultados = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((models.Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
////
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
//
//        Object[] resultados4 = cb.retirar("5578123412340004", 100,"4567");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((models.Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//
//        models.Ticket t1 = pc.depositar("5578123412340004", 15000, "4567");
//        System.out.println(">>>>Deposito : " + t1);
//        pc.consultarSaldo("5578123412340004", "4567");
    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\lgsai\\OneDrive\\Desktop\\canvas.png";
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