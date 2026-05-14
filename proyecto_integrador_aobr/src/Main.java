import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

//        Atm uno = new Atm("Av Juarez 23", "EGC023");
//
//        uno.consultarSaldo("4912783456129087","2668");

        imprimeLogo();

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av sadjasd 12");
        cb.setFolio("31231");


        Practicaja pc =new Practicaja();
        pc.setDireccion("Av sadjasd 12");
        pc.setFolio("23819");

        System.out.println(cb.retirar("5478123498761234",500,"4821"));


        Object [] resultados = cb.retirar("5478123498761234",500,"4821");
        Object [] resultados2 = cb.retirar("5478123498761234",700,"4821");

        //  double      (casteo) --array de algo ----
        double efectivo = (double)resultados[0];

        Ticket ticket = (Ticket) resultados[1];

        double efectivo2 = (double)resultados2[0];

        Ticket ticket2 = (Ticket) resultados2[1];


        System.out.println(efectivo);
        System.out.println(ticket);
        System.out.println(efectivo2);
        System.out.println(ticket2);



        //DEPOSITO
        //ticket generado por un deposito desde la practicaja
        Ticket t1= pc.depositar("5201456789341123",3500,"1934");
        System.out.println(">>>>Deposito: " +t1);

        //despues del deposito, debe reflejasrse el nuevo saldo en la cuenta
        pc.consultarSaldo("5201456789341123","1934");
    }

    static void imprimeLogo() throws Exception{
        String rutaImagen = "C:\\Users\\osval\\Downloads\\wecwd.jpg";
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