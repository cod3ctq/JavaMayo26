import java.util.Date;

public class TiendaRopa {

    String nombre;
    String direccion;
    String FolioCompra;
    Date fecha_compra;
    int preductos_comprados;

    public TiendaRopa (){}

    public TiendaRopa(String nombre, String direccion, String folioCompra, Date fecha_compra, int preductos_comprados) {
        this.nombre = nombre;
        this.direccion = direccion;
        FolioCompra = folioCompra;
        this.fecha_compra = fecha_compra;
        this.preductos_comprados = preductos_comprados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFolioCompra() {
        return FolioCompra;
    }

    public void setFolioCompra(String folioCompra) {
        FolioCompra = folioCompra;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getPreductos_comprados() {
        return preductos_comprados;
    }

    public void setPreductos_comprados(int preductos_comprados) {
        this.preductos_comprados = preductos_comprados;
    }

    @Override
    public String toString() {
        return "TiendaRopa{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", FolioCompra='" + FolioCompra + '\'' +
                ", fecha_compra=" + fecha_compra +
                ", preductos_comprados=" + preductos_comprados +
                '}';
    }
}

