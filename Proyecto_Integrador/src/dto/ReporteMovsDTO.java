package dto;

import java.util.List;
import java.util.Map;

public class ReporteMovsDTO {

    private String titular;
    private String rfc;
    private Map<String, List<DetalleMovimientoDTO>> movsPorCuenta;
    private double ingresos;
    private double egresos;

    public  ReporteMovsDTO(){}

    public ReporteMovsDTO(String titular, String rfc, Map<String, List<DetalleMovimientoDTO>> movsPorCuenta, double ingresos, double egresos) {
        this.titular = titular;
        this.rfc = rfc;
        this.movsPorCuenta = movsPorCuenta;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

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