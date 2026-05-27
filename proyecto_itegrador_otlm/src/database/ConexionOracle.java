package database;

import java.sql.Connection;
import java.sql.DriverManager;

//Patron singleton : Limita la creacion de instancias a un determiando tipo
// de instancia que sera la unica a lo largo de todo el sistema
//Garantiza el estado del onjeto donde sea que lo llame
public class ConexionOracle {
    private static ConexionOracle instancia = new ConexionOracle();
    private Connection connection;

    private String driver = OracleProvider.DRIVER;
    private String url = OracleProvider.URL;
    private String user = OracleProvider.USER;
    private String password = OracleProvider.PASSWORD;

    //Consructor provado : unico lugar donde se instancia el objeto de esta clase
    //al ser privado, no puede accederse/invocarse en ningun otro lado fuera de la clase
    private ConexionOracle() {
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            //Activa el autocmmit para l operaciones (INSERT, DELETE, UPDATE)
            connection.setAutoCommit(true);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //Metdo estatico a traves del cual obtendremos acceso
    //Siempre a la unica instancia de la conexion
    public static ConexionOracle getInstance(){
        return instancia;
    }

    //Dentro del objeto ConexionIracle(instancia) se accede a esta conexion configurada con los datos anteriores
    public Connection getCon(){
        return connection;
    }
}
