import java.sql.Connection;
import java.sql.DriverManager;

//PATRON SINGLETON : Limita la creacion de instancias de un determinado tipo a solo una instancia
//Que sera unica a lo largo de todo el sistema.
//Garantiza el estado del objeto donde sea que se le llame
public class ConexionOracle {
    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver =OracleProvider.DRIVER;
    private String url =OracleProvider.URL;
    private String user =OracleProvider.USER;
    private String password =OracleProvider.PASSWORD;

    //constructor privado :unico lugar donde instancia el objeto de esta clase
    //Al ser privado, no puede accederse/invocarse en ningun otro lado fuera de la clase
    private ConexionOracle() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(true); //activa el autocommit para las operaciones(INSERT,DELETE,UPDATE)
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //metodo estatico a traves del cual obtendremos accesso
    //siempre a la unica isntancia de la conexion
    public static ConexionOracle getInstance() {
        return instancia;
    }

    //Dentro del objeto ConexionOracle(instancia) se accede a este
    //conexcion configurada con los datos anteriores
    public Connection getCon() {
        return connection;
    }

}
