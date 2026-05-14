import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        imprimirLogo();

        //Atm uno = new Atm("Av Juarez 23", "EGC023");
        //uno.consultarSaldo("4912783456129087", "2608");

        CajeroBasico cb1 = new CajeroBasico(); // Creamos Objeto de tipo CajeroBasico
        cb1.setDireccion("Av Juarez 23"); // Le asignamos dirección a esa practicaja
        cb1.setFolio("CAJ-23"); // Le asignamos folio a esa practicaja
        System.out.println(cb1.retirar("5478123498761234", 500, "4821")); // Va a imprimir la dirección en memoria
        Object[] resultados = cb1.retirar("5478123498761234", 500, "4821"); // Metodo retirar() devuelve array de Object
        // Hacemos un casteo / conversión directa de un tipo genérico a un tipo específico
        double efectivo = (double) resultados[0]; // De la posición 0 del array convertimos a double y lo guardamos en una variable
        Ticket ticket = (Ticket) resultados[1]; // De la posición 0 del array convertimos a double y lo guardamos en una variable
        System.out.println(efectivo); // Imprimimos el monto que se retiró
        System.out.println(ticket.toString()); // Imprimimos el ticket del retiro

        Practicaja pc1 = new Practicaja(); // Creamos Objeto de tipo Practicaja
        pc1.setDireccion("Av Juarez 23"); // Le asignamos dirección a esa practicaja
        pc1.setFolio("PC-45"); // Le asignamos folio a esa practicaja
        Ticket ticket1 = pc1.depositar("5201456789341123", 3500, "1934"); // Hacemos depósito con el número de tarjeta y nip
        System.out.println("\n>>>Deposito: " + ticket1); // Imprimimos el ticket del depósito
        pc1.consultarSaldo("5201456789341123", "1934"); // Llamamos al metodo consultarSaldo() y este va a imprimir el saldo
    }

    static void imprimirLogo() throws Exception {
        String rutaImagen = "C:\\Users\\carlo\\Downloads\\4913963235904523300.jpg";
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