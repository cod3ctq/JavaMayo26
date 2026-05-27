package database;

// Clase que almacenará las variables necesarias con la información para la conexión a la db
public class OracleProvider {
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USER = "db1";
    public static final String PASSWORD = "admin";
}