public abstract class Envio {
    String direccion;
    String receptor;
    String fechaEntrega;
    boolean fragil;
    double precioBase;
    boolean status;
    double pesoPaquete;



    public Envio(){}


    public Envio(String direccion, String receptor, String fechaEntrega, boolean fragil, double precioBase, boolean status, double pesoPaquete) {
        this.direccion = direccion;
        this.receptor = receptor;
        this.fechaEntrega = fechaEntrega;
        this.fragil = fragil;
        this.precioBase = precioBase;
        this.status = status;
        this.pesoPaquete = pesoPaquete;
    }

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

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Envio{" +
                "direccion='" + direccion + '\'' +
                ", receptor='" + receptor + '\'' +
                ", fechaEntrega='" + fechaEntrega + '\'' +
                ", fragil=" + fragil +
                ", precioBase=" + precioBase +
                ", status=" + status +
                ", pesoPaquete=" + pesoPaquete +
                '}';
    }

    public abstract double calcularCosto();
    public abstract void validarDatos();
}
