import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        //Atm uno = new Atm("Av Juarez 23","EGC023");
        //uno.consultarSaldo("4912783456129087","2658");

        CajeroBasico cb = new CajeroBasico();
        cb.setDireccion("Av Hidalgo #45");
        cb.setFolio("KS-23");

        Practicaja pc = new Practicaja();
        pc.setDireccion("Boulevard 22 Sur #5111");
        pc.setFolio("SO-428");

        Scanner scan = new Scanner(System.in);
        String numTarjeta, nip;
        imprimeLogo();

        /*
        int opcion = 0;
        int seleccion = 0;
        double monto = 0.0;
        String ref, clave, datos;
        while (opcion < 2) {
            System.out.println("1 - Retirar, Depositar o Pago de Servicios");
            System.out.println("2 - Retiro Sin tarjeta");
            System.out.println("3 - Cerrar Sesion");
            System.out.println("SELECCIONA UNA OPCION:");
            opcion = scan.nextInt();
            scan.nextLine();
            switch (opcion) {

                case 1:
                    System.out.println("INGRESA EL NUMERO DE TARJETA :");
                    numTarjeta = scan.nextLine();
                    System.out.println("INGRESA TU NIP :");
                    nip = scan.nextLine();

                    try {
                        CuentaDTO dto = Atm.buscarCuenta(numTarjeta, nip);

                        System.out.println("HOLA " + dto.getTitular() + ", QUÉ DESEAS HACER HOY ?");
                        System.out.println("1 - RETIRAR");
                        System.out.println("2 - DEPOSITAR");
                        System.out.println("3 - PAGAR SERVICIOS");
                        seleccion = scan.nextInt();
                        scan.nextLine();

                        switch (seleccion) {

                            case 1:
                                System.out.println("CAPTURA EL MONTO A RETIRAR :");
                                monto = scan.nextDouble();
                                System.out.println("---------------------------------------");
                                Object[] resultados = cb.retirar(numTarjeta, monto, nip);
                                System.out.println("EFECTIVO>>>> : " + (double) resultados[0]);
                                System.out.println((Ticket) resultados[1]);
                                //cb.consultarSaldo(numTarjeta, nip);
                                //cb.inspeccionarCacheRetirosDiarios();
                                monto =0.0;
                                break;
                            case 2:
                                System.out.println("CAPTURA EL MONTO A DEPOSITAR :");
                                monto = scan.nextDouble();
                                Ticket ticket = pc.depositar(numTarjeta, monto, nip); //Al depositar, no se pide nip, modificar eso
                                System.out.println("DEPOSITO>>>> : " + ticket);
                                monto =0.0;
                                break;
                            case 3:
                                System.out.println("CODIGO PENDIENTE PARA EL PAGO DE SERVICIOS ....");
                                break;

                            default:
                                System.out.println("OPCION NO VÁLIDA !");

                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("CAPTURA LA REFERENCIA");
                    ref = scan.nextLine();
                    System.out.println("CAPTURA LA CLAVE");
                    clave = scan.nextLine();

                    break;

            }


        }

         */

        //ciclo temporal, solo para ver que retiros sin tarjeta existen publicados
        cb.generarRetiroSinTarjeta(); //invoca al metodo que genera los retiros
        for (String ret :cb.getCacheRst().keySet()){
            System.out.println(ret +" - "+cb.getCacheRst().get(ret));
        }

        //Scanner scan = new Scanner(System.in);
        int c = 1;
        while(c>0){
            Ticket rstc = pc.cobrarRetiroSinTarjeta();
            System.out.println(rstc);
            System.out.println("CONTINUAR ??");
            System.out.println("1-Si, 0-No");
            c = scan.nextInt();
        }

        //ModuloAtencion ma = new ModuloAtencion();
        //ma.mostrarClientes();

        //Cliente nuevo = new Cliente("Sara","Torres","Galicia","Direccion de Sara", "0987654321","IUREHIUDFS", "SR43876837",new Date(1980,04,12),"1","sara@gmailcrosoft.com");

        //ma.registrarCliente(nuevo);

//        System.out.println(">>>>> SALDO INICIAL DE LA CUENTA >>>>> : ");
//        cb.consultarSaldo("5578123412340005","5678");
//
//        Object[] resultados = cb.retirar("5578123412340005", 1000,"5678");
//        System.out.println("RETIRO 1 $$$ : "+(double) resultados[0]);
//        System.out.println((Ticket) resultados[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//        Object[] resultados2 = cb.retirar("5578123412340005", 1000,"5678");
//        System.out.println("RETIRO 2 $$$ : "+(double) resultados2[0]);
//        System.out.println((Ticket) resultados2[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//        Object[] resultados3 = cb.retirar("5578123412340005", 1000,"5678");
//        System.out.println("RETIRO 3 $$$ : "+(double) resultados3[0]);
//        System.out.println((Ticket) resultados3[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//        cb.inspeccionarCacheRetirosDiarios();
//        Object[] resultados4 = cb.retirar("5578123412340005", 1000,"5678");
//        System.out.println("RETIRO 4 $$$ : "+(double) resultados4[0]);
//        System.out.println((Ticket) resultados4[1]);
//        cb.consultarSaldo("5578123412340005","5678");
//
//        Ticket t1 = pc.depositar("5578123412340005",7000,"5678");
//        System.out.println(">>>Deposito : "+t1);
//
//        //Despues del deposito, debe reflejarse el nuevo saldo en la cuenta
//        pc.consultarSaldo("5578123412340005","5678");
    }

    static void imprimeLogo() throws Exception {
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