import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av hidalgo");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av hidalgo 121");
        pc.setFolio("JSJDO");

        imprimeLogo();

        //Mostrar cuentas cargadas desde DB
//        for (CuentaDTO dto : cb.getCacheCuentas()) {
//            System.out.println(dto);
//        }

        //Ciclo temporal, solo para ver que retiros sin tarjeta existen publicados
        cb.generarRetiroSinTarjeta(); //Invoca al metodo que genera los retiros
        for (String ret : cb.getCacheRst().keySet()) {
            System.out. println(ret + " - " + cb.getCacheRst().get(ret));
        }
        Scanner scan = new Scanner(System.in);
        int c = 1;
        while(c>0){
            Ticket rstc = pc.cobrarRetiroSinTarjeta();
            System.out.println(rstc);
            System.out.println("CONTINUAR ??");
            System.out.println("1-Si, 0-No");
            c = scan.nextInt();
        }


//        System.out.println(">>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//
//        cb.consultarSaldo("5578123412340005", "5678");
//
//        Object[] resultados = cb.retirar("5578123412340005", 5000, "5678");
//        System.out.println("RETIRO 1 $$$ : " + (double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340005", "5678");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados2 = cb.retirar("5578123412340005", 2800, "5678");
//        System.out.println("RETIRO 2 $$$ : " + (double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340005", "5678");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5578123412340005", 2000, "5678");
//        System.out.println("RETIRO 3 $$$ : " + (double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5478123498761234", "4821");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retirar("5578123412340005", 100, "5678");
//        System.out.println("RETIRO 4 $$$ : " + (double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//
//        //Deposito
//        Ticket t1 = pc.depositar("5578123412340005", 3500, "5678");
//
//        System.out.println(">>Deposito : " + t1);
//
//        //Consultar saldo actualizado
//        pc.consultarSaldo("5578123412340005", "5678");

    }

    static void imprimeLogo() throws Exception {

        String rutaImagen = "C:\\Users\\cemil\\Desktop\\BBVA.jpeg";

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