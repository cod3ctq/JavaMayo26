package dao;

import dto.CuentaDTO; // Se importó esta Clase al crear paquetes
import database.ConexionOracle; // Se importó esta Clase al crear paquetes
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de las cuentas de la db (consultas) en un sólo lugar
public class CuentaDAO {
    // Atributos
    private Connection con = null; // Variable que almacenará el Objeto de tipo Connection
    private PreparedStatement ps = null; // Variable que almacenará la interpretación de la sentencia que queremos utilizar en la db
    private ResultSet rs = null; // Varible que almacenará el resultado de la consulta a la db

    public List<CuentaDTO> leerCuentas() { // Metodo para cargar el caché de las cuentas desde la DB a través de dto.CuentaDTO
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
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase database.ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            System.out.println(">>>>> LLAMADA A LA DB 1: " + con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(); // Se ejecuta la consulta
            while (rs.next()) { // Creamos Objeto de tipo dto.CuentaDTO
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
            // Llamamos a los métodos .getInstance() y .getCon() de la Clase database.ConexionOracle y almacenamos en variable de tipo Connection
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            System.out.println(">>>>> LLAMADA A LA DB X: " + con);
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
    public double getSaldoCuenta(String numCuenta) {
        String query = "SELECT SALDO FROM CUENTAS WHERE NUM_CUENTA = '" + numCuenta + "'";
        double saldo = 0.0;
        try {
            con = ConexionOracle.getInstance().getCon(); // Apunta a la única conexión a la db
            System.out.println(">>>>> LLAMADA A LA DB X: " + con);
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                saldo = rs.getDouble("SALDO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return saldo;
    }
}