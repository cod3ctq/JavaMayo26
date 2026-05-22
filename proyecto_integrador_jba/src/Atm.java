import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Atm {

    private String direccion;
    private String folio;
    public static int folioOperacion=0;  //contador de las operaciones del cajero
    private Cuenta[] database; //composicion
    private List<CuentaDTO> cacheCuentas; //objeto que contiene las cuentas tal y ciomo vienen desde la db
    //Cache de retiros diarios
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<String,Double>();


    //INYECCION DE DEPENDENCIAS -MANUAL
    //se inyecta en esta clase, aunque cualquier otra puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO();
    private MovimientoDAO movimientodao = new MovimientoDAO();


    public Atm(){
       // this.database = cargarCuentas();
        this.cacheCuentas = cuentadao.leerCuentas(); //llena automaticamente el cache trayendo las cuentas desde la db
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

 //          public Cuenta[] getDatabase() {
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

    //buscar dentro del array de cuentas, a la cuenta con el numero y nip ingresados
    for(int i=0; i<cacheCuentas.size(); i++){
        if(cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta) && cacheCuentas.get(i).getNip().equals(nip)){
            encontrado = cacheCuentas.get(i);
            break;
        }

    }

    if (encontrado!=null){
        return encontrado;
    }else {
        //creando la excepcion
        throw new AccountNotFoundException(Constantes.ACCOUNT_NOT_FOUND);
    }

    }
    public void consultarSaldo(String numTarejta, String nip){

        CuentaDTO c = buscarCuenta(numTarejta,nip);
        if(c!=null){
            System.out.println("Tu saldo es: "+c.getSaldo());
        } else {
            System.out.println("Cuenta Inexistente!");
        }

    }

    private Cuenta[] cargarCuentas(){
        File file = new File("C:\\Users\\ENRIQUE BORJA\\Desktop\\cuentas.txt");
        String linea;
        Cuenta cuenta;
        Cuenta[] cuentas = new Cuenta[50];
        String[] datos;
        int contador = 0;
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while ( (linea = br.readLine())!=null){
                datos = linea.split(",");
                cuenta = new Cuenta(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), datos[5]);
                cuentas[contador] = cuenta;
                contador++;
            }

            }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return cuentas;
    }

    public void generarRetirosSinTrajeta(){}

    public abstract void cobrarRetirosSinTarjeta();

    public void  inspeccionarCacheRetirosDiarios(){

        for(String registro:cacheRetirosDiarios.keySet()){
            System.out.println(registro +" : " + cacheRetirosDiarios.get(registro));
        }
    }


}


