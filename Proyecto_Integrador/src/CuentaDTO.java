import java.sql.Date;

//Esta clase mapea una estructura que puede cambiar segun las necesidades entonces debe de ser flexible debe de  ser
//Por esto esta clase es un DTO
public class CuentaDTO {

    private String numTarjeta;
    private String nip;
    private int cuentaDTO;
    private String numCuenta;
    private double saldo;
    private double saldoMin;
    private double saldoMax;
    private Date fecha;
    private String titular;

    public CuentaDTO(String titular, Date fecha, double saldoMax, double saldoMin, double saldo, String numCuenta, int cuentaDTO, String nip, String numTarjeta) {
        this.titular = titular;
        this.fecha = fecha;
        this.saldoMax = saldoMax;
        this.saldoMin = saldoMin;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.cuentaDTO = cuentaDTO;
        this.nip = nip;
        this.numTarjeta = numTarjeta;
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

    public int getCuentaDTO() {
        return cuentaDTO;
    }

    public void setCuentaDTO(int cuentaDTO) {
        this.cuentaDTO = cuentaDTO;
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

    @Override
    public String toString() {
        return "CuentaDTO{" +
                "numTarjeta='" + numTarjeta + '\'' +
                ", nip='" + nip + '\'' +
                ", cuentaDTO=" + cuentaDTO +
                ", numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                ", saldoMin=" + saldoMin +
                ", saldoMax=" + saldoMax +
                ", fecha=" + fecha +
                ", titular='" + titular + '\'' +
                '}';
    }
}
