
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

public abstract class Atm {

    private String direccion;
    private String folio;
    public static int folioOperacion = 0; //contador goblal de operaciones
    private Cuenta[] database;
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<String, Double>();
    private List<CuentaDTO> cacheCuentas;
    public static Map<String,Double> cacheRst=new HashMap<String,Double>(); // Retiro sin tarjeta por cobrar
    public static Set<String> cacheRetirosCobrados = new HashSet<String>();//    Referencias de retiros ya cobrados

    // Objetos JDBC temporales
//    Connection con = null;
//    PreparedStatement ps = null;
//    ResultSet rs = null;
    //Inyeccion de dependencias - manual
    //se inyecta en esta clase, aunque cualquier otra tambien puede usarla
    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao= new MovimientoDAO();

    public Atm() {

        //    this.database = cargarCuentas();
        this.cacheCuentas = cuentadao.leerCuentas();//llena automaticamente el cache trayendo las cuentas desde la db
    }

    public Atm(String direccion, String folio) {
        this.direccion = direccion;
        this.folio = folio;
        this.database = cargarCuentas();
    }

    public String getDireccion() {
        return direccion;

    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }

    public String getFolio() {

        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public static int getFolioOperacion() {

        return folioOperacion;
    }

    public static void setFolioOperacion(int folioOperacion) {

        Atm.folioOperacion = folioOperacion;
    }



    public List<CuentaDTO> getCacheCuentas() {
        return cacheCuentas;
    }

    public void setCacheCuentas(List<CuentaDTO> cacheCuentas) {
        this.cacheCuentas = cacheCuentas;
    }

    public static Map<String, Double> getCacheRetirosDiarios() {
        return cacheRetirosDiarios;
    }

    public static void setCacheRetirosDiarios(Map<String, Double> cacheRetirosDiarios) {
        Atm.cacheRetirosDiarios = cacheRetirosDiarios;
    }

    public CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public void setCuentadao(CuentaDAO cuentadao) {
        this.cuentadao = cuentadao;
    }

    public MovimientoDAO getMovimientodao() {
        return movimientodao;
    }

    public void setMovimientodao(MovimientoDAO movimientodao) {
        this.movimientodao = movimientodao;
    }

    public static Set<String> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<String> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    public static Map<String, Double> getCacheRst() {
        return cacheRst;
    }

    public static void setCacheRst(Map<String, Double> cacheRst) {
        Atm.cacheRst = cacheRst;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }

    //
// throw: Va dentro de la logica del metodo, crea o instancia la excepcion
    //throws: Va en la firma del metodo, propaga la excepcion

    public CuentaDTO buscarCuenta(String numTajeta, String nip) throws AccountNotFoundException {
// Buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados

        CuentaDTO encontrado = null;

        for (int i = 0; i < cacheCuentas.size(); i++) {
            if (cacheCuentas.get(i).getNumTarjeta().equals(numTajeta) && (cacheCuentas.get(i).getNip().equals(nip))) {
                encontrado = cacheCuentas.get(i);
                break;
            }
        }
        if (encontrado != null) {
            return encontrado;
        } else {
            //creando la excepcion
            throw new AccountNotFoundException(Constantes.ACCOUNT_NOT_FOUND);
        }
    }

    public void consultarSaldo(String numTarjeta, String nip) {
        CuentaDTO c = buscarCuenta(numTarjeta, nip);
        if (c != null) {
            System.out.println("Tu saldo es: " + c.getSaldo());
        } else {
            System.out.println("Cuenta inexistente!");
        }
    }



    private Cuenta[] cargarCuentas() {
        File file = new File("C:\\Users\\Yair\\Desktop\\cuentas.txt");
        String linea; //informacion completa, junta
        Cuenta cuenta; //objeto temporal, que guardara los datos de cada linea, ya separados
        Cuenta[] cuentas = new Cuenta[50]; //De antemano sé que leere 50 registros
        String[] datos; //informacion ya separada, con el metodo split()
        int contador = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");
                cuenta = new Cuenta(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), datos[5]);
                cuentas[contador] = cuenta;
                contador++;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cuentas;
    }


    public void gerarRetiroSinTarjeta() {
// Metodo hecho solo para automatizar la generacion de los retiros asociandolos a una cuenta
        // leida desde db. solo para simular los datos
        //Generar 5 retiros sin tarjeta con valores aleatorios
        for(CuentaDTO dto:getCacheCuentas()){
            cacheRst.put(dto.getNumCuenta()+":"+Helper.generarReferencia()+":"+Helper.generarClave(),Double.parseDouble(Helper.generarMonto()));
        }
    }


    public abstract Ticket cobrarRetiroSinTarjeta();

    public void inspeccionarCacheRetirosDiario() {
        for (String registro : cacheRetirosDiarios.keySet()) {
            System.out.println(registro + " : " + cacheRetirosDiarios.get(registro));
        }
    }




}






