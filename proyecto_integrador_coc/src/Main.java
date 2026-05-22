import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        imprimirLogo();

        // CAJERO BÁSICO
        CajeroBasico cb1 = new CajeroBasico(); // Creamos Objeto de tipo CajeroBasico
        cb1.setDireccion("Av Juarez 23"); // Le asignamos dirección a este cajero
        cb1.setFolio("CAJ-23"); // Le asignamos folio a este cajero

        System.out.println("*** SALDO INICIAL DE LA CUENTA ***");
        cb1.consultarSaldo("5578123412340004","4567"); // Imprimimos el saldo inicial de la cuenta

//        Object[] resultados = cb1.retirar("5578123412340004", 5000,"4567"); // Retiro 1
//        // Hacemos un casteo: conversión directa de un tipo genérico a un tipo específico
//        System.out.println("\nRETIRO 1: $" + (double) resultados[0]); // De la posición 0 del array convertimos a double con un casteo y lo imprimimos
//        System.out.println((Ticket) resultados[1]); // De la posición 1 del array convertimos a Objeto tipo Ticket con un casteo y lo imprimimos
//        cb1.consultarSaldo("5578123412340004","4567"); // Llamamos al metodo consultarSaldo()
//        cb1.inspeccionarCacheRetirosDiarios(); // Llamamos a este metodo para ver el acumulado de retiros que se van haciendo
//
//        Object[] resultados2 = cb1.retirar("5578123412340004", 2800,"4567"); // Retiro 2
//        System.out.println("\nRETIRO 2: $" + (double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb1.consultarSaldo("5578123412340004","4567");
//        cb1.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb1.retirar("5478123498761234", 2000,"4821"); // Retiro 3
//        System.out.println("\nRETIRO 3: $" + (double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb1.consultarSaldo("5478123498761234","4821");
//        cb1.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb1.retirar("5478123498761234", 100,"4821"); // Retiro 4
//        System.out.println("\nRETIRO 4: $" + (double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb1.consultarSaldo("5478123498761234","4821");
//        cb1.inspeccionarCacheRetirosDiarios();

        // PRACTICAJA
        Practicaja pc1 = new Practicaja(); // Creamos Objeto de tipo Practicaja
        pc1.setDireccion("Av Juarez 23"); // Le asignamos dirección a esa practicaja
        pc1.setFolio("PC-45"); // Le asignamos folio a esa practicaja
        Ticket ticket1 = pc1.depositar("5578123412340004", 15000, "4567"); // Hacemos depósito con el número de tarjeta y nip
        System.out.println("\n>>>Deposito: " + ticket1); // Imprimimos el ticket del depósito
        pc1.consultarSaldo("5578123412340004", "4567"); // Llamamos al metodo consultarSaldo() y este va a imprimir el saldo

//        ModuloAtencion ma = new ModuloAtencion();
//        ma.mostrarClientes();
//        Cliente cliente1 = new Cliente("Sara", "Torres", "Galicia", "Dirección Sara", "1234567890", "123456789123456789",
//                "123456789", new Date(1980, 04, 12), "1", "sara@gmail.com");
//        ma.registrarCliente(cliente1);

//        for (CuentaDTO dto : cb1.getCacheCuentas()) { // Verificar que el Metodo leerCuentas() funciona
//            System.out.println(dto);
//        }
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