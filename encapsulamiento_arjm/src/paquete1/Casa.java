package paquete1;
//Encapsulamiento: consepto que oculta/segmenta el acceso o visibilidad de los miembros de una clase para proteger su estado
//Los niveles se controlan por los modificadores de acceso: public, protected, private

public class Casa {

    public String direccion;
    protected String parque;
    private String cochera; // privado, solo se usa dentro de la clase,

    public Casa(){}  // Constructor vacia

    public Casa(String direccion, String parque, String cochera) { //Constructor con valores
        this.direccion = direccion;
        this.parque = parque;
        this.cochera = cochera;
    }

    //Getters and setter
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

    //To String
    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                ", parque='" + parque + '\'' +
                ", cochera='" + cochera + '\'' +
                '}';
    }
}
