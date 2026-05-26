import java.sql.*;
import java.time.LocalDate;

public class MovimientoDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void registrarMoviento(int cuentaId, String operacion, double monto){

        String query = "INSERT INTO MOVIMIENTOS(CUENTA_ID, TIPO, FECHA_OP, MONTO) VALUES(?,?,?,?)";

        try{

            con = ConexionOracle.getInstance().getCon();    //Apunta a la unica conexion de la db
            System.out.println(">>>>>>>>>>>>>>>>>>>>LAMADA A LA BASE Y:"+con);
            ps = con.prepareStatement(query);
            ps.setInt(1, cuentaId);
            ps.setString(2, operacion);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDouble(4, monto);
            int x = ps.executeUpdate();

            if (x>0){
                System.out.println("Moviento registrado correctamente");
            }else{
                System.out.println("Error al insettar movimiento");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
