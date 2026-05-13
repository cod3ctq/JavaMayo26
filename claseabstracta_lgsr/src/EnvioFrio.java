import java.util.Scanner;

public class EnvioFrio extends Envio{

    double temperaturaMinima;

    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double peso, double temperaturaMinima) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, peso);
        this.temperaturaMinima = temperaturaMinima;
    }

    @Override
    public double calcularCosto() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingresa la distancia en km: ");
        double distancia = scan.nextDouble();
        this.precioBase = 5000.00;
        return precioBase + (distancia * 500);
    }

    @Override
    public void validarDatos() {

        System.out.println("Verificando temperatura minima: "+temperaturaMinima);

    }
}
