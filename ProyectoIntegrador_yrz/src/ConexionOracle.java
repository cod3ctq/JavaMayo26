import java.sql.Connection;
import java.sql.DriverManager;

//Patron Singleton: Limita la creación de instancias en un determinado tipo a solo 1 instancia
// que sera la unica a lo largo de todo el sistema
//garantiza el estado del objeto donde sea que se le llame
    public class ConexionOracle {

    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver = OracleProvider.DRIVER;
    private String url = OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;

    //Constructor privado: unico lugar donde instancia el objeto de esta clase
    // al ser privado, no puede accederse/invocarse en ningun otro lado fuera de la clase


    private ConexionOracle(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit((true)); //activa el autocommita para las operaciones (insert,delete,update)
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Metodo estatico a traves del cual obtendremos acceso
// siempre a la unica instacia de la conexion
    public static ConexionOracle getInstance() {
        return instancia;
    }

    public Connection getCon() {
        return connection;
    }
}


