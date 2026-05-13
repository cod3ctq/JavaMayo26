package paquete1;
// Encapsulamiento
public class Casa {

    public String direccion;
    protected String parque;
    private String cochera;

    // Constructores
    public Casa() {
    }
    public Casa(String direccion, String parque, String cochera) {
        this.direccion = direccion;
        this.parque = parque;
        this.cochera = cochera;
    }

    // Getters/Setters
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getParque() {
        return parque;
    }
    public void setParque(String parque) {
        this.parque = parque;
    }
    public String getCochera() {
        return cochera;
    }
    public void setCochera(String cochera) {
        this.cochera = cochera;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", parque='" + parque + '\'' +
                ", cochera='" + cochera + '\'' +
                '}';
    }
}