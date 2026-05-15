public class CajaCobro {

    public static double ventaToltal = 0.0;
    public static int numVentas = 0;


    private String cajaId;
    private String nombreCajero;

    public CajaCobro(){}

    public CajaCobro(String cajaId, String nombreCajero) {
        this.cajaId = cajaId;
        this.nombreCajero = nombreCajero;
    }

    public static double getVentaToltal() {
        return ventaToltal;
    }

    public static void setVentaToltal(double ventaToltal) {
        CajaCobro.ventaToltal = ventaToltal;
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
        ventaToltal = ventaToltal + totalVenta;
        numVentas = numVentas +1;
    }
}
