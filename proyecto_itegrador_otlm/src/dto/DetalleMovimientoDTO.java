package dto;

import java.sql.Date;

public class DetalleMovimientoDTO {
    private String tipo;
    private Date fecha;
    private double monto;

    public DetalleMovimientoDTO() {
    }

    public DetalleMovimientoDTO(String tipo, Date fecha, double monto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
    }

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

    @Override
    public String toString() {
        return "dto.DetalleMovimientoDTO{" +
                "tipo='" + tipo + '\'' +
                ", fecha=" + fecha +
                ", monto=" + monto +
                '}';
    }
}
