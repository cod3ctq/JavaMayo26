import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Patron de diseño DAO_ Data Access Object
//Encapsula la logica de acceso a datos (consultas) en un solo lugar
public class CuentaDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    //cargar el cache de las cuentas a traves del CuentaDTO

    public List<CuentaDTO> leerCuentas(){//Esto es un metodo

        String query="SELECT T.NUM_TARJETA, T.NIP, CU.CUENTA_ID, CU.NUM_CUENTA, CU.SALDO, TC.SALDO_MIN, TC.SALDO_MAX, " +
                "CU.FECHA_AP, C.NOMBRE || ' ' || C.AP_P || ' ' || C.AP_M AS TITULAR " +
                "FROM TARJETAS T INNER JOIN CUENTAS CU " +
                "ON T.CUENTA_ID = CU.CUENTA_ID " +
                "INNER JOIN CLIENTES C " +
                "ON CU.CLIENTE_ID = C.CLIENTE_ID " +
                "INNER JOIN TIPO_CUENTA TC " +
                "ON CU.TIPO_CUENTA_ID = TC.TIPO_CUENTA_ID";
        List<CuentaDTO> dtos = new ArrayList<CuentaDTO>();
        CuentaDTO dto = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()){
                dto = new CuentaDTO(rs.getString("NUM_TARJETA"), rs.getString("NIP"),
                        rs.getInt("CUENTA_ID"), rs.getString("NUM_CUENTA"),
                        rs.getDouble("SALDO"), rs.getDouble("SALDO_MIN"),
                        rs.getDouble("SALDO_MAX"), rs.getDate("FECHA_AP"),
                        rs.getString("TITULAR"));
                dtos.add(dto);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return dtos;
    }

    public void actualizarSaldoCuenta(String numCuenta, double nuevoSaldo){
        String query = "UPDATE CUENTAS SET SALDO = ? WHERE NUM_CUENTA = ? ";

        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","db1","admin");
            ps = con.prepareStatement(query);
            ps.setDouble(1,nuevoSaldo);
            ps.setString(2, numCuenta);
            int x = ps.executeUpdate();

            if (x>0){
                System.out.println("Saldo actualizado correctamente");
            }else {
                System.out.println("Error al actualizar saldo");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
