public class Juego {
    String nombre;
    String clasificacion;
    int inventario;
    String lanzamiento;
    double costo;

    public Juego(){};

    public Juego(String nombre, String clasificacion, int inventario, String lanzamiento, double costo) {
        this.nombre = nombre;
        this.clasificacion = clasificacion;
        this.inventario = inventario;
        this.lanzamiento = lanzamiento;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "nombre='" + nombre + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", inventario=" + inventario +
                ", lanzamiento='" + lanzamiento + '\'' +
                ", costo=" + costo +
                '}';
    }
}
