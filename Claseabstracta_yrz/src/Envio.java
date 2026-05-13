import java.util.Scanner;

public abstract class Envio {
    String direccion;
    String receptor;
    String fechaEntrega;
    boolean fragil;
    double precioBase;
    boolean status;
    double distancia;
    double pesoPaquete;
    public Envio(){}

    public Envio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double distancia, double pesoPaquete) {
        this.direccion = direccion;
        this.receptor = receptor;
        this.fechaEntrega = fechaEntrega;
        this.fragil = fragil;
        this.precioBase = precioBase;
        this.status = status;
        this.distancia = distancia;
        this.pesoPaquete = pesoPaquete;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "direccion='" + direccion + '\'' +
                ", receptor='" + receptor + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", fragil=" + fragil +
                ", precioBase=" + precioBase +
                ", status=" + status +
                ", distancia=" + distancia +
                ", pesoPaquete=" + pesoPaquete +
                '}';
    }

    public abstract double calcularCosto();
    public abstract void validarDatos();
}
