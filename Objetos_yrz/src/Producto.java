import java.util.Date;

//modelo o plantilla de algo..
// QUE y COMO
public class Producto {
    double costo;
    String folio;
    String nombre;
    double stock;
    Date fechaRegistro;
    String categoria;

    //COnstructor o constructores
    //Establecer formas y/o valores iniciales a las instancias de esta clase (objetos)
    public Producto(){//Constructor vacio: 0 argumentos y no tiene logica

    }

    public Producto(double costo, String nombre, String folio, double stock, Date fechaRegistro, String categoria) {
        this.costo = costo;
        this.nombre = nombre;
        this.folio = folio;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
    }

    // Getter y setter: mecanismos para establecer valores al interior del objeto
    // y recuperarlos dentro de
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
    //visualizar el estado (ver que balores tiene cada atributo cmo el objeto

    @Override
    public String toString() {
        return "Producto{" +
                "categoria='" + categoria + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", stock=" + stock +
                ", nombre='" + nombre + '\'' +
                ", folio='" + folio + '\'' +
                ", costo=" + costo +
                '}';
    }
}
