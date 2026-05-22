import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

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
        for (CuentaDTO dto : cb.getCacheCuentas()) {
            System.out.println(dto);
        }

        System.out.println(">>>> SALDO INICIAL DE LA CUENTA >>>>> : ");

        cb.consultarSaldo("5578123412340005", "5678");

        //Deposito
        Ticket t1 = pc.depositar("5578123412340005", 3500, "5678");

        System.out.println(">>Deposito : " + t1);

        //Consultar saldo actualizado
        pc.consultarSaldo("5578123412340005", "5678");

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