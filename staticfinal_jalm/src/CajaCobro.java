public class CajaCobro {

    // Estos atributos son static porque pertenecen a la clase CajaCobro.
    // Guardan informacion general de todas las cajas juntas.
    public static double ventaTOtal = 0.0;
    public static int numVentas = 0;


    // Estos atributos no son static porque pertenecen a cada objeto.
    // Cada caja tiene su propio id, cajero, total vendido y numero de ventas.
    private String cajaId;
    private String nombreCajero;
    private double ventaTotalCaja;
    private int numVentasCaja;

    // Constructor vacio: permite crear una CajaCobro sin mandar datos al inicio.
    public CajaCobro(){

    }

    // Constructor con parametros: permite crear una caja con id y nombre de cajero.
    public CajaCobro(String cajaId, String nombreCajero) {
        // this se usa para decir que estamos guardando el dato en el atributo del objeto.
        this.cajaId = cajaId;
        this.nombreCajero = nombreCajero;
    }

    // Getter static: regresa el total de ventas de todas las cajas.
    public static double getVentaTOtal() {
        return ventaTOtal;
    }

    // Setter static: permite cambiar el total general de ventas.
    public static void setVentaTOtal(double ventaTOtal) {
        CajaCobro.ventaTOtal = ventaTOtal;
    }

    // Getter static: regresa cuantas ventas se hicieron en total.
    public static int getNumVentas() {
        return numVentas;
    }

    // Setter static: permite cambiar el numero total de ventas.
    public static void setNumVentas(int numVentas) {
        CajaCobro.numVentas = numVentas;
    }

    // Regresa el id de esta caja.
    public String getCajaId() {
        return cajaId;
    }

    // Cambia el id de esta caja.
    public void setCajaId(String cajaId) {
        this.cajaId = cajaId;
    }

    // Regresa el nombre del cajero de esta caja.
    public String getNombreCajero() {
        return nombreCajero;
    }

    // Cambia el nombre del cajero de esta caja.
    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    // Regresa el total vendido solo por esta caja.
    public double getVentaTotalCaja() {
        return ventaTotalCaja;
    }

    // Cambia el total vendido solo por esta caja.
    public void setVentaTotalCaja(double ventaTotalCaja) {
        this.ventaTotalCaja = ventaTotalCaja;
    }

    // Regresa cuantas ventas hizo solo esta caja.
    public int getNumVentasCaja() {
        return numVentasCaja;
    }

    // Cambia cuantas ventas hizo solo esta caja.
    public void setNumVentasCaja(int numVentasCaja) {
        this.numVentasCaja = numVentasCaja;
    }

    @Override
    // Convierte el objeto en texto para poder mostrar sus datos facilmente.
    public String toString() {
        return "CajaCobro{" +
                "cajaId='" + cajaId + '\'' +
                ", nombreCajero='" + nombreCajero + '\'' +
                '}';
    }


    // Actualiza el total general y tambien el total vendido por esta caja.
    public void registrarVenta(double montoVenta){
        // Suma el monto al total general de todas las cajas.
        ventaTOtal = ventaTOtal + montoVenta;

        // Suma el monto al total de ventas de esta caja en especifico.
        ventaTotalCaja = ventaTotalCaja + montoVenta;

        // Aumenta el contador general de ventas.
        numVentas++;

        // Aumenta el contador de ventas de esta caja.
        numVentasCaja++;

    }

}
