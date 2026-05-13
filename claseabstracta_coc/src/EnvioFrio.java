import java.util.Scanner;

public class EnvioFrio extends Envio {

    double temperaturaMinima;

    // Constructores
    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean esFragil, double precioBase, boolean statusEntrega, double peso, double temperaturaMinima) {
        super(direccion, receptor, fechaEntrega, esFragil, precioBase, statusEntrega, peso);
        this.temperaturaMinima = temperaturaMinima;
    }

    // Sobre escribimos Métodos de Envio
    @Override
    public double calcularCosto() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresa la distancia en km: ");
        double distancia = Double.parseDouble(scan.nextLine());
        this.precioBase = 5000.00; // Establecemos precio base para este modelo, para este Objeto (EnvioFrio)
        return precioBase + (distancia * 500); // 10% del precio base (500)
    }
    @Override
    public void validarDatos() {
        System.out.println("Verificando temperatura mínima: " + temperaturaMinima);
    }
}