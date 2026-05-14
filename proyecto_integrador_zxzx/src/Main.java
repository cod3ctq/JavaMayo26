import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {

       //Atm uno = new Atm("Av Juarez 23","EGC023");
        //uno.consultarSaldo("4912783456129087","2658");

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av Hidalgo #45");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av Hidalgo #45");
        pc.setFolio("SO-428");

        //No es posible acceder a un miembro privado aunque haya sido heredado
        //Solo se hereda lo que es publico y protected, lo privado NO se hereda
        //cb.cargarCuentas();

        imprimeLogo();

        System.out.println(cb.retirar("5478123498761234", 500,"4821"));

        Object[] resultados = cb.retirar("5478123498761234", 500,"4821");
        Object[] resultados2 = cb.retirar("5478123498761234", 700,"4821");

        //  tipoespecifico  (casteo)--array de algo ---
        double efectivo = (double) resultados[0];
        Ticket ticket =  (Ticket) resultados[1];

        double efectivo2 = (double) resultados2[0];
        Ticket ticket2 =  (Ticket) resultados2[1];
        System.out.println(efectivo);
        System.out.println(ticket);

        System.out.println(efectivo2);
        System.out.println(ticket2);

        //ticket generado por un deposito desde la practicaja
        Ticket t1 = pc.depositar("5201456789341123",3500,"1934");
        System.out.println(">>>Deposito : "+t1);

        //Despues del deposito, debe reflejarse el nuevo saldo en la cuenta
        pc.consultarSaldo("5201456789341123","1934");
    }

    static void imprimeLogo() throws Exception{
        String rutaImagen = "C:\\Users\\César\\Desktop\\wecwd.PNG";
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