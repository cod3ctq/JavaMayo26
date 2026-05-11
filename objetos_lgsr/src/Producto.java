import java.util.Date;
//modelo o plantilla de algo
//Clase es un concepto de QUE y COMO
public class Producto {
        double costo;
        String folio;
        String nombre;
        double stock;
        Date fechaRegistro;
        String categoria;

        //metodo Constructor o Constructores
    //Establecer formas y/o valores iniciales a las instancias de esta clase(objetos)
    public Producto() {//Constructor vacio: 0 argumentos y no tiene logica
    }

    public Producto(double costo, String categoria, Date fechaRegistro, double stock, String nombre, String folio) {
        this.costo = costo;
        this.categoria = categoria;
        this.fechaRegistro = fechaRegistro;
        this.stock = stock;
        this.nombre = nombre;
        this.folio = folio;
    }
    //getter y setter: Mecanismos para establecer valores al interior del objeto y recuperarlos desde adentro


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

    //visualizar el estado (ver que valores tiene cada atributo del objeto)


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
