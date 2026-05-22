import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public abstract class Atm {
    // Atributos
    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database; // Array que almacenará los Objetos de tipo Cuenta (esto es composición)
    private List<CuentaDTO> cacheCuentas = new ArrayList<>(); // Objeto que contendrá las cuentas tal como vienen de la db
    public static Map<String, Double> cacheRetirosDiarios = new HashMap<>(); // Se hace en esta clase porque ambos tipos de cajeros deben tener este atributo

    // Inyección de dependencias - manual
    // Se inyecta en esta Clase, aunque cualquiera que lo necesite puede usarlo
    private CuentaDAO cuentadao = new CuentaDAO(); // Creamos Objeto de CuentaDAO para que esta Clase lo pueda utilizar
    private MovimientoDAO movimientodao = new MovimientoDAO(); // Creamos Objeto de MovimientoDAO para que esta Clase lo pueda utilizar

    // Constructores
    public Atm() {
//        this.database = cargarCuentas(); // Cargamos cuentas al llamar al constructor, o sea cuando instanciemos un Objeto de tipo Atm
        this.cacheCuentas = cuentadao.leerCuentas(); // El constructor vacío llama a este metodo que llena el cache trayendo las cuentas de la db
    }
    public Atm(String direccion, String folio) {
        this.direccion = direccion;
        this.folio = folio;
        this.database = cargarCuentas(); // Cargamos cuentas al llamar al constructor, o sea cuando instanciemos un Objeto de tipo Atm
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
//    public Cuenta[] getDatabase() {
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

    // Metodo toString
    @Override
    public String toString() {
        return "Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                ", database=" + Arrays.toString(database) +
                ", cacheCuentas=" + cacheCuentas +
                '}';
    }

    // Métodos
    // throw: Va dentro de la lógica del metodo, crea o instancia la exception
    // throws: Va en la firma del metodo, propaga la exception
    public CuentaDTO buscarCuenta(String numTarjeta, String nip) throws AccountNotFoundException { // Metodo que regresará un Objeto de CuentaDTO, sino arroja exception
        CuentaDTO encontrado = null; // Declaramos variable para almacenar la Cuenta
        // Buscamos dentro de la Lista "cacheCuentas" a la Cuenta con el número de tarjeta y NIP ingresados
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
            System.out.println("Cuenta inexistente");
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

    public void generarRetiroSinTarjeta() {
    }

    public abstract void cobrarRetiroSinTarjeta(); // Metodo abstracto, por eso no tiene cuerpo (llaves)

    public void inspeccionarCacheRetirosDiarios() {
        for (String registro : cacheRetirosDiarios.keySet()) { // keySet() para iterar sobre el set de llaves del Mapa
            System.out.println(registro + ": $" + cacheRetirosDiarios.get(registro));
        }
    }
}