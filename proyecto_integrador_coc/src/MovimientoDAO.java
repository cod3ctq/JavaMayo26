import java.sql.*;
import java.time.LocalDate;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de los movimientos de la db (consultas) en un sólo lugar
public class MovimientoDAO {
    // Atributos
    private Connection con = null; // Variable que almacenará el Objeto de tipo Connection
    private PreparedStatement ps = null; // Variable que almacenará la interpretación de la sentencia que queremos utilizar en la db
    private ResultSet rs = null; // Varible que almacenará el resultado de la consulta a la db

    public void registrarMovimiento(int cuentaId, String tipoOperacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) VALUES (?, ?, ?, ?)";
        try {
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            System.out.println(">>>>> LLAMADA A LA DB Y: " + con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, tipoOperacion);
            ps.setDate(3, Date.valueOf(LocalDate.now())); // Se registra en automático la fecha del momento
            ps.setDouble(4, monto);
            int x = ps.executeUpdate(); // Se ejecuta la actualización y devuelve el número de filas que fueron afectadas por el UPDATE
            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al registrar el movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}