package dto;

import java.util.List;
import java.util.Map;

public class ReporteMovsDTO {

    private String titular;
    private String rfc;
    private Map<String, List<DetalleMovimientoDTO>> movsPorCuenta;
    private double ingreso;
    private double egreso;


    public ReporteMovsDTO(String titular, String rfc, Map<String, List<DetalleMovimientoDTO>> movsPorCuenta, double ingreso, double egreso) {
        this.titular = titular;
        this.rfc = rfc;
        this.movsPorCuenta = movsPorCuenta;
        this.ingreso = ingreso;
        this.egreso = egreso;
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

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
    }

    @Override
    public String toString() {
        return "ReporteMovsDTO{" +
                "titular='" + titular + '\'' +
                ", rfc='" + rfc + '\'' +
                ", movsPorCuenta=" + movsPorCuenta +
                ", ingreso=" + ingreso +
                ", egreso=" + egreso +
                '}';
    }
}
