import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {



//    Atm uno = new Atm("Av Juarez 23", "EGC023");
//    uno.consultarSaldo("5201456789341123","1534");
        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av Hidalgo #45");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av Hidalgo #45");
        pc.setFolio("SO-428");


        //no es posible acceder a un miembro privado aunque haya

        imprimeLogo();

        //ciclo temporal, solo para probar el metodo que lee las cuentas desde la db
//        for(CuentaDTO dto: cb.getCacheCuentas()){
//            System.out.println(dto);
//        }

        //ciclo temporal, solo para ver que retiros sin tarjeta existen publicados
        cb.generarRetirosSinTrajeta(); //invoca el metodo que genera los retiros
        for (String ret :cb.getCacheRst().keySet()){
            System.out.println(ret +" - "+cb.getCacheRst().get(ret));
        }
        Scanner scan = new Scanner(System.in);
        int c=1;
        while (c>0) {
            Ticket rstc = pc.cobrarRetirosSinTarjeta();
            System.out.println(rstc);
            System.out.println("CONTINUAR ??");
            System.out.println("1-Si, 0-No");
            c = scan.nextInt();

        }


//        ModuloAtencion ma = new ModuloAtencion();
//        ma.mostrarClientes();
//
//        Cliente nuevo = new Cliente("Sara","Torres","Galicia","Direccion de Sara","5678987634",
//                "IEUYJHGUTR","SR78987656", new Date(1980,04,12), "1", "sara@gmailcrosoft.com");
//
//        ma.registrarCliente(nuevo);

//        Object[] resultados =  cb.retirar("5201456789341123", 500, "1934");
//        Object[] resultados2 =  cb.retirar("5201456789341123", 700, "1934");


        //tipo especifico  (casteo)--array de algo ---
//        double efectivo = (double) resultados[0];
//        Ticket ticket = (Ticket) resultados[1];

        // casteo = una conversion directa

//EL CASTEO DEL 2DO ELEMENTO TIPO OBJECT SERIA UN ARRAY CON LA INFORMACIÓN DEL TICKET
// YA LLEVA SU ARREGLO CON SUS ATRIBUTOS DEFINIDOS DEBIDO AL METODO TO STRING QUE VIVE DENTRO DE LA CLASE TICKET

//        System.out.println(efectivo);
//        System.out.println(ticket);

//        double efectivo1 = (double) resultados2[0];
//        Ticket ticket1 = (Ticket) resultados2[1];
//
//        System.out.println(efectivo1);
//        System.out.println(ticket1);


//        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5578123412340005","5678");
//
//        Object[] resultados = cb.retirar("5578123412340005", 5000,"5678");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados2 = cb.retirar("5578123412340005", 2800,"5678");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5578123412340005", 2000,"5678");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retirar("5578123412340005", 1000,"5678");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//
//        //Ticket generado por un deposito, debe reflejarse el nuevo saldo de la cuenta
//        Ticket t1 = pc.depositar("5578123412340005", 7000, "5678");
//        System.out.println(">>>Deposito :"+t1);
//
//        pc.consultarSaldo("5578123412340005", "5678");

    }
        static void imprimeLogo() throws Exception{
            String rutaImagen = "C:\\Users\\ENRIQUE BORJA\\Desktop\\logo.jpg";
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