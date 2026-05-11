import java.util.Date;

// Una Clase es un modelo o plantilla de algo... QUÉ Y CÓMO?
public class Producto {
    // Atributos:
    // Son las características de un Objeto
    double costo;
    String folio;
    String nombre;
    double stock;
    Date fechaRegistro;
    String categoria;

    // Constructor o constructores:
    // Su propósito es establecer formas y/o valores iniciales a las instancias de esta Clase (Objetos)
    // Constructor vacío: 0 argumentos y no tiene lógica
    public Producto() {
    }

    // Constructor con argumentos/parámetros:
    public Producto(double costo, String folio, String nombre, double stock, Date fechaRegistro, String categoria) {
        this.costo = costo;
        this.folio = folio;
        this.nombre = nombre;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
    }

    // Getters y Setters: Mecanismos para establecer valores al interior del Objeto y recuperarlos desde dentro
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public String getFolio() {
        return folio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getStock() {
        return stock;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Metodo "toString()": Para visualizar el estado (ver qué valores tiene cada atributo del Objeto
    @Override
    public String toString() {
        return "Producto{" +
                "costo=" + costo +
                ", folio='" + folio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                ", fechaRegistro=" + fechaRegistro +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}