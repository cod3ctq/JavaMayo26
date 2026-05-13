public class CajaCobro {
    //atributos de clase (reciben su valor desde la clase y son compartidos por todas las instancias)
    public static double ventaTotal = 0.0;
    public static int numVentas = 0;

    //Atributos de instancia: Cada instancia decide el valor de estos atributos

    private String cajaId;
    private String nombreCajero;

    public CajaCobro(){}

    public CajaCobro(String cajaId, String nombreCajero) {
        this.cajaId = cajaId;
        this.nombreCajero = nombreCajero;
    }

    public static double getVentaTotal() {
        return ventaTotal;
    }

    public static void setVentaTotal(double ventaTotal) {
        CajaCobro.ventaTotal = ventaTotal;
    }

    public static int getNumVentas() {
        return numVentas;
    }

    public static void setNumVentas(int numVentas) {
        CajaCobro.numVentas = numVentas;
    }

    public String getCajaId() {
        return cajaId;
    }

    public void setCajaId(String cajaId) {
        this.cajaId = cajaId;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    @Override
    public String toString() {
        return "CajaCobro{" +
                "cajaId='" + cajaId + '\'' +
                ", nombreCajero='" + nombreCajero + '\'' +
                '}';
    }

    //metodo estatico
    public static void registrarVenta(double totalVenta){
        ventaTotal = ventaTotal + totalVenta; //actualiza la ventaTotal
        numVentas = numVentas +1;

    }
}
