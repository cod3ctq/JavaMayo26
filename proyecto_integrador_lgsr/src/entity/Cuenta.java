package entity;

public class Cuenta {
    private String numCuenta;
    private String numTarjeta;
    private String nip;
    private String titular;
    private double saldo;
    private String fechaApertura;

    public Cuenta() {
    }

    public Cuenta(String numCuenta, String numTarjeta, String nip, String titular, double saldo, String fechaApertura) {
        this.numCuenta = numCuenta;
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.titular = titular;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "entity.Cuenta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura='" + fechaApertura + '\'' +
                '}';
    }

    //

}
