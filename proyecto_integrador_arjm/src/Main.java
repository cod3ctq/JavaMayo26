import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {

//        Atm uno = new Atm("Av juarez 23", "EGC023");
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
        //cb.retiro("5478123498761234",500.00,"4821");



        Object[] resultados = cb.retiro("5478123498761234",500.00,"4821");
        Object[] resultados2 = cb.retiro("5478123498761234",700.00,"4821");
        Object[] resultados3 = cb.retiro("5478123498761234",800.00,"4821");

        //  tipoespecifico (casteo)-array de algo--
        double efectivo = (double) resultados[0];
        Ticket ticket = (Ticket) resultados[1];

        double efectivo2 = (double) resultados2[0];
        Ticket ticket2 = (Ticket) resultados2[1];

        double efectivo3 = (double) resultados3[0];
        Ticket ticket3 = (Ticket) resultados3[1];

        System.out.println(efectivo);
        System.out.println(ticket);

        System.out.println(efectivo2);
        System.out.println(ticket2);

        System.out.println(efectivo3);
        System.out.println(ticket3);




        //ticket generando por un deposito desde la practicaja
        Ticket t1 = pc.depositar("5201456789341123",3500,"1934");
        System.out.println("deposito" + t1);

        //despues del deposito, debe reflejarse el nuevo saldo en la cuenta

        pc.consultarSaldo("5201456789341123","1934");





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