import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //Carga el cache de la
    public List<CuentaDTO> leerCuentas() {

        String query =
                "SELECT T.NUM_TARJETA, T.NIP, CU.CUENTA_ID, CU.NUM_CUENTA, CU.SALDO, " +
                        "TC.SALDO_MIN, TC.SALDO_MAX, CU.FECHA_AP, " +
                        "C.NOMBRE || ' ' || C.AP_P || ' ' || C.AP_M AS TITULAR " +
                        "FROM TARJETAS T " +
                        "INNER JOIN CUENTAS CU ON T.CUENTA_ID = CU.CUENTA_ID " +
                        "INNER JOIN CLIENTES C ON CU.CLIENTE_ID = C.CLIENTE_ID " +
                        "INNER JOIN TIPO_CUENTA TC ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";

        List<CuentaDTO> dtos = new ArrayList<>();

        try {
            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion a la base de datos
            System.out.println(">>>>>>>>>>> LLAMADA A LA BASE 1:"+con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                CuentaDTO dto = new CuentaDTO(
                        rs.getString("TITULAR"),
                        rs.getDate("FECHA_AP"),
                        rs.getDouble("SALDO_MAX"),
                        rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO"),
                        rs.getString("NUM_CUENTA"),
                        rs.getInt("CUENTA_ID"),
                        rs.getString("NIP"),
                        rs.getString("NUM_TARJETA")
                );

                dtos.add(dto);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return dtos;
    }

    public void actualizarSaldoCuenta(String numCuenta, double nuevoSaldo) {

        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ?";

        try {
            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion a la base de datos
            System.out.println(">>>>>>>>>>> LLAMADA A LA BASE X:"+con);;
            ps = con.prepareStatement(query);
            ps.setDouble(1, nuevoSaldo);
            ps.setString(2, numCuenta);

            int x = ps.executeUpdate();

            if (x > 0) {
                System.out.println("Saldo actualizado correctamente");
            } else {
                System.out.println("Error al actualizar saldo");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public double getSaldoCuenta(String numCuenta){
        String query = "SELECT SALDO FROM CUENTAS WHERE NUM_CUENTA='"+numCuenta+"'"; //'' porque dentro de sql el texto va dentro de comillas simples y estamos concatenando
        double saldo = 0.0;
        try {
            con = ConexionOracle.getInstance().getCon();//Apunta a la unica conexion a la base de datos
            System.out.println(">>>>>>>>>>> LLAMADA A LA BASE X:"+con);;
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                saldo = rs.getDouble("SALDO");
            }
        }catch(Exception ex){

        }
        return saldo;

}
}