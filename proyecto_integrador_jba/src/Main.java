import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

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

        Object[] resultados =  cb.retirar("5201456789341123", 500, "1934");
        Object[] resultados2 =  cb.retirar("5201456789341123", 700, "1934");


        //tipo especifico  (casteo)--array de algo ---
        double efectivo = (double) resultados[0];
        Ticket ticket = (Ticket) resultados[1];

        // casteo = una conversion directa

//EL CASTEO DEL 2DO ELEMENTO TIPO OBJECT SERIA UN ARRAY CON LA INFORMACIÓN DEL TICKET
// YA LLEVA SU ARREGLO CON SUS ATRIBUTOS DEFINIDOS DEBIDO AL METODO TO STRING QUE VIVE DENTRO DE LA CLASE TICKET

        System.out.println(efectivo);
        System.out.println(ticket);

        double efectivo1 = (double) resultados2[0];
        Ticket ticket1 = (Ticket) resultados2[1];

        System.out.println(efectivo1);
        System.out.println(ticket1);

        //Ticket generado por un deposito, debe reflejarse el nuevo saldo de la cuenta
        Ticket t1 = pc.depositar("4532987612457789", 3500, "7750");
        System.out.println(">>>Deposito :"+t1);

        pc.consultarSaldo("4532987612457789", "7750");

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