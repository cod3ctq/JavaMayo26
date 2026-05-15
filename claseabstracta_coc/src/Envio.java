public abstract class Envio {

    String direccion;
    String receptor;
    String fechaEntrega;
    boolean esFragil;
    double precioBase;
    boolean statusEntrega;
    double peso;

    // Constructores
    public Envio() {
    }
    public Envio(String direccion, String receptor, String fechaEntrega, boolean esFragil, double precioBase, boolean statusEntrega, double peso) {
        this.direccion = direccion;
        this.receptor = receptor;
        this.fechaEntrega = fechaEntrega;
        this.esFragil = esFragil;
        this.precioBase = precioBase;
        this.statusEntrega = statusEntrega;
        this.peso = peso;
    }

    // Getters/Setters
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getReceptor() {
        return receptor;
    }
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }
    public String getFechaEntrega() {
        return fechaEntrega;
    }
    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    public boolean isEsFragil() {
        return esFragil;
    }
    public void setEsFragil(boolean esFragil) {
        this.esFragil = esFragil;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public boolean isStatusEntrega() {
        return statusEntrega;
    }
    public void setStatusEntrega(boolean statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Envio{" +
                "direccion='" + direccion + '\'' +
                ", receptor='" + receptor + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", esFragil=" + esFragil +
                ", precioBase=" + precioBase +
                ", statusEntrega=" + statusEntrega +
                ", peso=" + peso +
                '}';
    }

    // Métodos abstractos
    public abstract double calcularCosto(); // Métodos abstractos
    public abstract void validarDatos(); // No llevan llaves
}