package models;

import java.time.LocalDateTime;

public class Ticket {

    private String direccion;
    private int folioOperacion = 0;
    private LocalDateTime fechaHora;//Se introdujo a partir de Java 8
    private double montoOperacion;
    private String tipoOperacion;
    private String cuenta;//Solo los ultimos 4 digitos

    public Ticket(){}

    //Patron Builder: Construye objetos paso por paso, de manera flexible
    private Ticket(Builder builder) {
        this.direccion = builder.direccion;
        this.folioOperacion = builder.folioOperacion;
        this.fechaHora = builder.fechaHora;
        this.montoOperacion = builder.montoOperacion;
        this.tipoOperacion = builder.tipoOperacion;
        this.cuenta = builder.cuenta;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String direccion;
        private int folioOperacion = 0;
        private LocalDateTime fechaHora;//Se introdujo a partir de Java 8
        private double montoOperacion;
        private String tipoOperacion;
        private String cuenta;//Solo los ultimos 4 digitos

        public Builder direccion(String direccion){
            this.direccion = direccion;
            return this;
        }

        public Builder folio(int folio) {
            this.folioOperacion = folio;
            return this;
        }

        public Builder fecha(LocalDateTime fecha) {
            this.fechaHora = fecha;
            return this;
        }

        public Builder monto(double monto) {
            this.montoOperacion = monto;
            return this;
        }

        public Builder tipoOperacion(String tipoOperacion) {
            this.tipoOperacion = tipoOperacion;
            return this;
        }

        public Builder cuenta(String cuenta) {
            this.cuenta = cuenta;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
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
        return "models.Ticket{" +
                "direccion='" + direccion + '\'' +
                ", folioOperacion=" + folioOperacion +
                ", fechaHora=" + fechaHora +
                ", montoOperacion=" + montoOperacion +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", cuenta='" + cuenta + '\'' +
                '}';
    }
}
