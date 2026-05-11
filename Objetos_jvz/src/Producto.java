import java.util.Date;

//Una clase es un modelo o plantilla de algo...
//QUE Y COMO
public class Producto {

    double costo;
    String folio;
    String nombre;
    double stock;
    Date fechaRegistro;
    String categoria;

    //Constructor o constructores:
    //Su proposito es establecer formas y/o valores iniciales a las instancias de esta clase, es decir (los objetos).
    public Producto(){ //Constructor vacio: 0 argumentos y no tiene lógica.

    }

    public Producto(double costo, String folio, String nombre, double stock, Date fechaRegistro, String categoria) {
        this.costo = costo;
        this.folio = folio;
        this.nombre = nombre;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
    }

    //Getter y Stter : Mecanismos para establecer valores al interior del objeto y recuperarlo desde dentro
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

    //Visualizar el estado del objeto (ver que valores tiene cada atributo del objeto)
    //Este metodo nos permite visualizar el estado del objeto a texto.

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
