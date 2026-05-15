import java.util.Scanner;

public class EnvioFrio extends Envio{

    double temperaturaMinima;

    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, double temperaturaMinima) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.temperaturaMinima = temperaturaMinima;
    }


    @Override
    public double calcularCostos() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la distancia en km");
        double distancia = scan.nextDouble();
        this.precioBase = 5000.00;
        return precioBase + (distancia * 500);
    }

    @Override
    public void validarDatos() {


        System.out.println("Verificar temperatura minima: "+temperaturaMinima);

    }
}
