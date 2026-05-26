import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

public abstract class Atm {

    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database; //Composicion
    private List<CuentaDTO> cacheCuentas;//objeto que contiene las cuentas tal como vienen desde la base de datos

    //cache de retiros diarios
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<String, Double>(); // static para que el valor se comparta en tre la estancia de la clase cajerobasico y practicaja

    public static Map<String,Double> cacheRst = new HashMap<String,Double>();//Retiros sin tarjeta por cobrar

    public static Set<String> cacheRetirosCobrados = new HashSet<String>();//Referencias de retiros sin tarjeta ya cobrados


    //Inyeccion de dependencias - manual
    //Se inyecta en esta clase, aunque cualquier otra tambien puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao = new MovimientoDAO();

    public Atm(){
   // this.database = cargarCuentas();
    this.cacheCuentas = cuentadao.leerCuentas();//llena automaticamente el cache trayendo las cuentas desde la bs
         }


    public Atm(String direccion, String folio, Cuenta[] database) {
        this.direccion = direccion;
        this.folio = folio;
        this.database = database;
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

//    //public Cuenta[] getDatabase() {
//        return database;
//    }

//    public void setDatabase(Cuenta[] database) {
//        this.database = database;
//    }

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

    public static Map<String, Double> getCacheRst() {
        return cacheRst;
    }

    public static void setCacheRst(Map<String, Double> cacheRst) {
        Atm.cacheRst = cacheRst;
    }

    public static Set<String> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }

    public static void setCacheRetirosCobrados(Set<String> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }
    //throw: Va dentro de la logica del metodo, crea o instancia la excepcion
    //throws: Va en la firma del metodo, propaga la excepcion

    public CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException{

    CuentaDTO encontrado = null;

    //Buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados
        for (int i =0; i< cacheCuentas.size();i++){

            if (cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta) && cacheCuentas.get(i).getNip().equals(nip)){
                encontrado = cacheCuentas.get(i);
                break;
            }
        }
        if (encontrado!=null){// Si la cuenta existe...
            return encontrado;
        }else {
            //Creando la excepcion
            throw new AccountNotFoundException(Constantes.ACCOUNT_NOT_FOUND);//Llama a la exception
        }
    }
    public void consultarSaldo(String numTarjeta, String nip){

    CuentaDTO c = buscarCuenta(numTarjeta, nip);
    if (c!=null){
        System.out.println("Tu saldo es: " + c.getSaldo());
    }else {
        System.out.println("Cuenta inexistente");
    }
}

private Cuenta[] cargarCuentas(){
    File file = new File("C:\\Users\\RENE PC\\Desktop\\cuentas.txt");
    String Linea; // Informacion completa, junta
    Cuenta cuenta; // objeto temporal, que guardara los datos de cada linea, ya separados
    Cuenta[] cuentas = new Cuenta[50]; // de antenmano se que leere 50 registros
    String datos[]; //Informacion ya separada con el metodo split
    int contador = 0;

    try {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while((Linea = br.readLine())!=null){
            datos = Linea.split(",");
            cuenta = new Cuenta(datos[0],datos[1],datos[2],datos[3],Double.parseDouble(datos[4]),datos[5]);
            cuentas[contador] = cuenta;
            contador++;
        }
    }catch (Exception ex){
        System.out.println(ex.getMessage());
    }
    return cuentas;
}
    //Metodo echo solo para automatizar la generacion de los retiros asociandolos a una cuenta
    //leida desde la bs.Solo para simular datos
public void generarRetirosSinTarjeta(){
        //Genera 5 retiros sin tarjeta
    for (CuentaDTO dto:getCacheCuentas()){
        cacheRst.put(dto.getNumCuenta()+":" +Helper.generarReferencia()+":"+Helper.generarClave(),Double.parseDouble(Helper.generarMonto()));



    }
}

    public abstract Ticket cobrarRetiroSinTarjeta();

        public void inspeccionarCacheRetirosDiarios(){
            for (String registro:cacheRetirosDiarios.keySet()){
                System.out.println(registro + " : " + cacheRetirosDiarios.get(registro));
            }
    }





}
