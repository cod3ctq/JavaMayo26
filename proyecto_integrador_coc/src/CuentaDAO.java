import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de las cuentas de la db (consultas) en un sólo lugar
public class CuentaDAO {
    // Atributos
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<CuentaDTO> leerCuentas() { // Metodo para cargar el caché de las cuentas desde la DB a través de CuentaDTO
        String query = "SELECT T.NUM_TARJETA, T.NIP, CU.CUENTA_ID, CU.NUM_CUENTA, CU.SALDO, TC.SALDO_MIN, TC.SALDO_MAX, CU.FECHA_AP, C.NOMBRE || ' ' || C.AP_P || ' ' || C.AP_M AS TITULAR " +
                "FROM TARJETAS T " +
                "INNER JOIN CUENTAS CU " +
                "ON T.CUENTA_ID = CU.CUENTA_ID " +
                "INNER JOIN CLIENTES C " +
                "ON C.CLIENTE_ID = CU.CLIENTE_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<CuentaDTO> dtos = new ArrayList<>();
        CuentaDTO dto = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); // Se ejecuta la consulta
            while (rs.next()) { // Creamos Objeto de tipo CuentaDTO
                dto = new CuentaDTO(rs.getString("NUM_TARJETA"), rs.getString("NIP"), rs.getInt("CUENTA_ID"),
                        rs.getString("NUM_CUENTA"), rs.getDouble("SALDO"), rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO_MAX"), rs.getDate("FECHA_AP"),rs.getString("TITULAR"));
                dtos.add(dto); // Agregamos a la Lista el Objeto que se creó
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dtos;
    }
    public void actualizarSaldoCuenta(String numCuenta, double nuevoSaldo) { // Metodo para actualizar los saldos de las cuentas en la db
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query);
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);
            int x = ps.executeUpdate(); // Se ejecuta la actualización y devuelve el número de filas que fueron afectadas por el UPDATE
            if (x > 0) { // Este if es sólo para verificar que haya funcionado la actualización, no es necesario
                System.out.println("Saldo actualizado correctamente");
            } else {
                System.out.println("Error al actualizar el saldo");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}