import java.sql.Date;

public class Cliente {

    private int clienteId;
    private String nombre;
    private String apP;
    private String apM;
    private String direccion;
    private String telefono;
    private String ine;
    private String rfc;
    private Date fechaNac;
    private String status;
    private String correo;

    public Cliente(int clienteId, String nombre, String apP, String apM, String direccion, String telefono, String ine, String rfc, Date fechaNac, String status, String correo) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaNac = fechaNac;
        this.status = status;
        this.correo = correo;
    }

    public Cliente(String nombre, String apP, String apM, String direccion, String telefono, String ine, String rfc, Date fechaNac, String status, String correo) {
        this.nombre = nombre;
        this.apP = apP;
        this.apM = apM;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
        this.rfc = rfc;
        this.fechaNac = fechaNac;
        this.status = status;
        this.correo = correo;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApP() {
        return apP;
    }

    public void setApP(String apP) {
        this.apP = apP;
    }

    public String getApM() {
        return apM;
    }

    public void setApM(String apM) {
        this.apM = apM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nombre='" + nombre + '\'' +
                ", apP='" + apP + '\'' +
                ", apM='" + apM + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ine='" + ine + '\'' +
                ", rfc='" + rfc + '\'' +
                ", fechaNac=" + fechaNac +
                ", status='" + status + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
