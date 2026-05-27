package database;

import java.sql.Connection;
import java.sql.DriverManager;

//Patron SINGLETON: Limita la creacion de instancias de un determinado tipo a solo una instancia
//que sera la unica a lo largo de todo el sistema
//Garantiza el estado del objeto donde sea que se lo llame
public class ConexionOracle {

    //unica instancia de esta misma clase
    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver=OracleProvider.DRIVER;
    private String url=OracleProvider.URL;
    private String user=OracleProvider.USER;
    private String password= OracleProvider.PASSWORD;

    //Constructor privado: Unico lugar donde instancia el objeto de esta clase
    //al ser privado, no puede accederse/invocarse en ningun otro lado fuera de la clase
    private ConexionOracle(){

        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(true); //activar el autocommit para las operaciones (insert, delete, update)

        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    //Metodo estatico a traves del cual obtendremos acceso
    //siempre a la unica instancia de la conexion
    public static ConexionOracle getInstance(){
        return instancia;
    }

    //Dentro del objeto database.ConexionOracle(instancia) se accede a esta
    //conexion configurada con los datos anteriores
    public Connection getCon(){
        return connection;
    }

}
