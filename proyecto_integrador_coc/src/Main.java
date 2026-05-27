import dto.DetalleMovimientoDTO;
import dto.ReporteMovsDTO;
import service.impl.CajeroBasico;
import service.impl.ModuloAtencion;
import service.impl.Practicaja;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
//        imprimirLogo();

//        // CAJERO BÁSICO - Retiros
        CajeroBasico cb1 = new CajeroBasico(); // Creamos Objeto de tipo service.impl.CajeroBasico
        cb1.setDireccion("Av Juarez 23"); // Le asignamos dirección a este cajero
        cb1.setFolio("CAJ-23"); // Le asignamos folio a este cajero
//
//        System.out.println("*** SALDO INICIAL DE LA CUENTA ***");
//        cb1.consultarSaldo("5578123412340004","4567"); // Imprimimos el saldo inicial de la cuenta
//
//        Object[] resultados = cb1.retirar("5578123412340004", 1000,"4567"); // Retiro 1
//        // Hacemos un casteo: conversión directa de un tipo genérico a un tipo específico
//        System.out.println("\nRETIRO 1: $" + (double) resultados[0]); // De la posición 0 del array convertimos a double con un casteo y lo imprimimos
//        System.out.println((models.Ticket) resultados[1]); // De la posición 1 del array convertimos a Objeto tipo models.Ticket con un casteo y lo imprimimos
//        cb1.consultarSaldo("5578123412340004","4567"); // Llamamos al metodo consultarSaldo()
//        cb1.inspeccionarCacheRetirosDiarios(); // Llamamos a este metodo para ver el acumulado de retiros que se van haciendo
//
//        Object[] resultados2 = cb1.retirar("5578123412340004", 1000,"4567"); // Retiro 2
//        System.out.println("\nRETIRO 2: $" + (double) resultados2[0]);
//        System.out.println((models.Ticket) resultados2[1]);
//        cb1.consultarSaldo("5578123412340004","4567");
//        cb1.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados3 = cb1.retirar("5578123412340004", 1000,"4567"); // Retiro 3
//        System.out.println("\nRETIRO 3: $" + (double) resultados3[0]);
//        System.out.println((models.Ticket) resultados3[1]);
//        cb1.consultarSaldo("5578123412340004","4567");
//        cb1.inspeccionarCacheRetirosDiarios();
//
//        Object[] resultados4 = cb1.retirar("5578123412340004", 1000,"4567"); // Retiro 4
//        System.out.println("\nRETIRO 4: $" + (double) resultados4[0]);
//        System.out.println((models.Ticket) resultados4[1]);
//        cb1.consultarSaldo("5578123412340004","4567");
//        cb1.inspeccionarCacheRetirosDiarios();
//
//        // PRACTICAJA - Depósitos
        Practicaja pc1 = new Practicaja(); // Creamos Objeto de tipo service.impl.Practicaja
        pc1.setDireccion("Av Juarez 23"); // Le asignamos dirección a esa practicaja
        pc1.setFolio("PC-45"); // Le asignamos folio a esa practicaja
//        models.Ticket ticket1 = pc1.depositar("5578123412340004", 7000, "4567"); // Hacemos depósito con el número de tarjeta y nip
//        System.out.println("\n>>>Deposito: " + ticket1); // Imprimimos el ticket del depósito
//        pc1.consultarSaldo("5578123412340004", "4567"); // Llamamos al metodo consultarSaldo() y este va a imprimir el saldo

        ModuloAtencion ma = new ModuloAtencion();
//        models.Ticket ticket = ma.registrarAbono(6, 10000, 1);
//        System.out.println(ticket);

        try{
            ReporteMovsDTO reporte = ma.generarReporteMovsPorCliente("CARLOS RODRIGUEZ SANCHEZ", "01/01/2016", "01/01/2025");
            System.out.println("[>>>>>>>>>REPORTE DE MOVIMIENTOS<<<<<<<<<]");
            System.out.println("TITULAR: " + reporte.getTitular());
            System.out.println("RFC: " + reporte.getRfc());
            for(String key:reporte.getMovsPorCuenta().keySet()){
                System.out.println("\t|-CUENTA: " + key.split(":")[0]);
                System.out.println("\t|-DESCRIPCION: " + key.split(":")[1]);
                System.out.println("\t-----------------------");
                // Imprime ahora los detalles de cada NUM_CUENTA + DESCRIPCION
                for(DetalleMovimientoDTO dto :reporte.getMovsPorCuenta().get(key) ){
                    System.out.println("\t    |-----TIPO: " + dto.getTipo());
                    System.out.println("\t    |-----FECHA: " + dto.getFecha());
                    System.out.println("\t    |-----MONTO: $" + dto.getMonto());
                    System.out.println("\t    -----------------------");
                }
            }
            System.out.println("INGRESOS TOTALES: $" + reporte.getIngresos());
            System.out.println("EGRESOS TOTALES: $" + reporte.getEgresos());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

//        ma.mostrarClientes();
//        entity.Cliente cliente1 = new entity.Cliente("Sara", "Torres", "Galicia", "Dirección Sara", "1234567890", "123456789123456789",
//                "123456789", new Date(1980, 04, 12), "1", "sara@gmail.com");
//        ma.registrarCliente(cliente1);

        // Ciclo temporal, sólo para probar el metodo que lee las cuentas de la db
//        for (dto.CuentaDTO dto : cb1.getCacheCuentas()) { // Verificar que el Metodo leerCuentas() funciona
//            System.out.println(dto);
//        }

        // Ciclo temporal, sólo para ver qué retiros sin tarjeta existen publicados
//        pc1.generarRetiroSinTarjeta(); // Llamamos al metodo que genera los retiros
//        for (String ret : models.Atm.getCacheRetiroSinTar().keySet()) {
//            System.out.println(ret + " - " + models.Atm.getCacheRetiroSinTar().get(ret));
//        }
//        Scanner scan = new Scanner(System.in);
        // Verificamos que las validaciones del retiro sin tarjeta funcionen
//        int c = 1;
//        while (c > 0) {
//            models.Ticket ticketRetiroSinTar = pc1.cobrarRetiroSinTarjeta();
//            System.out.println(ticketRetiroSinTar);
//            System.out.println("Continuar?");
//            System.out.println("1 (SI), 0 (NO)");
//            c = scan.nextInt();
//        }

//        models.Ticket ticket = cb1.pagarServicio("5578123412340006", "CFE001", "CFE-1002003002");
//        System.out.println(ticket);
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