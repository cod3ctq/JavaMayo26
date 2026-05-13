public class CajaCobro {

    // Atributos de Clase estáticos, reciben su valor desde la Clase y son compartidos por todas las instancias
    public static double ventaTotal = 0.0;
    public static int numVentas = 0;

    // Atributos de instancia, cada instancia decide el valore de esos atributos
    private String cajaId;
    private String nombreCajero;

    // Constructores
    public CajaCobro() {
    }
    public CajaCobro(String cajaId, String nombreCajero) { // Constructor con parámetros no incluye los atributos estáticos
        this.cajaId = cajaId;
        this.nombreCajero = nombreCajero;
    }

    // Getters/Setters
    public static double getVentaTotal() {
        return ventaTotal;
    } // Getters/Setters también estáticos de esos atributos
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

    // Metodo toString
    @Override
    public String toString() {
        return "CajaCobro{" +
                "cajaId='" + cajaId + '\'' +
                ", nombreCajero='" + nombreCajero + '\'' +
                '}';
    }

    // Metodo estático
    public static void registrarVenta(double totalVenta) {
        ventaTotal += totalVenta; // Actualiza la venta total
        numVentas++;
    }
}