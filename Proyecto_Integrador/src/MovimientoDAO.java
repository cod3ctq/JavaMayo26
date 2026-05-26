import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;

    public void registrarMovimientos(int cuentaId, String operacion, double monto) {

        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) " + "VALUES(?,?,?,?)";

        try {
            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion a la base de datos
            System.out.println(">>>>>>>>>>> LLAMADA A LA BASE Y:"+con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Movimiento registrado correctamente");
            } else {
                System.out.println("Error al insertar el movimiento");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}