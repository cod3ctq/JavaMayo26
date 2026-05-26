import java.sql.Connection;
import java.sql.DriverManager;

//patron singleton: limita la creacion de instancias de un determinado tipo a solo 1 instancia
// que sera la unica a lo largo de todo el sistema
//garantiza el estado del objeto donde sea que se lo llame
public class ConexionOracle {
    //unica instancia de esta misma clase
    private static  ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver=OracleProvider.DRIVER;
    private String url=OracleProvider.URL;
    private String user=OracleProvider.USER;
    private String password=OracleProvider.PASSWORD;


    //constructor privado: unico lugar donde instancia el objeto de sta clase
    //al ser privado, no puede accederse/invocarse en ningun otro lado fuera de la clase
    private ConexionOracle(){

        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(true);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //metodo estatico a traves  del cual obtendremos acceso
    //siempre a la unica instancia de la conexion
    public static ConexionOracle getInstance(){
        return instancia;
    }
    //dentro del objeto conecionOracle(insrancia) se accede a esta
    //conexion configurada con los datos anteriores
    public Connection getCon(){
        return connection;
    }
}
