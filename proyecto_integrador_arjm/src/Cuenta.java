public class Cuenta {

   private String numCuenta;
 private String numTarjeta;
private String Nip;
private String titular;
private double saldo;
private String fehcaApertura;



public Cuenta(){}


    public Cuenta(String numCuenta, String numTarjeta, String nip, String titular, double saldo, String fehcaApertura) {
        this.numCuenta = numCuenta;
        this.numTarjeta = numTarjeta;
        Nip = nip;
        this.titular = titular;
        this.saldo = saldo;
        this.fehcaApertura = fehcaApertura;
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
        return Nip;
    }

    public void setNip(String nip) {
        Nip = nip;
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

    public String getFehcaApertura() {
        return fehcaApertura;
    }

    public void setFehcaApertura(String fehcaApertura) {
        this.fehcaApertura = fehcaApertura;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", numTarjeta='" + numTarjeta + '\'' +
                ", Nip='" + Nip + '\'' +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", fehcaApertura='" + fehcaApertura + '\'' +
                '}';
    }
}
