package dto;

import java.sql.Date;

// DTO: Data Transfer Object
// Patrón de diseño DTO: Esta Clase mapea una estructura que puede cambiar según las necesidades, entonces debe ser flexible
public class DetalleMovimientoDTO {
    // Atributos
    private String tipo;
    private Date fecha;
    private double monto;

    // Constructores
    public DetalleMovimientoDTO() {
    }
    public DetalleMovimientoDTO(String tipo, Date fecha, double monto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

    // Getters/Setters
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    // toString
    @Override
    public String toString() {
        return "dto.DetalleMovimientoDTO{" +
                "tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}