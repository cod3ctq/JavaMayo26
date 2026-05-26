import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

    // ATM uno = new ATM("Av Juarez 23", "EGC023");

    // uno.consultarSaldo("4912783456129087","2658");

        CajeroBasico cb = new CajeroBasico();
        cb.setDirecciones("Av Hidalgo #45");
        cb.setFolio("ks-23");

        Practicaja pc = new Practicaja();
        pc.setDirecciones("Av Hidalgo #45");
        pc.setFolio("so-428");


        //No es posible acceder a un miembro privado aunque haya sido heredado.
        //Solo se hereda lo que es publico y protegido, lo privado no se hereda.
        //cb.cargarCuentas();


        imprimeLogo();


        //ciclo temporal, solo para probar la base de datos
//        for (CuentaDTO dto : cb.getCacheCuentas()){
//            System.out.println(dto);
//        }


        //Ciclo temporal, solo para que retiros sin tarjeta existen publicados
        cb.generarRetirosSinTarjeta(); //Invoca al metodo que genera los retiros
        for (String ret: cb.getCacheRST().keySet()){
            System.out.println(ret +" - "+ cb.getCacheRST().get(ret));

        }

        Scanner scan = new Scanner(System.in);
        int c =1;
        while (c>0){
            Ticket rstc = pc.cobrarRetiroSinTarjeta();
            System.out.println(rstc);
            System.out.println("CONTINUAR ??");
            System.out.println("1-Si, 0-No");
            c = scan.nextInt();
        }




        //ModuloAtencion ma = new ModuloAtencion();
        //ma.mostarClients();



        //Cliente nuevo = new Cliente("Sara","Torres","Galicia","Direccion de Sara","0987654321",
               // "IUREHIUDFS","SR43876837",new Date(1980, 04, 12),"1","sara@gmailcrosoft.com");

        //ma.registrarCliente(nuevo);



//        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5578123412340004","4567");
//
//       Object[] resultados = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//       cb.consultarSaldo("5578123412340004","4567");
//       cb.inspeccionarCacheRetirosDiarios();
//
//
//        Object[] resultados2 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retirar("5578123412340004", 1000,"4567");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//
//
//
//
//
//
//        Ticket t1 = pc.depositar("5578123412340004", 7000, "4567");
//        System.out.println(">>>Deposito : "+t1);
//
//        //Despues del deposito, debe reflejarse el nuevo saldo en la cuenta
//        pc.consultarSaldo("5578123412340004","4567");






    }
    static void imprimeLogo() throws Exception{
        String rutaImagen = "C:\\Users\\alber\\Desktop\\BBVA.jpg";
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
