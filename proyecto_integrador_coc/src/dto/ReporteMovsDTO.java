package dto;

import java.util.List;
import java.util.Map;

// DTO: Data Transfer Object
// Patrón de diseño DTO: Esta Clase mapea una estructura que puede cambiar según las necesidades, entonces debe ser flexible
public class ReporteMovsDTO {
    // Atributos
    private String titular;
    private String rfc;
    private Map<String, List<DetalleMovimientoDTO>> movsPorCuenta;
    private double ingresos;
    private double egresos;

    // Constructores
    public ReporteMovsDTO() {
    }
    public ReporteMovsDTO(String titular, String rfc, Map<String, List<DetalleMovimientoDTO>> movsPorCuenta, double ingresos, double egresos) {
        this.titular = titular;
        this.rfc = rfc;
        this.movsPorCuenta = movsPorCuenta;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    // Getters/Setters
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public Map<String, List<DetalleMovimientoDTO>> getMovsPorCuenta() {
        return movsPorCuenta;
    }
    public void setMovsPorCuenta(Map<String, List<DetalleMovimientoDTO>> movsPorCuenta) {
        this.movsPorCuenta = movsPorCuenta;
    }
    public double getIngresos() {
        return ingresos;
    }
    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
    public double getEgresos() {
        return egresos;
    }
    public void setEgresos(double egresos) {
        this.egresos = egresos;
    }

    // toString
    @Override
    public String toString() {
        return "dto.ReporteMovsDTO{" +
                "titular='" + titular + '\'' +
                ", rfc='" + rfc + '\'' +
                ", movsPorCuenta=" + movsPorCuenta +
                ", ingresos=" + ingresos +
                ", egresos=" + egresos +
                '}';
    }
}