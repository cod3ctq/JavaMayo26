import java.util.Date;


//Clase: Modelo o plantilla de algo
//Conjunto de que y como
public class Producto {


    double costo;
    String folio;
    String nombre;
    double stock;
    Date fechaRegistro;
    String categoria;

    //Metodo constructor o con structores: Establece formas y valores iniciales a las instancias de esta clase(objetos)

    public Producto(){ //Constructor vacio: 0 argumentos y no tiene logica
    }
    //Clic derecho/generate/constructor/seleccionamos los datos

    public Producto(double costo, String folio, String nombre, double stock, Date fechaRegistro, String categoria) {
        this.costo = costo;
        this.folio = folio;
        this.nombre = nombre;
        this.stock = stock;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
    }
    //Polimorfismo


//Getter y Setter: mecanimso para establecer valores al interior del objeto y recuperarlos desde dentro
    //clic derecho/generate/Getter and Setter/seleccionamos los datos
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
    //Visualizar el estado del objeto
        //Ver que valores tiene cada atributo del objeto



            //Clic derecho/Generate/Tostring()
    //ToString permite ver los atributos o valores del objeto
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
