import java.util.Scanner;

public class EnvioFrio extends Envio{

    double temperaturaMinima;

    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, double temperaturaMinima) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double CalcularCosto() {
        Scanner scan= new Scanner(System.in);
        System.out.println("Ingresa la distancia en km");
        double distancia = scan.nextDouble();
        this.precioBase = 5000.00;
        return precioBase + (distancia * 500);
    }

    @Override
    public void ValidarDatos() {
        System.out.println("Verificando temperatura minima"+temperaturaMinima);
    }
}
