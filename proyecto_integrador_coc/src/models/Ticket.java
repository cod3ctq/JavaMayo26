package models;

import java.time.LocalDateTime;

public class Ticket {
    // Atributos
    private String direccion;
    private int folioOperacion;
    private LocalDateTime fechaHora; // Se introdujo a partir de Java8
    private double montoOperacion;
    private String tipoOperacion;
    private String cuenta; // Sólo los últimos 4 dígitos

    // Constructor vacío
    public Ticket(){
    }

    // Patrón de diseño Builder: Construye Objetos paso por paso, de manera flexible
    private Ticket(Builder builder) { // Constructor que recibe como argumento un Objeto de tipo Builder
        this.direccion = builder.direccion;
        this.folioOperacion = builder.folioOperacion;
        this.fechaHora = builder.fechaHora;
        this.montoOperacion = builder.montoOperacion;
        this.tipoOperacion = builder.tipoOperacion;
        this.cuenta = builder.cuenta;
    }

    // Creamos metodo estático que devolverá Objeto de tipo Builder
    public static Builder builder() { // Constructor Builder
        return new Builder(); // Llama a la Clase interna Builder para devolver ese Objeto
    }

    // Creamos Clase estática
    public static class Builder {
        // Agregamos los mismos atributos que la Clase models.Ticket
        private String direccion;
        private int folioOperacion;
        private LocalDateTime fechaHora;
        private double montoOperacion;
        private String tipoOperacion;
        private String cuenta;

        // Métodos
        public Builder direccion(String direccion) {
            this.direccion = direccion;
            return this; // Retornamos el mismo Objeto Builder
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
        } // Este metodo ya retorna el Objeto de tipo models.Ticket
    }

    // Getters/Setters
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

    // Metodo toString
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