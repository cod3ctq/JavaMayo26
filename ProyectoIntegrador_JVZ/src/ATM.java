import javax.security.auth.login.AccountNotFoundException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public abstract class ATM {

    private String direcciones;
    private String folio;
    public static int folioOperaciones = 0; //Contador global de todas las operaciones del cajero
    private Cuenta[] database; //Composición
    private List<CuentaDTO> cacheCuentas;  //Objeto que contiene las cuentas tal como vienen desde la db no usan
    //Caché de retiros diarios.
    public static Map<String, Double> cacheRetiroDiarios = new HashMap<String,Double>();
    public static Map<String,Double> cacheRST = new HashMap<String, Double>();//Retiro sin tarjeta por cobrar
    public static Set<String> cacheRetirosCobrados = new HashSet<String>(); //Referencia de rst ya cobrados

    //Inyeccion de dependencias - manual
    //Se inyecta en esta clase, aunque cualquier otra tambien puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao = new MovimientoDAO();


    public ATM(){
        //this.database = cargarCuentas();
        this.cacheCuentas = cuentadao.leerCuentas(); //Este metodo llena automaticamente el cache trayendo las cuentas desde la bd.
    }

    public ATM(String direcciones, String folio) {
        this.direcciones = direcciones;
        this.folio = folio;
        this.database = cargarCuentas();
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public static int getFolioOperaciones() {
        return folioOperaciones;
    }

    public static void setFolioOperaciones(int folioOperaciones) {
        ATM.folioOperaciones = folioOperaciones;
    }


    public List<CuentaDTO> getCacheCuentas() {
        return cacheCuentas;
    }

    public void setCacheCuentas(List<CuentaDTO> cacheCuentas) {
        this.cacheCuentas = cacheCuentas;
    }

    public static Map<String, Double> getCacheRetiroDiarios() {
        return cacheRetiroDiarios;
    }

    public static void setCacheRetiroDiarios(Map<String, Double> cacheRetiroDiarios) {
        ATM.cacheRetiroDiarios = cacheRetiroDiarios;
    }

    public MovimientoDAO getMovimientodao() {
        return movimientodao;
    }

    public void setMovimientodao(MovimientoDAO movimientodao) {
        this.movimientodao = movimientodao;
    }

    public CuentaDAO getCuentadao() {
        return cuentadao;
    }

    public void setCuentadao(CuentaDAO cuentadao) {
        this.cuentadao = cuentadao;
    }

    public static Map<String, Double> getCacheRST() {
        return cacheRST;
    }

    public static void setCacheRST(Map<String, Double> cacheRST) {
        ATM.cacheRST = cacheRST;
    }

    public static Set<String> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<String> cacheRetirosCobrados) {
        ATM.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "direcciones='" + direcciones + '\'' +
                ", folio='" + folio + '\'' +
                '}';


    }

    //trhow: dentro de la logica del metodo, crea o instancia la excepcion
    //throws: Va en la firma del método, propaga la excepción
    public CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException{
        CuentaDTO encontrado = null;
        //Buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados
        for (int i = 0; i<cacheCuentas.size(); i++){
            if (cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta) && cacheCuentas.get(i).getNip().equals(nip)){
                encontrado = cacheCuentas.get(i);
                break;

            }
        }
        if (encontrado!=null){ //si la cuenta existe .....
            return encontrado;
        }else {
            //creando la excepcion
            throw new AccountNotFoundException(COnstantes.ACCOUNT_NOT_FOUND);
        }
    }


    public void consultarSaldo(String numTarjeta, String nip) throws AccountNotFoundException {
        CuentaDTO c = buscarCuenta(numTarjeta,nip);
        if (c!=null){
            System.out.println("Tu saldo es: "+c.getSaldo());
        } else {
            System.out.println("Cuenta inexistente!");
        }


    }


    private Cuenta[] cargarCuentas(){
        File file = new File("C:\\Users\\alber\\Desktop\\Cuentas.txt");
        String linea; //Información completa, junta
        Cuenta cuenta; // Objeto temporal, que guardara los datos de cada linea ya separados
        Cuenta[] cuentas = new Cuenta[50]; //De antemano sé que leere 50 registros
        String[] datos; //Información ya separada, con el metodo split()
        int contador = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ((linea = br.readLine())!=null){
                datos = linea.split(",");
                cuenta = new Cuenta(datos[0],datos[1],datos[2],datos[3],Double.parseDouble(datos[4]),datos[5]);
                cuentas[contador] = cuenta;
                contador++;


            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());

        }
        return cuentas;
    }

    public void generarRetirosSinTarjeta(){

        //Genera 5 retiros sin tarjeta con valores aleatorios

        for (CuentaDTO dto:getCacheCuentas()){
            cacheRST.put(dto.getNumCuenta()+":"+Helper.generarReferencia()+":"+Helper.generarClave(),Double.parseDouble(Helper.generarMonto()));

        }

    }

    public abstract Ticket cobrarRetiroSinTarjeta();

    public void inspeccionarCacheRetirosDiarios(){

        for (String registro: cacheRetiroDiarios.keySet()){
                      //          "1869416546/15/05/2026 : 12000"
            System.out.println(registro + " : " + cacheRetiroDiarios.get(registro));

        }

    }





}


