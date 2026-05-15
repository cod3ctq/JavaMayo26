public class Videojuego {
    String nombre;
    String clasificacionEsrb;
    double precio;
    String plataformas;
    String compañiaDesarroladora;
    String fechaLanzamiento;

    public Videojuego(){

    }

    public Videojuego(String nombre, String clasificacionEsrb, double precio, String plataformas, String compañiaDesarroladora, String fechaLanzamiento) {
        this.nombre = nombre;
        this.clasificacionEsrb = clasificacionEsrb;
        this.precio = precio;
        this.plataformas = plataformas;
        this.compañiaDesarroladora = compañiaDesarroladora;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClasificacionEsrb() {
        return clasificacionEsrb;
    }

    public void setClasificacionEsrb(String clasificacionEsrb) {
        this.clasificacionEsrb = clasificacionEsrb;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public String getCompañiaDesarroladora() {
        return compañiaDesarroladora;
    }

    public void setCompañiaDesarroladora(String compañiaDesarroladora) {
        this.compañiaDesarroladora = compañiaDesarroladora;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "nombre='" + nombre + '\'' +
                ", clasificacionEsrb='" + clasificacionEsrb + '\'' +
                ", precio=" + precio +
                ", plataformas='" + plataformas + '\'' +
                ", compañiaDesarroladora='" + compañiaDesarroladora + '\'' +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                '}';
    }
}
