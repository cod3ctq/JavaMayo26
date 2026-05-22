import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
//        Atm uno = new Atm("av juarez 23", "EG2305");
//
//        uno.consultarSaldo("458712369002","1934");
        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av Hidalgo #45");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Av. hidalgo #45");
        pc.setFolio("SO-428");

        //No es posible acceder a un miembro privado aunque haya sido heredado
        //Solo se hereda lo que es publico y protegido, lo privado no se hereda
        //cb.cargarCuentas();
        imprimeLogo();
//CICLO TEMPORAL SOLO PARA PROBAR EL METODO QUE LEE LAS CUENTAS DESDE LA BASE DE DATOS
        for (CuentaDTO dto : cb.getCacheCuentas()) {
            System.out.println(dto);
        }
        // ModuloAtencion ma= new ModuloAtencion();
        //ma.mostrarClientes();
        //Cliente nuevo = new Cliente("Sara","Torres","Galicia","Direccion de sara","0987654321","IUEREHIU    DFS","SR43876837",
        // new Date(1980,04,12),"1","sara@gmailcrosoft.com");
        //ma.registrarCliente(nuevo);
        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
        cb.consultarSaldo("5578123412340004", "4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados = cb.retirar("5578123412340004", 5000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
////
//        Object[] resultados2 = cb.retirar("5578123412340004", 5000,"4567");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5478123498761234", 2000,"4821");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5478123498761234","4821");
//
//        Object[] resultados4 = cb.retirar("5478123498761234", 100,"4821");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb.consultarSaldo("5478123498761234","4821");

        Ticket t1 = pc.depositar("5578123412340004", 15000, "4567");
        System.out.println(">>>>Deposito : " + t1);
        pc.consultarSaldo("5578123412340004", "4567");
    }

    static void imprimeLogo() throws Exception {
        String rutaImagen = "C:\\Users\\lgsai\\OneDrive\\Desktop\\canvas.png";
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