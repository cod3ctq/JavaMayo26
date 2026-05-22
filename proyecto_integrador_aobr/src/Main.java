import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{

//        Atm uno = new Atm("Av Juarez 23", "EGC023");
//
//        uno.consultarSaldo("4912783456129087","2668");



        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av sadjasd 12");
        cb.setFolio("31231");


        Practicaja pc =new Practicaja();
        pc.setDireccion("Av sadjasd 12");
        pc.setFolio("23819");

        imprimeLogo();


        //ciclo temporal, solo para probar el metodo que lee las cuentas desde la base de datos
        for (CuentaDTO dto:cb.getCacheCuentas()){
            System.out.println(dto);

        }




        //ModuloAtencion ma = new ModuloAtencion();
//        ma.mostrarClientes();
//
//        Cliente nuevo = new Cliente("Sara","Torres","Galicia","Direccion de Sara","0987654321","IUREHIDF21","SR32JDIAS921",new Date(1980,04,12),"1","sara@gmailcrosoft.com");
//        ma.registrarCliente(nuevo);


        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
        cb.consultarSaldo("5578123412340004","4567");
//
//        Object[] resultados = cb.retirar("5578123412340004", 5000,"4567");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
////
//        Object[] resultados2 = cb.retirar("5578123412340004", 2800,"4567");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340004","4567");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb.retirar("5478123498761234", 2000,"4821");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5478123498761234","4821");
//        cb.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb.retirar("5478123498761234", 100,"4821");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb.consultarSaldo("5478123498761234","4821");





          Ticket t1= pc.depositar("5578123412340004",15000,"4567");
          System.out.println(">>>>Deposito: " +t1);

        //despues del deposito, debe reflejasrse el nuevo saldo en la cuenta
        pc.consultarSaldo("5578123412340004","4567");

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