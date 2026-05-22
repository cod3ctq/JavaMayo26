import java.sql.*;
import java.time.LocalDate;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de los movimientos de la db (consultas) en un sólo lugar
public class MovimientoDAO {
    // Atributos
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void registrarMovimiento(int cuentaId, String tipoOperacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) VALUES (?, ?, ?, ?)";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
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