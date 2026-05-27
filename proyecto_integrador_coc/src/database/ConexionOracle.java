package database;

import java.sql.Connection;
import java.sql.DriverManager;

// Patrón de diseño Singleton: Limita la creación de instancias de un determinado tipo...
// ... a sólo una instancia que será la única a lo largo de toda la ejecución del sistema
// Garantiza el estado del Objeto donde sea que se le llame
public class ConexionOracle {
    private static ConexionOracle instancia = new ConexionOracle(); // Instanciamos Objeto de esta misma Clase
    private Connection connection; // Variable que almacenará el Objeto de tipo Connection

    private String driver = OracleProvider.DRIVER; // Asignamos los valores de las constantes definidas en la Clase database.OracleProvider
    private String url = OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;

    // Constructor privado: único lugar en donde se instancia el Objeto de esta Clase
    // Al ser privado, no puede accederse/invocarse en ningún otro lugar fuera de esta Clase
    private ConexionOracle() {
        try {
            Class.forName(driver); // Cargamos el driver, necesitamos descargarlo de Oracle
            connection = DriverManager.getConnection(url, user, password); // Creamos y almacenamos el Objeto de tipo Connection
            connection.setAutoCommit(true); // Activa el autocommit para las operaciones INSERT, DELETE, UPDATE
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Metodo estático a través del cual obtendremos acceso siempre a la única instancia de la conexión
    public static ConexionOracle getInstance() {
        return instancia;
    }
    // Dentro del Objeto database.ConexionOracle(instancia) se accede a esta conexión configurada con los datos anteriores
    public Connection getCon() {
        return connection;
    }
}