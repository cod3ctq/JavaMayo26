package dao;

import database.ConexionOracle; // Se importó esta Clase al crear paquetes
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

// DAO: Data Access Object
// Patrón de diseño DAO: Esta Clase encapsula la lógica de acceso a datos de los abonos de la db (consultas) en un sólo lugar
public class AbonoDAO {
    // Atributos
    Connection con = null; // Carga la conexión hacia la db
    PreparedStatement ps = null; // Intérprete, entrada de las sentencias a la db
    ResultSet rs = null; // Salida de los resultados, se almacenan aquí

    public boolean abonar(int prestamoId, double monto, int medioPagoId) {
        boolean ok = false;
        String query = "INSERT INTO ABONOS(PRESTAMO_ID, FECHA, MONTO, MEDIO_PAGO) VALUES(?, ?, ?, ?)";
        try {
            con = ConexionOracle.getInstance().getCon();
            ps = con.prepareStatement(query);
            ps.setInt(1, prestamoId);
            ps.setDate(2, Date.valueOf(LocalDate.now())); // "LocalDate.now()" sólo da la fecha, sin la hora
            ps.setDouble(3, monto);
            ps.setInt(4, medioPagoId);
            int x = ps.executeUpdate(); // Devuelve el número de filas modificadas
            if (x > 0) {
                System.out.println("Abono registrado correctamente");
                ok = true;
            } else {
                System.out.println("Error al registrar el abono");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ok;
    }
}