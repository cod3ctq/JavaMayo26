import java.sql.Date;

//Esta clase mapea una estructura que pude cambiar segun las necesitdas, entonces debe ser flexible
//por eso es una clase DTO
public class CuentaDTO {
    private String numTarjeta;
    private String nip;
    private int cuentaId;
    private String numCuenta;
    private double saldo;
    private double saldoMin;
    private double saldoMax;
    private Date fecha;
    private String titular;

    public CuentaDTO(String numTarjeta, String nip, int cuentaId, String numCuenta, double saldo, double saldoMin, double saldoMax, Date fecha, String titular) {
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.cuentaId = cuentaId;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.saldoMin = saldoMin;
        this.saldoMax = saldoMax;
        this.fecha = fecha;
        this.titular = titular;
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

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoMin() {
        return saldoMin;
    }

    public void setSaldoMin(double saldoMin) {
        this.saldoMin = saldoMin;
    }

    public double getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(double saldoMax) {
        this.saldoMax = saldoMax;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", cuentaId=" + cuentaId +
                ", numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                ", fecha=" + fecha +
                ", titular='" + titular + '\'' +
                '}';
    }
}
