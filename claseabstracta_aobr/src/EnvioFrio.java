import java.util.Scanner;

public class EnvioFrio extends Envio{

    double temperaturaMin;

    public EnvioFrio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete, double temperaturaMin) {
        super(direccion, receptor, fechaEntrega, fragil, precioBase, status, pesoPaquete);
        this.temperaturaMin = temperaturaMin;
    }

    @Override
    public double calcularCosto() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe la distancia en km:");
        double distancia = teclado.nextDouble();
        this.precioBase = 5000.00;
        return precioBase + (distancia * 500);
    }

    @Override
    public void validarDatos() {

        System.out.println("Verificando temperatura minima: " +temperaturaMin);

    }
}
