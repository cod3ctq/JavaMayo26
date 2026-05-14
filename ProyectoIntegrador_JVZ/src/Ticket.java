import java.time.LocalDate;

public class Ticket {

    private String direccion;
    private int folioOperacion;
    private LocalDate fechaHora; // A partir de java8
    private double montoOperacion;
    private String tipoOperacion;
    private String cuenta; //Solo los ultimos 4 digitos

    public Ticket(){}

    public Ticket(String direccion, int folioOperacion, LocalDate fechaHora, double montoOperacion, String tipoOperacion, String cuenta) {
        this.direccion = direccion;
        this.folioOperacion = folioOperacion;
        this.fechaHora = fechaHora;
        this.montoOperacion = montoOperacion;
        this.tipoOperacion = tipoOperacion;
        this.cuenta = cuenta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMontoOperacion() {
        return montoOperacion;
    }

    public void setMontoOperacion(double montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "direccion='" + direccion + '\'' +
                ", folioOperacion=" + folioOperacion +
                ", fechaHora=" + fechaHora +
                ", montoOperacion=" + montoOperacion +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", cuenta='" + cuenta + '\'' +
                '}';
    }
}
