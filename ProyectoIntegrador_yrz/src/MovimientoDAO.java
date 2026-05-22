import java.sql.*;
import java.time.LocalDate;


public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public void registrarMocimiento(int cuentaId, String operacion, double monto) {
        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO)VALUES(?,?,?,?)";

        try {

            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1", "admin");
            ps = con.prepareStatement(query);
            // estas operacion son para acompletar el query
            //aqui se asigna con el primer marcador de posicion, y se acuatliza nuevo saldo
            ps.setDouble(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();
            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al insertar movimiento");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
