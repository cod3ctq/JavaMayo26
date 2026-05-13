import java.util.Scanner;

public class EnvioFrio extends Envio{

    double temperaturaMinima;

    public EnvioFrio(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, double temperaturaMinima) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularCosto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la distancia en km");
        double distancia = scanner.nextDouble();
        this.precioBase = 5000.0;

        return  precioBase+(distancia*500);
    }

    @Override
    public void validarDatos() {
        System.out.println("Verificando temperatura minima: "+temperaturaMinima);
    }
}
