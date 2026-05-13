package paquete1;
//Encapsulamiento: Oculta/segmenta el acceso o visibilidad de los miembros de una clase para proteger su estado.
//Se pueden controlar a traves de los modificadores de acceso:
//Public
//Protected
//Private
public class Casa {

    public String direccion;
    protected String parque;
    private String cochera;

    public Casa(){

    }

    public Casa(String direccion, String parque, String cochera) {
        this.direccion = direccion;
        this.parque = parque;
        this.cochera = cochera;
    }

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

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", parque='" + parque + '\'' +
                ", cochera='" + cochera + '\'' +
                '}';
    }
}
