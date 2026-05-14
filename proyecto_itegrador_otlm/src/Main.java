import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        imprimeLogo();
        //Atm uno = new Atm("Calle Ecatepec 15","HYTR048");

        //uno.consultarSaldo("4489761234509876","4472");

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Calle 1, numero 1");
        cb.setFolio("AA-00");

        PractiCaja pc = new PractiCaja();
        pc.setDireccion("Calle 2, num2");
        pc.setFolio("AA-01");

        Object[] resultados = cb.retirar("5478123498761234",500, "4821");

        //El casteo lo convierte a un tipo especifico, en este caso double y ticket
        double efectivo = (double) resultados[0];
        Ticket ticket = (Ticket) resultados[1];

        System.out.println(efectivo);
        System.out.println(ticket);

        //No es posible acceder a un miembro privado, aunque haya sido heredadp
        //Solo se hereda lo que es publico y privado, lo privado no se hereda
        //cb.cargarCuentas();

        //ticket generado por un deposito desde la practicaja
        Ticket t1 = pc.depositar("5201456789341123",3500,"1934");
        System.out.println(">>>Dposito : "+t1);
        //Despues del desposito, debe reflejarse el nuevo saldo en la cuenta
        pc.consultarSaldo("5201456789341123","1934");

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