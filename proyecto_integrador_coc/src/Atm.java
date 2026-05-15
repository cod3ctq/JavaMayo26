import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public abstract class Atm {
    // Atributos
    private String direccion;
    private String folio;
    public static int folioOperacion = 0;
    private Cuenta[] database; // Array que almacenará los Objetos de tipo Cuenta (esto es composición)
    // Constructores
    public Atm() {
        this.database = cargarCuentas(); // Cargamos cuentas al llamar al constructor, o sea cuando instanciemos un Objeto de tipo Atm
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
    public Cuenta[] getDatabase() {
        return database;
    }
    public void setDatabase(Cuenta[] database) {
        this.database = database;
    }
    // Metodo toString
    @Override
    public String toString() {
        return "Atm{" +
                "direccion='" + direccion + '\'' +
                ", folio='" + folio + '\'' +
                '}';
    }

    // Métodos
    public Cuenta buscarCuenta(String numTarjeta, String nip) { // Metodo que regresará un Objeto de tipo Cuenta
        Cuenta encontrado = null; // Declaramos variable para almacenar la Cuenta
        // Buscamos dentro del Array database a la Cuenta con el número de tarjeta y NIP ingresados
        for (int i = 0 ; i < database.length ; i++) { // Recorremos el array de Cuentas
            if (database[i].getNumTarjeta().equals(numTarjeta) && database[i].getNip().equals(nip)) { // Si numCuenta y nip coinciden en una posición
                encontrado = database[i]; // Lo almacenamos en la variable "encontrado"
                break; // Rompemos el ciclo, dejamos de buscar porque ya se encontró la Cuenta
            }
        }
        return encontrado;
    }

    public void consultarSaldo(String numTarjeta, String nip) {
        Cuenta c = buscarCuenta(numTarjeta, nip);
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
}