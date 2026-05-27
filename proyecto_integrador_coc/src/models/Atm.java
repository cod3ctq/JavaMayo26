package models;

import constants.Constantes; // Se importó esta Clase al crear paquetes
import dao.CuentaDAO;
import dao.MovimientoDAO;
import dao.ServiciosDAO;
import dto.CuentaDTO;
import entity.Cuenta;
import exception.AccountNotFoundException;
import util.Helper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public abstract class Atm {
    // Atributos
    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database; // Array que almacenará los Objetos de tipo entity.Cuenta (esto es composición)
    private List<CuentaDTO> cacheCuentas = new ArrayList<>(); // Objeto que contendrá las cuentas tal como vienen de la db
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<>(); // Se hace en esta clase porque ambos tipos de cajeros deben tener este atributo
    public static Map<String, Double> cacheRetiroSinTar = new HashMap<>(); // Retiros sin tarjeta por cobrar
    public static Set<String> cacheRetirosCobrados = new HashSet<>(); // Referencia de retiros sin tarjeta ya cobrados

    // Inyección de dependencias - manual
    // Se inyecta en esta Clase, aunque cualquiera que lo necesite puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO(); // Creamos Objeto de dao.CuentaDAO para que esta Clase lo pueda utilizar
    private MovimientoDAO movimientodao = new MovimientoDAO(); // Creamos Objeto de dao.MovimientoDAO para que esta Clase lo pueda utilizar
    private ServiciosDAO serviciosDAO = new ServiciosDAO(); // Creamos Objeto de dao.ServiciosDAO para que esta Clase lo pueda utilizar

    // Constructores
    public Atm() {
//        this.database = cargarCuentas(); // Cargamos cuentas al llamar al constructor, o sea cuando instanciemos un Objeto de tipo models.Atm
        cacheCuentas = cuentadao.leerCuentas(); // El constructor vacío llama a este metodo que llena el cache trayendo las cuentas de la db
    }
    public Atm(String direccion, String folio) {
        this.direccion = direccion;
        this.folio = folio;
//        this.database = cargarCuentas(); // Cargamos cuentas al llamar al constructor, o sea cuando instanciemos un Objeto de tipo models.Atm
    }

    // Getters/Setters
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
//    public entity.Cuenta[] getDatabase() {
//        return database;
//    }
//    public void setDatabase(entity.Cuenta[] database) {
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
    public static Map<String, Double> getCacheRetiroSinTar() {
        return cacheRetiroSinTar;
    }
    public static void setCacheRetiroSinTar(Map<String, Double> cacheRetiroSinTar) {
        Atm.cacheRetiroSinTar = cacheRetiroSinTar;
    }
    public static Set<String> getCacheRetirosCobrados() {
        return cacheRetirosCobrados;
    }
    public static void setCacheRetirosCobrados(Set<String> cacheRetirosCobrados) {
        Atm.cacheRetirosCobrados = cacheRetirosCobrados;
    }
    public ServiciosDAO getServiciosDAO() {
        return serviciosDAO;
    }
    public void setServiciosDAO(ServiciosDAO serviciosDAO) {
        this.serviciosDAO = serviciosDAO;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "models.Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                ", database=" + Arrays.toString(database) +
                ", cacheCuentas=" + cacheCuentas +
                '}';
    }

    // Métodos
    // throw: Va dentro de la lógica del metodo, crea o instancia la exception
    // throws: Va en la firma del metodo, propaga la exception
    public CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException { // Metodo que regresará un Objeto de dto.CuentaDTO, sino arroja exception
        CuentaDTO encontrado = null; // Declaramos variable para almacenar la entity.Cuenta
        // Buscamos dentro de la Lista "cacheCuentas" a la entity.Cuenta con el número de tarjeta y NIP ingresados
        for (int i = 0 ; i < cacheCuentas.size() ; i++) { // Recorremos la Lista con las cuentas
            if (cacheCuentas.get(i).getNumTarjeta().equals(numTarjeta) && cacheCuentas.get(i).getNip().equals(nip)) { // Si numCuenta y nip coinciden en una posición
                encontrado = cacheCuentas.get(i); // Lo almacenamos en la variable "encontrado"
                break; // Rompemos el ciclo, dejamos de buscar porque ya se encontró la cuenta
            }
        }
        if (encontrado != null) { // Si la cuenta existe...
            return encontrado; // Retornamos el Objeto de tipo cuenta que se encontró
        } else { // Si la cuenta no existe...
            throw new AccountNotFoundException(Constantes.ACCOUNT_NOT_FOUND);
        }
    }

    public void consultarSaldo(String numTarjeta, String nip) {
        CuentaDTO c = buscarCuenta(numTarjeta, nip);
        if (c != null) {
            System.out.println("Saldo en la cuenta: $" + c.getSaldo());
        } else {
            System.out.println("entity.Cuenta inexistente");
        }
    }

    private Cuenta[] cargarCuentas() { // Este metodo no se puede heredar, ya que es un miembro privado
        File file = new File("C:\\Users\\carlo\\OneDrive\\Escritorio\\cuentas.txt"); // Creamos archivo de tipo File
        String linea; // Variable para leer la línea completa, junta
        Cuenta cuenta; // Objeto temporal que guardará los datos de cada línea por separado
        Cuenta[] cuentas = new Cuenta[50]; // De antemano sabemos que leeremos 50 registros
        String[] datos; // Array que almacenará la información de cada línea ya separada con el metodo split()
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cuentas;
    }

    public void generarRetiroSinTarjeta() { // Metodo hecho sólo para automatizar la generación de los retiros asociándolos a una cuenta leída desde la db
        // ESTO ES SÓLO PARA SIMULAR DATOS
        // Generamos 5 retiros sin tarjeta
        for (CuentaDTO dto : getCacheCuentas()) {
            cacheRetiroSinTar.put(dto.getNumCuenta() + ":" + Helper.generarReferencia() + ":" + Helper.generarClave(), Double.parseDouble(Helper.generarMonto()));
        }
    }

    public abstract Ticket cobrarRetiroSinTarjeta(); // Metodo abstracto, por eso no tiene cuerpo (llaves)

    public void inspeccionarCacheRetirosDiarios() {
        for (String registro : cacheRetirosDiarios.keySet()) { // keySet() para iterar sobre el set de llaves del Mapa
            System.out.println(registro + ": $" + cacheRetirosDiarios.get(registro));
        }
    }
}